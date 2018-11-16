package thread.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月4日
 * 类  描  述 : 用wait和notify模拟BlockingQueue
 * 修改历史 : 
 *     1. [2017年7月4日]创建文件 by lwk
 */
public class TestLinkedBlockingQueue { 
    public static void main(String[] args) {
        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(2);
        try {
            q.offer("1");
            q.offer("2");
            q.offer("3");
            q.offer("4");
            System.out.println("poll():"+q.poll());
            System.out.println("take():"+q.take());
//            System.out.println(q.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Iterator iterator = q.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
    }
}
