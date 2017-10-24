package pattern.singleton;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月4日
 * 类  描  述 : 内部类方式实现单例
 * 修改历史 : 
 *     1. [2017年7月4日]创建文件 by lwk
 */
public class InnerSingleton {
    private static class Singleton{
        private static Singleton single = new Singleton();
    }
    
    public Singleton getInnstence(){
        return Singleton.single;
    }
    
}
