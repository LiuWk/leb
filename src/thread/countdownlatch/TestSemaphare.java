package thread.countdownlatch;

import java.util.concurrent.Semaphore;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月10日
 * 类  描  述 : Semaphore可以控制某个资源可被同时访问的个数，通过 acquire() 获取一个许可，
 *              如果没有就等待，而 release() 释放一个许可。
 * 修改历史 : 
 *     1. [2017年7月10日]创建文件 by lwk
 */
public class TestSemaphare {

    public static void main(String[] args) {
        final Semaphore s = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            final int NO = i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        // 获取许可
                        s.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完后，释放
                        s.release();
                        System.out.println("-----------------" + s.availablePermits());//可以的许可数
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

}
