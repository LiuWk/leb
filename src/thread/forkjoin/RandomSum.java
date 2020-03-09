package thread.forkjoin;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomSum {

    public static void main(String[] args) {
        List<BigDecimal> longs = new ArrayList<>();
        for (int i=0;i<10000;i++){
            longs.add(BigDecimal.valueOf(RandomUtils.nextLong()));
        }
        BigDecimal count = longs.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        System.out.println(count);
    }
}
