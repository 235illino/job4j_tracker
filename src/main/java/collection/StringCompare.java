package collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
