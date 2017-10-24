package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月30日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月30日]创建文件 by lwk
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
//        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
//        Map<String,Object> map = new HashMap<>();
        LinkedHashMap map = new LinkedHashMap<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("1", 23);
            }
        },"T1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("2", 12);
            }
        },"T2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("3", 21);
            }
        },"T3").start();
        
        
        System.out.println(map);
//        for(Entry<String, Object> e : map.entrySet() ){
//            System.out.println(e.getKey()+"--"+e.getValue());
//        }
        System.out.println(2^3);
    }
}
 

