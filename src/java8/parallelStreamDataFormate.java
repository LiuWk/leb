package java8;

import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lwk
 * @date 2019-07-08 11:03
 */
public class parallelStreamDataFormate {
    public static void main(String[] args) {
        /**
         * stream parallelStream比较
         */
        dateFormat1();

        System.out.println();

    }

    private static void dateFormat1() {
        List<Calendar> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, i);
            list.add(c);
        }
        /**
         * 非线程安全
         */
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        list.stream().forEach(o -> System.out.println(sf.format(o.getTime())));
        System.out.println("-------------");
        List<String> formatList = list.parallelStream().map(o->sf.format(o.getTime())).collect(Collectors.toList());
        formatList.forEach(System.out::println);
        Map<String, Long> goupList = groupByKey(formatList);
        System.out.println(goupList);
    }

    private static void dateFormat2() {
        List<LocalDate> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(LocalDate.now().plusDays(i));
        }
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        list.stream().forEach(o-> System.out.println(sf.format(o)));
        System.out.println("-------------");
        List<String> formatList = list.parallelStream().map(sf::format).collect(Collectors.toList());
        formatList.forEach(System.out::println);
        Map<String, Long> goupList = groupByKey(formatList);
        System.out.println(goupList);
    }

    private static Map<String,Long> groupByKey(List<String> list){
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        Map<String, Long> goupList = list.parallelStream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        Map<String,Long > result = new LinkedHashMap<>();
        goupList.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(o->result.put(o.getKey(),o.getValue()));
        return result;
    }
}
