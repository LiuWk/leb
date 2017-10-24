package thread.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月5日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月5日]创建文件 by lwk
 */
public class TestDelayQueue {

    /**
     * //TODO 添加方法功能描述
     * @param args
     * 2017年7月5日 by lwk 
     */
    public static void main(String[] args) {
        WangBa wb = new WangBa();
        wb.shangJi(123, "aa", 4);
        wb.shangJi(111, "vv", 1);
        wb.shangJi(222, "xx", 9);

        new Thread(wb).start();
    }

}

class WangBa implements Runnable {
    private DelayQueue<WangMin> q = new DelayQueue<>();

    public boolean isOn = true;

    @Override
    public void run() {
        while (isOn) {
            try {
                WangMin w = q.take();
                xiaJi(w);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void xiaJi(WangMin w) {
        System.out.println(w.getId() + "下机");
    }

    public void shangJi(int id, String name, long money) {
        WangMin w = new WangMin(id, name, 1000 * money + System.currentTimeMillis());
        q.add(w);
        System.out.println("id:" + id + ",name:" + name+",money:"+money + " 开始上机.");
    }

}

class WangMin implements Delayed {
    private int id;

    private String name;

    private long endTime;//结束时间

    private TimeUnit unit = TimeUnit.SECONDS;//时间工具类

    @Override
    public int compareTo(Delayed o) {
        WangMin w = (WangMin) o;
        //比较 1是放入队尾  -1是放入队头
        return this.getDelay(unit) > w.getDelay(unit) ? 1 : (this.getDelay(unit) < w.getDelay(unit) ? -1 : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {

        return endTime - System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "WangMin [id=" + id + ", name=" + name + ", endTime=" + endTime + ", unit=" + unit + "]";
    }

    /**
     * @param id
     * @param name
     * @param endTime
     */
    public WangMin(int id, String name, long endTime) {
        super();
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

}
