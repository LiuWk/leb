package kilim;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Coroutine {

    /**
     * 为每个协程创建一个信箱，由于协程中不能多个消费者共用一个信箱，需要为每个消费者提供一个信箱，
     * 这也是协程通过通信来保证共享变量的线程安全的一种方式
     */
    static Map<Integer, Mailbox<Integer>> mailMap = new HashMap<Integer, Mailbox<Integer>>();

    public static void main(String[] args) {

        if (kilim.tools.Kilim.trampoline(false, args)) return;
        Properties propes = new Properties();
        //设置一个线程
        propes.setProperty("kilim.Scheduler.numThreads", "1");
        System.setProperties(propes);
        long startTime = System.currentTimeMillis();
        //创建一千生产者
        for (int i = 0; i < 1000; i++) {
            Mailbox<Integer> mb = new Mailbox<Integer>(1, 10);
            new Producer(i, mb).start();
            mailMap.put(i, mb);
        }
        //创建一千个消费者
        for (int i = 0; i < 1000; i++) {
            new Consumer(mailMap.get(i)).start();
        }

        Task.idledown();//开始运行

        long endTime = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName() + "总计花费时长：" + (endTime - startTime));
    }

}