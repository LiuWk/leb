package thread.providerconsumer;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月6日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月6日]创建文件 by lwk
 */
public class Queue {
    private static LinkedBlockingQueue<Object> q = new LinkedBlockingQueue<>(5);

    private final Object lock = new Object();

    private static AtomicInteger count = new AtomicInteger(0);

    public void produce(Object obj) {
        synchronized (lock) {
            if (q.size() > 4) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            q.add(obj);
            lock.notify();

            System.out.println("生成了一个对象" + obj + "," + count.incrementAndGet());
        }
    }

    public void consume() {
        synchronized (lock) {
            if (q.size() == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object o = q.poll();
            lock.notify();
            System.out.println("消费了一个对象" + o);
        }
    }

}
