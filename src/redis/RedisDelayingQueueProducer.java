package redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.UUID;

/**
 * 【Redis 深度历险：核心原理与应用实践】书中延时队列demo
 *
 * @author Administrator
 */
@Slf4j
public class RedisDelayingQueueProducer<T> {
    static class TaskItem<T> {
        public String id;
        public T msg;
        public Long delayMillis;
    }

    // fastjson 序列化对象中存在 generic 类型时，需要使用 TypeReference
    private Type TaskType = new TypeReference<TaskItem<T>>() {
    }.getType();
    private Jedis jedis;
    private String queueKey;

    public RedisDelayingQueueProducer(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg, long delayMillis) {
        TaskItem<T> task = new TaskItem<>();
        task.id = UUID.randomUUID().toString(); // 分配唯一的 uuid
        task.msg = msg;
        task.delayMillis = delayMillis;
        String s = JSON.toJSONString(task); // fastjson 序列化
        jedis.zadd(queueKey, delayMillis, s); // 塞入延时队列 ,5s 后再试
    }


    public static void main(String[] args) {
        String host = "10.240.169.111";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        RedisDelayingQueueProducer queue = new RedisDelayingQueueProducer<>(jedis, "q-demo");
        Long[] longs = {5000L, 10000L, 60000L};
        long time = System.currentTimeMillis();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.delay("codehole" + i, time + longs[RandomUtils.nextInt(0, 3)]);
            }
        });
        producer.start();
        log.info("producer end");
        try {
            // main线程等待produce执行完成
            producer.join();
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            jedis.quit();
            jedis.close();
        }
    }
}