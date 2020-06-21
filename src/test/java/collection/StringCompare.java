package collection;

import java.util.Arrays;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        return Arrays.compare(left.getBytes(), right.getBytes());
    }
}
