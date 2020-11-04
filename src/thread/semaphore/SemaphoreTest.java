package thread.semaphore;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
@Slf4j

public class SemaphoreTest {
    @SneakyThrows
    public static void main(String[] args) {
        int workers = 8;
        Semaphore machine = new Semaphore(3);
        for (int i =0;i<workers;i++){
            new Thread(new Work(i,machine)).start();
        }
    }

    static class Work implements Runnable{
        private  int num;
        private Semaphore semaphore;
        @SneakyThrows
        @Override
        public void run() {
            semaphore.acquire();
            log.info("第{}号工人 ,使用机器工作中。还剩余{}个机器",num,semaphore.availablePermits());
            semaphore.release();
            log.info("第{}号工人完成了工作。还剩余{}个机器",num,semaphore.availablePermits());
        }

        public Work(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Semaphore getSemaphore() {
            return semaphore;
        }

        public void setSemaphore(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
    }
}
