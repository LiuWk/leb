package thread.providerconsumer;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月6日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月6日]创建文件 by lwk
 */
public class Consumer implements Runnable{
    private Queue q ;
    @Override
    public void run() {
        q.consume();
    }
    public Consumer(Queue q) {
        this.q = q;
    }

}
