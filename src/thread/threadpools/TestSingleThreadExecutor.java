package thread.threadpools;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月23日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月23日]创建文件 by lwk
 */
public class TestSingleThreadExecutor {

    /**
     * //TODO 添加方法功能描述
     * @param args
     * 2017年6月23日 by lwk 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
//        ExecutorService exc = Executors.newSingleThreadExecutor();
        ExecutorService exc = Executors.newFixedThreadPool(2);
        TestThread t1 = new TestThread("t1");
        TestThread t2 = new TestThread("t2");
        TestThread t3 = new TestThread("t3");
        TestThread t4 = new TestThread("t4");
        exc.execute(t1);
        exc.execute(t2);
        exc.execute(t3);
        exc.execute(t4);

        exc.shutdown();
    }

}

class TestThread implements Runnable {
    private String name;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
//            Thread.currentThread().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run：" + Thread.currentThread().getName());
    }
    public TestThread(String name) {
        this.name = name;
    }

}
