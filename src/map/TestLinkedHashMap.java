package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月30日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月30日]创建文件 by lwk
 */
public class TestLinkedHashMap {

    /**
     * //TODO 添加方法功能描述
     * @param args
     * 2017年6月30日 by lwk 
     */
    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<>();

        map.put("k1", 1);
        map.put("2", "ss");
        map.put("k3", "a");
        map.put("4", "vv");
        map.put("5", "b");
        map.put("qq", "b");
        map.put("nn", "b");

        System.out.println(map);
        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        ArrayList list = new ArrayList<>();

    }

}
