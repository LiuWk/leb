package thread.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月5日
 * 类  描  述 : SynchronousQueue:特殊的BlockingQueue,对其的操作必须是放和取交替完成的.
 * 修改历史 : 
 *     1. [2017年7月5日]创建文件 by lwk
 */
public class TestSynchronousQueue {
 
    public static void main(String[] args) {
        SynchronousQueue<String> q = new SynchronousQueue<>();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("队列：" + q.toString());
                    System.out.println(q.getClass().hashCode() + "," + q.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                q.add("aaa");
                /**
                 * add方法可以使用，前提是有线程在take数据。
                 * add是不添加元素到q里面的
                 */
                System.out.println("队列：" + q.toString());
                System.out.println(q.getClass().hashCode());
            }
        });
        t2.start();
        //        Thread t3 = new Thread(new Runnable() {
        //            
        //            @Override
        //            public void run() {
        //                System.out.println(Thread.currentThread().getName());
        //            }
        //        },"t3");
        //        Thread t4 = new Thread(new Runnable() {
        //            
        //            @Override
        //            public void run() {
        //                System.out.println(Thread.currentThread().getName());
        //            }
        //        },"t4");
        //        t3.start();
        //        t4.start();
    }

}
