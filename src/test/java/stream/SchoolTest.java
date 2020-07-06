package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void classA() {
        List<Student> students = List.of(
                new Student("Aaaa", 99),
                new Student("Bbbb", 51),
                new Student("Cccc", 48),
                new Student("Cccc", 66),
                new Student("Cccc", 33),
                new Student("Cccc", 77)
        );
        List<Student> expA = List.of(
                new Student("Aaaa", 99),
                new Student("Cccc", 77)
        );
        List<Student> rsl = School.collect(students, School.filterA());
        assertThat(expA, is(rsl));
    }

    @Test
    public void classB() {
        List<Student> students = List.of(
                new Student("Aaaa", 99),
                new Student("Bbbb", 51),
                new Student("Cccc", 48),
                new Student("Cccc", 66),
                new Student("Cccc", 33),
                new Student("Cccc", 77)
        );
        List<Student> expB = List.of(
                new Student("Bbbb", 51),
                new Student("Cccc", 66)
        );
        List<Student> rsl = School.collect(students, School.filterB());
        assertThat(expB, is(rsl));
    }

    @Test
    public void classC() {
        List<Student> students = List.of(
                new Student("Aaaa", 99),
                new Student("Bbbb", 51),
                new Student("Cccc", 48),
                new Student("Cccc", 66),
                new Student("Cccc", 33),
                new Student("Cccc", 77)
        );
        List<Student> expC = List.of(
                new Student("Cccc", 48),
                new Student("Cccc", 33)
        );
        List<Student> rsl = School.collect(students, School.filterC());
        assertThat(expC, is(rsl));
    }
}