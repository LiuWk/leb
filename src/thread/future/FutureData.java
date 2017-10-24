package thread.future;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月5日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年7月5日]创建文件 by lwk
 */
public class FutureData implements Data {
    private RealData realData;

    private boolean isReady = false;

    public RealData getRealData() {
        return realData;
    }

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        //通知
        notify();
    }

    @Override
    public synchronized String getRequest() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //取到真实数据
        return this.realData.getRequest();
    }

}
