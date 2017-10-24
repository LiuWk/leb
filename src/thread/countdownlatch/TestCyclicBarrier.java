package thread.countdownlatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月10日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月10日]创建文件 by lwk
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {
        //3，代表barrier.await();的数量，达到这个数，等待中的线程自动一起开始执行
        final CyclicBarrier barrier = new CyclicBarrier(3);
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("t1等待执行..");
                try {
                    Thread.sleep(5000);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("t1执行完毕");
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("t2等待执行..");
                try {
                    Thread.sleep(5000);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("t2执行完毕");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t3等待执行..");
                try {
                    Thread.sleep(5000);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("t3执行完毕");
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public Void test(){
        return null;
        
    }
}
