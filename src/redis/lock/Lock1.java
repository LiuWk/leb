package redis.lock;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

/**
 * redis执行lua脚本命令
 * EVAL script numkeys key [key ...] arg [arg ...]
 * key [key ...]，是要操作的键，可以指定多个，在lua脚本中通过 KEYS[1],KEYS[2]获取
 * arg [arg ...]，参数，在lua脚本中通过ARGV[1], ARGV[2]获取。
 */
public class Lock1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.240.169.111", 6379);
        String key = "test-lock";
        String value = UUID.randomUUID().toString();
        try {
            if (lock2(jedis, key, value, 30000)) {
                System.out.println("get lock.");
                Thread.sleep(4000);
                System.out.println("main end.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("releaseLock="+releaseLock(jedis, key, value));
        }
    }

    public static void lock1(Jedis jedis, String lockKey, String requestId, int expireTime) {
        try {
            Long result = jedis.setnx(lockKey, requestId);
            if (result == 1) {
                // 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
                jedis.expire(lockKey, expireTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static boolean lock2(Jedis jedis, String lockKey, String value, int expireTime) {
        String result = jedis.set(lockKey, value, "NX", "PX", expireTime);
        if ("OK".equals(result)) {
            return true;
        }
        return false;
    }

    // lua脚本，用来释放分布式锁
    public static boolean releaseLock(Jedis jedis, String key, String lockValue) {
        if (key == null || lockValue == null) {
            return false;
        }
        String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        try {
            Object res = jedis.eval(luaScript, Collections.singletonList(key), Collections.singletonList(lockValue));
            return Long.valueOf("1").equals(res);
        } catch (Exception e) {
            return false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
