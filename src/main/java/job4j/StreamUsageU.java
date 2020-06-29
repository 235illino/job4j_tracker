package job4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsageU {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(
                -1,
                5,
                -3,
                8,
                -8,
                10,
                22
        );
        List<Integer> numsPlus = nums.stream().filter(num -> num > 0).collect(Collectors.toList());
        numsPlus.forEach(System.out::println);
    }
}
