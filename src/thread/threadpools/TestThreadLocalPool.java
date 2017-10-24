package thread.threadpools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月19日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月19日]创建文件 by lwk
 */
public class TestThreadLocalPool {

    private static int produceTaskSleepTime = 2;

    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {
        // 构造一个线程池  
        /**
         *   ThreadPoolExecutor(int corePoolSize,                   //核心线程数
         *                      int maximumPoolSize,                //最多可创建的线程数
         *                      long keepAliveTime,                 //线程空闲时间
         *                      TimeUnit unit,                      //线程空闲时间的单位，时分秒
         *                      BlockingQueue<Runnable> workQueue,  //当线程池满的时候，新来的线程进入的缓存队列
         *                      RejectedExecutionHandler handler    //若队列已满，则在总线程数不大于maximumPoolSize的前提下，创建新的线程，
         *                                                            若线程数大于maximumPoolSize，则执行拒绝策略。或其他自定义方式。
         *                      )
         */
//        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();//无界队列
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);//有界队列
        
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, 
                queue, 
                new MyPolicy());

        for (int i = 1; i <= 10; i++) {
            try {
                String task = "task@ " + i;
                threadPool.execute(new ThreadPoolTask(task));
                System.out.println("创建任务并提交到线程池中：" + task);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月7日
 * 类  描  述 : 自定义线程池拒绝异常处理
 * 修改历史 : 
 *     1. [2017年7月7日]创建文件 by lwk
 */
class MyPolicy implements RejectedExecutionHandler {
    public MyPolicy() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理..");
        System.out.println("当前被拒绝的线程：" + r.toString());
        //一般处理方式是记录任务id，缓存起来在之后重新执行任务
    }

}
