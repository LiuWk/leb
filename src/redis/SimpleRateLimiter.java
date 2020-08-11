package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * redis 限流思路，滑动窗口，zset结构
 *
 * @author Administrator
 */
public class SimpleRateLimiter {
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("hist:%s:%s", userId, actionKey);
        // 当前时间
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        Response<Long> count = null;
        try {
            pipe.multi();
            // 行为记录
            pipe.zadd(key, nowTs, "" + nowTs);
            // 移除时间窗口之前的行为记录，剩下的都是时间窗口内的
            pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
            // 获取窗口内的行为数量
            count = pipe.zcard(key);
            // 设置 zset 过期时间，避免冷用户持续占用内存
            // 过期时间应该等于时间窗口的长度，再多宽限 1s
            pipe.expire(key, period + 1);
            // 批量执行
            pipe.exec();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pipe.close();
        }
        assert count != null;
        // 比较数量是否超标
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("10.240.169.111", 6379);
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            // 60秒内最大次数
            System.out.println(limiter.isActionAllowed("laoqian", "reply", 60, 5));
        }
        jedis.close();
    }
}
