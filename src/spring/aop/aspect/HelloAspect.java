package spring.aop.aspect;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月19日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月19日]创建文件 by lwk
 */
public class HelloAspect {
    public void sayHello(){
        System.out.println("hello aspect !");
    }
    public static void main(String[] args) {
        HelloAspect ha = new HelloAspect();
        ha.sayHello();
    }
    
}
