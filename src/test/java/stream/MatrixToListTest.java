package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void name() {
        Integer[][] integers = {{5,7,3,17}, {7,0,1,12}, {8,1,2,3}};
        List<Integer> exp = List.of(
                5, 7, 3, 17, 7, 0, 1, 12, 8, 1, 2, 3
        );
        List<Integer> rsl = MatrixToList.matrixTo(integers);
        assertThat(exp, is(rsl));

    }
}