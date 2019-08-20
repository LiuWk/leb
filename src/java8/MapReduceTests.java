package java8;

import com.google.common.base.Joiner;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * java8 map reduce
 *
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
        List<String> strList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            strList.add(UUID.randomUUID().toString());
        }
        long t1 = System.nanoTime();
//        long c = strList.stream().sorted().count();
        long c = strList.parallelStream().sorted().count();
        System.out.println(c);
        long t2 = System.nanoTime();
        long time = TimeUnit.NANOSECONDS.toMillis(t2 - t1);
        System.out.println(String.format("处理时间 %s ms",time));

        System.out.println(Joiner.on(",").join("1","2"));
    }
}
