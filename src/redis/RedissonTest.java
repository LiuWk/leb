package redis;

import org.redisson.Redisson;
import org.redisson.RedissonMultiLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RedissonTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        // connects to 127.0.0.1:6379 by default
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer()
                // use "rediss://" for SSL connection
                .setAddress("redis://10.240.169.111:6379");
        RedissonClient client1 = Redisson.create(config);
        RedissonClient client2 = Redisson.create(config);


        RLock lock1 = client1.getLock("lock1");
        RLock lock2 = client1.getLock("lock2");
        RLock lock3 = client2.getLock("lock3");
        /*Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            lock1.unlock();
            client1.shutdown();
            client2.shutdown();
            System.out.println("shutdown.");
        }));

        Thread t1 = new Thread(() -> {
            lock1.lock(60, TimeUnit.SECONDS);
            for (int i = 0; i < 10; i++) {
                System.out.println("t1->"+i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(() -> {
            lock1.lock(60, TimeUnit.SECONDS);
            for (int i = 0; i < 5; i++) {
                System.out.println("t2->"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            lock1.unlock();
        });

        t1.start();
//        t1.join();
        t2.start();
//        t2.join();*/


        Thread t1 = new Thread() {
            @Override
            public void run() {
                lock3.lock();
                System.out.println("t1");
            };
        };
        t1.start();
        t1.join();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                RedissonMultiLock lock = new RedissonRedLock(lock1, lock2, lock3);
                lock.lock();
                try {
                    System.out.println("t2");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                lock.unlock();
            };
        };
        t2.start();
        t2.join(1000);

        lock3.forceUnlock();


        client1.shutdown();
        client2.shutdown();

    }
}
