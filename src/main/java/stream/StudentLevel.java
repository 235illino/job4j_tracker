package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st -> !Objects.isNull(st))
                .sorted(Comparator.comparingInt(Student::getScore))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
