package thread.threadpools;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {

    private String data;

    /**
     * //TODO 添加描述
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param data
     */
    ThreadPoolTask(String data) {
        super();
        this.data = data;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行任务-->" + data);
        data = null;
    }

    @Override
    public String toString() {
        return "ThreadPoolTask [data=" + data + "]";
    }

}
