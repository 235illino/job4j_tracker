package collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] nums : list) {
            for (int i : nums) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}
