package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }
    UnaryOperator<List<Attachment>> unary = new UnaryOperator<List<Attachment>>() {
        @Override
        public List<Attachment> apply(List<Attachment> attachments) {
            Predicate<Attachment> filter100 = new Predicate<Attachment>() {
                @Override
                public boolean test(Attachment attachment) {
                    return attachment.getSize() > 100;
                }
            };
            Predicate<Attachment> filterName = new Predicate<Attachment>() {
                @Override
                public boolean test(Attachment attachment) {
                    return attachment.getName().contains("bug");
                }
            };
            for (Attachment att : attachments) {
                if (filter100.test(att) || filterName.test(att)) {
                    attachments.add(att);
                }
            }
            return attachments;
        }
    };
}
