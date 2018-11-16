package thread;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月5日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月5日]创建文件 by lwk
 */
public class TestThreadRunable {
    final static Object lock = new Object();

    public static void main(String[] args) {
//                Thread1 t1 = new Thread1();
//                t1.start();
//                Thread1 t2 = new Thread1();
//                t2.start();

        System.out.println("方法返回到Java虚拟机的可用的处理器数量："+Runtime.getRuntime().availableProcessors());
        Runnable r = new Thread2();
        Thread r1 = new Thread(r);
        Thread r2 = new Thread(r);
        Thread r3 = new Thread(r);
        r1.start();
        r2.start();
        r3.start();
    }

}

class Thread1 extends Thread {
    private volatile int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "--" + (count--));
            }
        }
    }
}

class Thread2 implements Runnable {
    private volatile int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "--" + (count--));
            }
        }
    }
}
