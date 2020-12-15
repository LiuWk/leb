package java8;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    private Long id;
    private String name;

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
        List<String> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        List<String> list3 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list3);

        ListTest l1 = new ListTest();
        ListTest l2 = new ListTest();
        System.out.println(l1.equals(l2));

        int[] nums={1,2,3,4,5,6,77,8};
        int target=15;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTest listTest = (ListTest) o;
        return Objects.equals(id, listTest.id) &&
                Objects.equals(name, listTest.name);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(id, name);
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
