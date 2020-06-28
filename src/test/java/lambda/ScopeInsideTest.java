package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ScopeInsideTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = ScopeInside.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = ScopeInside.diapason(1, 4, x -> 2 * Math.pow(x, 2) + 3 * x + 1);
        List<Double> expected = Arrays.asList(6D, 15D, 28D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenShowcaseFunctionThenShowcaseResults() {
        List<Double> result = ScopeInside.diapason(9, 13, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(512D, 1024D, 2048D, 4096D);
        assertThat(result, is(expected));
    }
}