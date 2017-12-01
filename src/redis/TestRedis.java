package redis;

import redis.clients.jedis.Jedis;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年8月16日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年8月16日]创建文件 by lwk
 */
public class TestRedis {

    private static String host="192.168.6.1";
    private static int port=6379;

    /**
     * //TODO 添加方法功能描述
     * @param args
     * 2017年8月16日 by lwk 
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Jedis jedis = new Jedis(host, port);
        jedis.set("1", "111");
        System.out.println(jedis.get("1"));
    }

}
