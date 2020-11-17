package redis;

import org.apache.commons.lang3.RandomUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * redis延时demo
 */
public class RedisDelayQueue {
    public static void main(String[] args) throws InterruptedException {
        //连接信息
        String host = "10.240.169.111";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);

        //Key(键)
        String key = "RedisDelayQueue";
        //清除可能的已有数据
        jedis.del(key);
        // 随机生成消息
        for (int i = 0; i < 10; i++) {
            String member = "userID" + i;
            // 当前时间随机
            double score = (System.currentTimeMillis() - RandomUtils.nextInt(1000, 5000)) ;
            System.out.println("用户ID：" + member + "， 发信时间: " + score);
            //将玩家的ID和得分，都加到对应key的SortedSet中去
            jedis.zadd(key, score, member);
        }
        System.out.println();
        System.out.println("       " + key);
        System.out.println("       全部数据                    ");
        // 返回所有成员的排名
        Set<Tuple> scoreList = jedis.zrevrangeWithScores(key, 0, -1);
        for (Tuple item : scoreList) {
            System.out.println("用户ID：" + item.getElement() + "， 发信时间:" + item.getScore());
        }
        Thread.sleep(2000);

        // 最近三秒钟时间
        double end = System.currentTimeMillis() ;
        double start = end - 5000;
        System.out.println("start=" + start + ",end=" + end);
        /**
         * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。
         * 有序集成员按 score 值递减(从大到小)的次序排列。
         */
        Set<String> result = jedis.zrangeByScore(key, start, end);
        System.out.println("三秒钟之前的数据");
//        result.forEach(item -> System.out.println("用户ID：" + item.getElement() + "， 发信时间:" + item.getScore()));
        result.forEach(System.out::println);

        jedis.quit();
        jedis.close();
    }
}
