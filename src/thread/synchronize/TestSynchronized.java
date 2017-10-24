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
public class TestSynchronized {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            MyThread t = new MyThread(i);
            t.start();
        }
    }
}

class MyThread extends Thread {
    private int i;

    public void run() {
        Sync sync = new Sync();
        sync.test(i);
    }

    public MyThread(int i) {
        this.i = i;
    }
}

class Sync {
        public static synchronized void test(int i) {
            System.out.println("test"+i+"开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test"+i+"结束..");
        }
//    public void test(int i) {
//        synchronized (Sync.class) {
//            System.out.println("test" + i + "开始..");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test" + i + "结束..");
//        }
//    }

}
