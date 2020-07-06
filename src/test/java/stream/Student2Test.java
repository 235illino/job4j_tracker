package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Student2Test {

    @Test
    public void toMapTest() {
        List<Student> students = List.of(
                new Student("Aaaa", 99),
                new Student("Aaaa", 99),
                new Student("Bbbb", 51),
                new Student("Bbbb", 51),
                new Student("Cccc", 48)
        );

        Map<String, Student> exp = Map.of(
                "Aaaa", new Student("Aaaa", 99),
                "Bbbb", new Student("Bbbb", 51),
                "Cccc", new Student("Cccc", 48)
        );
        Map<String, Student> rsl = Student2.toMap(students);
        assertThat(exp, is(rsl));
    }

}