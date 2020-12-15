package thread.threadpools;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;

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

    @SneakyThrows
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (RandomUtils.nextInt(0, 5) == 0) {
            throw new Exception("异常测试");
        }
        System.out.println("执行任务-->" + data);
        data = null;
    }

    @Override
    public String toString() {
        return "ThreadPoolTask [data=" + data + "]";
    }

}
