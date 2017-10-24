package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月10日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月10日]创建文件 by lwk
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        
        final CountDownLatch countDown = new CountDownLatch(2);
        
        Thread t1 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("t1线程开始");
                try {
                    countDown.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1线程继续执行。。");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("线程t2开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDown.countDown();
                System.out.println("线程t2执行完成");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("线程t3开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDown.countDown();
                System.out.println("线程t3执行完成");
            }
        });
        
        t1.start();
        t2.start();
        t3.start();
    }

}
