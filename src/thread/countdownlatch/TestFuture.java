package thread.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月10日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月10日]创建文件 by lwk
 */
public class TestFuture {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new UserFuture());
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        Future<?> f = executor.submit(task);
        
        try {
            System.out.println(f.get());//==null说明任务处理完成
            
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    try {
                        System.out.println("返回的数据："+task.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        System.out.println("main end.");
        executor.shutdown();
    }

}
class UserFuture implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("任务处理中...");
        Thread.sleep(5000);
        return "aaa";
    }
    
}