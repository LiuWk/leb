package thread.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月22日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月22日]创建文件 by lwk
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        // 同一个锁对象
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            System.out.println(lock.tryLock());
            MyThread2 t = new MyThread2(i, lock);
            t.start();
        }
    }
}

class MyThread2 extends Thread {
    private int i;

    private Lock lock = null;

    public void run() {
        lock.lock();
        try {
            RLock rl = new RLock();
            rl.test(i);
        } catch (Exception e) {
            System.out.println("Exception.");
        } finally {
            lock.unlock();
        }
    }

    public MyThread2(int i, Lock lock) {
        this.i = i;
        this.lock = lock;
    }
}

class RLock {
    public void test(int i) {
        System.out.println("test" + i + "开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("test" + i + "结束..");
    }

}
