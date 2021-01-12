package redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * leb测试用源代码
 * <p>
 * 项目名称 : design_patterns
 * 创建日期 : 2017年8月16日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 :
 * 1. [2017年8月16日]创建文件 by lwk
 */
public class TestRedis {

    private static String host = "192.168.6.1";
    private static int port = 6379;

    /**
     * //TODO 添加方法功能描述
     * maxActive：最大连接数
     * maxIdle：最多空闲数
     * whenExhaustedAction：连接数上限的拒绝策略。
     *  WHEN_EXHAUSTED_FAIL --> 抛异常；
     *  WHEN_EXHAUSTED_BLOCK --> 排队，队满抛异常；
     *  WHEN_EXHAUSTED_GROW --> 继续分配，maxActive参数无效；
     * maxWaitMillis：
     * 表示当borrow一个jedis实例时，从连接池获取连接最大的等待时间，连接池满的情况下，会一直阻塞，
     * 如果超过等待时间，则直接抛出JedisConnectionException，配置类为JedisPoolConfig，单位ms，缺省-1；
     * <p>
     * connectionTimeout：
     * 连接超时时间，底层的Socket超时时间，在底层创建连接的时候才会使用，缺省2000。
     *
     * @param args 2017年8月16日 by lwk
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String redisNodes = "10.240.169.112:7000,10.240.169.112:7001,10.240.169.112:7002,10.240.169.112:7003,10.240.169.112:7004,10.240.169.112:7005";
        String[] addresses = redisNodes.split(",");
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        for (String address : addresses) {
            String[] addr = address.split(":");
            jedisClusterNodes.add(new HostAndPort(addr[0], Integer.parseInt(addr[1])));
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(500);
        poolConfig.setMaxIdle(200);
        poolConfig.setMaxWaitMillis(3000);
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 1000, poolConfig);
        // 集合差集
        String key1 = "{s}test_set1";
        String key2 = "{s}test_set2";
        jedisCluster.sadd(key1, "111", "222", "333");
        jedisCluster.sadd(key2, "444", "222", "333");
        System.out.println(jedisCluster.smembers(key1));
        System.out.println(jedisCluster.smembers(key2));

        Set<String> set = jedisCluster.sdiff(key1, key2);
        System.out.println(JSONObject.toJSONString(set));


        String result = jedisCluster.setex("q1", 5, "lock");
    }

}
