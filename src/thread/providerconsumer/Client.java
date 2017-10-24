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
public class Client {

     
    public static void main(String[] args) {
        Queue q = new Queue();
        
        for(int i=0;i<10;i++){
            Provider p = new Provider(q,"ppp"+i);
            new Thread(p).start();
        }
        
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        Consumer c = new Consumer(q);
        Thread tc = new Thread(c);
        tc.start();
        
    }

}
