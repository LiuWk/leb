package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * java8 map reduce
 * @author lwk
 * @date 2019-08-02 14:14
 */
public class MapReduceTests {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "234", "asdf", "vv", "bb");
        list.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
        long count = list.stream().filter(o -> o.length() > 2).count();
        System.out.println(count);
        Optional<String> p = list.stream().reduce((s, s2) -> s.concat(",").concat(s2));
        p.ifPresent(System.out::println);

        // 并行排序
        int num = 1000_000;
        List<Integer> intList = new ArrayList<>(num);
        for(int i=0;i<num;i++){
            intList.add(0);
        }

    }
}
