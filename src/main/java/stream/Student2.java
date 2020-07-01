package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student2 {
    public static Map<String, Student> toMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student::getSurname,
                value -> value,
                (Student1, Student) -> Student1
        ));
    }
}
