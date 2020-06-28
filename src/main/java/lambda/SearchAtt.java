package lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list, Predicate<Attachment> filter) {

        UnaryOperator<List<Attachment>> unary = new UnaryOperator<List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> attachments) {

                for (Attachment att : attachments) {
                    if (filter.test(att)) {
                        attachments.add(att);
                    }
                }
                return attachments;
            }
        };

        return unary.apply(list);
    }
}
