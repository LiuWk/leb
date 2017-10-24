package thread.future;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月5日
 * 类  描  述 : future模式，模拟异步加载数据；
 * 修改历史 : 
 *     1. [2017年7月5日]创建文件 by lwk
 */
public class Client {
    public static void main(String[] args) {
        FutureClient client = new FutureClient();
        Data data = client.request("aa");
        System.out.println("发送请求成功！");
        
        System.out.println("做其他事情");
        
        System.out.println("数据结果："+data.getRequest());
    }
}
