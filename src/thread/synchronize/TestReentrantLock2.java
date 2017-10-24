package thread.synchronize;

import java.util.concurrent.locks.Condition;
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
public class TestReentrantLock2 {
    // 同一个锁对象
    private final static Lock lock = new ReentrantLock();

    private final static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                method1();
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                method2();
            }
        }, "t2");
        t2.start();
    }

    public static void method1() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "线程等待");
            Thread.sleep(5000);
            condition.await();//使当前线程等待,同时释放当前锁
            System.out.println(Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "线程开始");
            Thread.sleep(5000);
            condition.signal();//相当于notify
            System.out.println(Thread.currentThread().getName() + "继续执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
