package collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String orig : origin) {
            check.add(orig);
        }
        for (String test : text) {
            if (!check.contains(test)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
