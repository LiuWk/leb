package thread;

import util.ThreadUtil;

import java.util.concurrent.ExecutorService;

public class ShutdownHookMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start...");

        ExecutorService service = ThreadUtil.newFixedThreadPool(1, "test");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("执行钩子线程...");
            service.shutdown();
        }));
        for (int i = 0; i < 5; i++) {
            service.execute(() -> {
                System.out.println("1111..");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("program end...");
    }
}
