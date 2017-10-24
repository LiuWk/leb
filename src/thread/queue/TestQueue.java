package thread.queue;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月4日
 * 类  描  述 : 用wait和notify模拟BlockingQueue
 * 修改历史 : 
 *     1. [2017年7月4日]创建文件 by lwk
 */
public class TestQueue {
    private final LinkedList<Object> list = new LinkedList<Object>();

    //计数器
    private final AtomicInteger count = new AtomicInteger(0);

    //
    private final int minSize = 0;

    private final int maxSize;

    //锁
    private final Object lock = new Object();

    TestQueue(int length) {
        this.maxSize = length;
    }

    public void put(Object obj) {
        synchronized (lock) {
            if (count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj);
            count.incrementAndGet();//计数器++
            System.out.println("添加元素：" + obj);
            lock.notify();
        }
    }

    public Object take() {
        Object obj = null;
        synchronized (lock) {
            if (count.get() == minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            obj = list.removeFirst();
            count.decrementAndGet();//计数器--
            System.out.println("取元素：" + obj);
            lock.notify();//通知其他线程可以put(但不释放锁)
        }

        return obj;
    }

    public static void main(String[] args) {
        TestQueue tq = new TestQueue(4);
        tq.put("1");
        tq.put("2");
        tq.put("3");
        tq.put("4");
        System.out.println(tq);
        new Thread(new Runnable() {
            @Override
            public void run() {
                tq.put("33");
                tq.put("44");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(tq.take());
                }
            }
        }).start();

    }

}
