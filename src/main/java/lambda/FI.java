package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Comparator<Attachment> comparatorStr = (left, right) -> right.getName().compareTo(left.getName());
        Arrays.sort(atts, comparator);
        Arrays.sort(atts, comparatorStr);
        System.out.println(atts[0]);
    }

}
