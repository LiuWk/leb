package thread.validate;

import java.util.concurrent.CountDownLatch;

/**
 * validate关键字
 *
 * @author lwk
 * @createTime 2018-11-15 15:51
 **/
public class VolatileExample {
    volatile int b = 0;

    private void increase() {
        b++;
    }

    private void read() {
        System.out.println("read:b="+b);
    }

    public static void main(String[] args) throws Exception {
        final VolatileExample example = new VolatileExample();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    example.increase();
//                    countDownLatch.countDown();
                }
            }).start();
        }
//        countDownLatch.await();
        example.read();
    }
}