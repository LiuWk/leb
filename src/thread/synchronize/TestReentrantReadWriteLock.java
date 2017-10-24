package thread.synchronize;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月11日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月11日]创建文件 by lwk
 */
public class TestReentrantReadWriteLock {
    
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    private ReadLock read = lock.readLock();
    
    private WriteLock write = lock.writeLock();
    
    public void read(){
        try {
            read.lock();
            System.out.println("当前线程"+Thread.currentThread().getName()+"进入");
            Thread.sleep(3000);
            System.out.println("当前线程"+Thread.currentThread().getName()+"结束.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            read.unlock();
        }
    }
    
    public void write(){
        try {
            write.lock();
            System.out.println("当前线程"+Thread.currentThread().getName()+"进入");
            Thread.sleep(3000);
            System.out.println("当前线程"+Thread.currentThread().getName()+"结束.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            write.unlock();
        }
    }
     
    public static void main(String[] args) {
        TestReentrantReadWriteLock t = new TestReentrantReadWriteLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.read();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.read();
            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.write();
            }
        },"t3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.write();
            }
        },"t4");
        
//        t1.start();
//        t2.start();//读读不影响
        
//        t1.start();
//        t3.start();//读写互斥
        
        t3.start();
        t4.start();//写写互斥
    }

}
