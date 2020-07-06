package collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("K2/SK2/SSK2");
        List<String> expect = List.of("K2", "K2/SK2", "K2/SK2/SSK2");
        List<String> result = Departments.fillGaps(input);
        result.sort(Comparator.naturalOrder());
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        result.sort(Comparator.naturalOrder());
        assertThat(result, is(expect));
    }
}