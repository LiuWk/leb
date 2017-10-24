package thread.synchronize;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月22日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月22日]创建文件 by lwk
 */
public class TestSynchronized2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                B b = new B();
                try {
                    b.reduceB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

class A {
    protected int i = 10;

    protected synchronized void reduceA() throws InterruptedException {
            i--;
            System.out.println("A:" + i);
            Thread.sleep(100);
    }
}

class B extends A {
    protected synchronized void reduceB() throws InterruptedException {
        while (i > 0) {
            i--;
            System.out.println("B:" + i);
            Thread.sleep(100);
            this.reduceA();
        }
    }
}
