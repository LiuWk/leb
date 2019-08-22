package thread.threadpools;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月11日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月11日]创建文件 by lwk
 */
public class ConnThreadLocal {

    public static ThreadLocal<String> th = new ThreadLocal<String>();
    
    public void setTh(String value){
        th.set(value);
    }
    public void getTh(){
        System.out.println(Thread.currentThread().getName() + ":" + th.get());
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        final ConnThreadLocal ct = new ConnThreadLocal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.setTh("张三");
                ct.getTh();
            }
        }, "t1");
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    ct.setTh("李四");
                    ct.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");
        
        t1.start();
        t2.start();
    }
    
}
