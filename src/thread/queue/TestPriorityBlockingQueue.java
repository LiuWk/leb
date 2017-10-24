package thread.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月4日
 * 类  描  述 :  
 * 修改历史 : 
 *     1. [2017年7月4日]创建文件 by lwk
 */
public class TestPriorityBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<>();
        Task t1 = new Task();
        t1.setId(4);
        t1.setName("aa");
        q.add(t1);

        Task t2 = new Task();
        t2.setId(7);
        t2.setName("bb");
        q.add(t2);

        Task t3 = new Task();
        t3.setId(5);
        t3.setName("cc");
        q.add(t3);

        System.out.println(q.toString());
        System.out.println(q.take().getId());// 优先级最高的取出来(队列取出一个元素后排序)
        System.out.println(q.toString());
    }

}

class Task implements Comparable<Task> {
    private int id;

    private String name;

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

    @Override
    public int compareTo(Task t) {
        return this.id > t.id ? 1 : (this.id < t.id ? -1 : 0);
    }

    public String toString() {
        return this.id + "," + this.name;
    }

}
