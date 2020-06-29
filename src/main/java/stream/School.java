package stream;

import lambda.Attachment;


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static Predicate<Student> filterA() {
        Predicate<Student> predicate = student1 -> student1.getScore() > 70 && student1.getScore() < 100;
        return predicate;
    }

    public static Predicate<Student> filterB() {
        Predicate<Student> predicate = student1 -> student1.getScore() > 50 && student1.getScore() < 70;
        return predicate;
    }

    public static Predicate<Student> filterC() {
        Predicate<Student> predicate = student1 -> student1.getScore() > 0 && student1.getScore() < 50;
        return predicate;
    }
}
