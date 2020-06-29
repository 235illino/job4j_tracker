package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SearchAtt {

    public static Predicate<Attachment> filterSize(Attachment attachment) {
        Predicate<Attachment> predicate = attachment1 -> attachment.getSize() > 100;
        return predicate;
    }

    public static Predicate<Attachment> filterName(Attachment attachment) {
        Predicate<Attachment> predicate = attachment1 -> attachment.getName().contains("bug");
        return predicate;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
