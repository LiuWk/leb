package guava;

import com.google.common.collect.HashBiMap;

/**
 * @author lwk
 * @date 2019-08-02 15:56
 */
public class GuavaTests {
    public static void main(String[] args) {
        HashBiMap<Object, Object> map = HashBiMap.create();
        map.put("name","qweads");
        System.out.println();
        //TODO guava api
        System.out.println("123".getBytes().length);
        System.out.println(Long.valueOf(1).byteValue());
    }
}
