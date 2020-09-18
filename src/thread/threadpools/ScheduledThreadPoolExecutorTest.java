package thread.threadpools;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务线程池
 * 1) schedule(Callable callable, long delay, TimeUnit unit);  延迟delay时间后开始执行callable
 * 2) scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
 * 延迟initialDelay时间后开始执行command，并且按照period时间周期性重复调用，当任务执行时间大于间隔时间时，
 * 之后的任务都会延迟，此时与Timer中的schedule方法类似
 * 3) scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
 * 延迟initialDelay时间后开始执行command，并且按照period时间周期性重复调用，这里的间隔时间delay是等上一个任务完全执行完毕才开始计算，
 * 与Timer中scheduleAtFixedRate情况不同。
 */
public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        /*executor.schedule(() -> {
            System.out.println("hello scheduled thread pool.");
        },2000, TimeUnit.MILLISECONDS);*/
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("hello scheduleWithFixedDelay. time:"+ LocalDateTime.now());
        }, 3000, 2000, TimeUnit.MILLISECONDS);
    }
}
