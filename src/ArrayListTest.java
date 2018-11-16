import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * 集合对象list
 *
 * @author lwk
 * @createTime 2018-11-15 15:08
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }


        List[] arr = new List[10];
        arr[0] = arrayList;
        System.out.println(Arrays.asList(arr));
    }
}