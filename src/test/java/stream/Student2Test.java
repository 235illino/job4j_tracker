package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Student2Test {

    @Test
    public void toMapTest() {
        List<Student> students = Arrays.asList(
                new Student("Aaaa", 99),
                new Student("Aaaa", 99),
                new Student("Bbbb", 51),
                new Student("Bbbb", 51),
                new Student("Cccc", 48)
        );

        HashMap<String, Student> exp = new HashMap<>();
        exp.put("Aaaa", new Student("Aaaa", 99));
        exp.put("Bbbb", new Student("Bbbb", 51));
        exp.put("Cccc", new Student("Cccc", 48));
        HashMap<String, Student> rsl = (HashMap<String, Student>) Student2.toMap(students);
        assertThat(exp, is(rsl));
    }

}