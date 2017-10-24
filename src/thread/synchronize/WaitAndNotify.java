package thread.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月3日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月3日]创建文件 by lwk
 */
public class WaitAndNotify {
    private volatile static List<String> list = new ArrayList<>();

    public void add() {
        list.add("aaa");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {

        final WaitAndNotify wn = new WaitAndNotify();
        final Object lock = new Object();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {

                        for (int i = 0; i < 10; i++) {
                            wn.add();
                            System.out.println(Thread.currentThread().getName() + "添加数据");
                            Thread.sleep(500);
                            if (wn.size() == 5) {
                                lock.notify();// 通知其他线程,不释放锁，不能实时通知
                                System.out.println("发出通知");
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        if (wn.size() != 5) {
                            lock.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + "接收到通知");
                        throw new RuntimeException();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");

        t2.start();
        t1.start();

    }
}
