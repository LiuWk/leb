package thread.synchronize;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * leb测试用源代码
 * <p>
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月3日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 :
 * 1. [2017年7月3日]创建文件 by lwk
 */
public class AtomicNoVolatile extends Thread {
    private static AtomicInteger count = new AtomicInteger(0);//原子操作的类

    private void addCount() {
        for (int i = 0; i < 10; i++) {
            System.out.println(count.incrementAndGet());
        }
        // 多线程get不能保证是取出的for循环里面增加的total
//        System.out.println(Thread.currentThread().getName() + "," + count.get());
    }

    @Override
    public void run() {
        addCount();
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicNoVolatile[] arr = new AtomicNoVolatile[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new AtomicNoVolatile();
        }
        for (int i = 0; i < 10; i++) {
            arr[i].start();
            // 顺序执行
//            arr[i].join();
        }
    }
}
