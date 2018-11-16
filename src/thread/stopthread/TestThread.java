package thread.stopthread;

/**
 * 如何安全的停止线程
 *
 * @author lwk
 * @createTime 2018-11-15 10:10
 **/
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main线程启动了");
        Thread thread = new Thread("test") {
            @Override
            public void run() {
                System.out.println("thread线程启动了");
                try {
                    while (!isInterrupted()) {
                        sleep(1000);
                        System.out.println(this.getName() + "," + System.currentTimeMillis());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("哈哈，thread被中断了：" + isInterrupted());//这里的结果竟然是false
            }
        };
        thread.start();
        Thread.sleep(1000 * 5);
        /**
         * 使用interrupt()中断的方式，注意使用interrupt()方法中断正在运行中的线程只会修改中断状态位，
         * 可以通过isInterrupted()判断。如果使用interrupt()方法中断阻塞中的线程，
         * 那么就会抛出InterruptedException异常，可以通过catch捕获异常，然后进行处理后终止线程。
         * 有些情况，我们不能判断线程的状态，所以使用interrupt()方法时一定要慎重考虑。
         * 1. interrupted()：测试 当前线程 是否已经是中断状态，执行后具有清除状态功能。
         * 2. isInterrupted()：测试线程 Thread 对象 是否已经是中断状态，但不清除状态标志。
         */


        //注意，此方法不会中断一个正在运行的线程，它的作用是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态
        thread.interrupt();

        //这里的结果竟然是false
        System.out.println("main线程是否被中断：" + Thread.currentThread().isInterrupted());


    }
}