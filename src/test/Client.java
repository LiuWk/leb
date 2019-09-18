package test;

import util.JsonUtils;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月28日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月28日]创建文件 by lwk
 */
public class Client {
    public static void main(String[] args) {
        String json = "{ \"name\": \"HBP3\", \"phone\": \"161125040\" }";
        System.out.println(JsonUtils.fromJson(json, Test.class).getName());

        Animal dog = new Dog("贾长伟");
        Animal cat = new Cat("常委");
        dog.bark();
        cat.bark();
        Test test = new Test();
        test.doubleNum(10);
        System.out.println();

        String aaaaaaaaaaaaaaaaaaaaaaaaa;
    }
}
class Test{
    private String name;
    private String phone;
    private int sex;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }

    public void doubleNum(final int num){
        System.out.println(num * num);
    }
}