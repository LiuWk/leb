package test;

import org.apache.commons.lang.math.RandomUtils;
import util.JsonUtils;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Random;

/**
 * leb测试用源代码
 * <p>
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月28日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 :
 * 1. [2017年6月28日]创建文件 by lwk
 */
public class Client {
    public static void main(String[] args) {
        String json = "{ \"name\": \"HBP3\", \"phone\": \"161125040\" }";
        System.out.println(JsonUtils.fromJson(json, Test.class).getName());
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(1 & 2);
        Integer a = 9;
        System.out.println(a.hashCode());
         /*java.lang.OutOfMemoryError: Java heap space
         at java.util.HashMap.resize(HashMap.java:704)
         at java.util.HashMap.putVal(HashMap.java:663)
         at java.util.HashMap.put(HashMap.java:612)
         at test.Client.main(Client.java:31)*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100000000; i++) {
            map.put(i, RandomUtils.nextInt());
        }
    }
}

class Test {
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

}