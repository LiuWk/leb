package socket;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年8月22日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年8月22日]创建文件 by lwk
 */
public class ThreadPoolHandler {
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
    
    ThreadPoolHandler(Runnable command) {
        executor.execute(command);
    }
}
