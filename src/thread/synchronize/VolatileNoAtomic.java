package thread.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jmx.export.assembler.AutodetectCapableMBeanInfoAssembler;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月3日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月3日]创建文件 by lwk
 */
public class VolatileNoAtomic extends Thread {
//    private volatile static int count;
    private static AtomicInteger count = new AtomicInteger(0);//原子操作的类
    private static void addCount(){
        for(int i=0;i<1000;i++){
//            count++;
            count.incrementAndGet();
        }
        System.out.println(count);
    }
    
    @Override
    public void run() {
        addCount();
    }


    public static void main(String[] args) {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
        for(int i=0;i<10;i++){
            arr[i] = new VolatileNoAtomic();
        }
        for(int i=0;i<10;i++){
            arr[i].start();
        }
       
    }
}
