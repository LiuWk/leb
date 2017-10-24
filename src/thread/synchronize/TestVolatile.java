package thread.synchronize;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月3日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月3日]创建文件 by lwk
 */
public class TestVolatile extends Thread{
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while(isRunning == true){
            
        }
        System.out.println("thread end.");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    
    public static void main(String[] args) throws InterruptedException {    
        TestVolatile t = new TestVolatile();
        t.start();
        Thread.sleep(3000);
        t.setRunning(false);
        System.out.println("isRunning = "+t.isRunning);
    }
    
}
