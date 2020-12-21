package thread;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 守护线程：如果主线程不结束运行，守护线程会一直执行。
 * 主线程结束之后
 * 如果服务只剩下守护线程，jvm会进行退出，停止守护线程执行。
 * junit 操作是执行代码结束之后进行资源的释放，所以不支持多线程进行Junit测试。
 */
public class DaemonTest {
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

//    @Test
    public static void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().isDaemon());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"t:"+i);
            t.setDaemon(true);
            t.start();
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().isDaemon());

//        System.out.println(LocalDateTime.now().getHourOfDay() < 15);
//
//        print();
    }

    private static void p1(){
        print();
    }

    public static void print(){
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}