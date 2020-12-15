package thread.synchronize;

import java.util.concurrent.CountDownLatch;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月3日
 * 类  描  述 : //
 * 修改历史 : 
 *     1. [2017年7月3日]创建文件 by lwk
 */
public class VolatileNoAtomic extends Thread {
    private volatile static int count;
//    private static int count;
    private static void addCount(){
        for(int i=0;i<100;i++){
            // ++不是原子操作有并发问题
//            count++;
            System.out.println(++count);
        }
//        System.out.println(Thread.currentThread().getName()+","+count);
    }
    
    @Override
    public void run() {
        addCount();
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[10];

        for(int i=0;i<10;i++){
            arr[i] = new VolatileNoAtomic();
        }
        for(int i=0;i<10;i++){
            arr[i].start();
            // 顺序执行
//            arr[i].join();
        }
    }
}
