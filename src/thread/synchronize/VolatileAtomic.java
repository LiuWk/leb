package thread.synchronize;

import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leb测试用源代码
 * <p>
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月3日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 :
 * 1. [2017年7月3日]创建文件 by lwk
 */
public class VolatileAtomic extends Thread {
    /**
     * //获取当前的值
     *  public final int get()
     *
     *  //取当前的值，并设置新的值
     *  public final int getAndSet(int newValue)
     *
     *  //获取当前的值，并自增 不能确保原子性
     *  public final int getAndIncrement()
     *
     *  //获取当前的值，并自减
     *  public final int getAndDecrement()
     *
     *  //获取当前的值，并加上预期的值
     *  public final int getAndAdd(int delta)
     */
    // 不需要volatile
    private static volatile AtomicInteger count = new AtomicInteger(0);//原子操作的类
    private static CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private void addCount() {
        for (int i = 0; i < 100; i++) {
            // 保证原子性
//            System.out.println(Thread.currentThread().getId()+","+count.incrementAndGet());
            copyOnWriteArrayList.add(count.incrementAndGet());
        }
//        System.out.println(Thread.currentThread().getName() + "," + count.get());
    }

    @Override
    public void run() {
        addCount();
    }


    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        VolatileAtomic[] arr = new VolatileAtomic[num];
        for (int i = 0; i < num; i++) {
            arr[i] = new VolatileAtomic();
        }
        for (int i = 0; i < num; i++) {
            arr[i].start();
            // 顺序执行
//            arr[i].join();
        }

        Thread.sleep(3000L);
        System.out.println(copyOnWriteArrayList);
        copyOnWriteArrayList.sort(Integer::compareTo);
        System.out.println(copyOnWriteArrayList);

    }
}
