package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");

        // 交集
        List<String> r1 = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(r1);

        // 差集 list1 减 list2
        List<String> r2 = list1.stream().filter(s -> !list2.contains(s)).collect(Collectors.toList());
        System.out.println(r2);

        // 并集
        
    }
}
