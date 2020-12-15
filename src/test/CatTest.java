package test;

import org.joda.time.LocalDateTime;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:application-bean.xml"})
public class CatTest {
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().isDaemon());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"t:"+i);
            t.setDaemon(true);
            t.start();
        }
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().isDaemon());

        System.out.println(LocalDateTime.now().getHourOfDay() < 15);
    }
}