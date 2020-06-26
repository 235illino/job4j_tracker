package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int size = Math.min(o1.length(), o2.length());
        for (int i = 0; i < size; i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                rsl = Character.compare(o1.charAt(i), o2.charAt(i));
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(o1.length(), o2.length());
        }
        return rsl;
    }
}
