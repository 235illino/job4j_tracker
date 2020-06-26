package collection;

import java.util.*;

import static java.util.Comparator.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (el.length() < 3) {
                    start = el;
                    tmp.add(start);
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        ArrayList<String> depL = new ArrayList<>(tmp);
        depL.sort(Comparator.naturalOrder());
        return depL;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs);
    }
}
