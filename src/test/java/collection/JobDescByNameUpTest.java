package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobDescByNameUpTest {
    @Test
    public void nameSort() {
        Job job1 = new Job("Crew", 0);
        Job job2 = new Job("Drew", 2);
        Job job3 = new Job("Brew", 1);

        List<Job> rsl = new ArrayList<>();
        rsl.add(job1);
        rsl.add(job2);
        rsl.add(job3);
        Collections.sort(rsl, new JobDescByNameUp());
        List<Job> exp = new ArrayList<>();
        exp.add(job3);
        exp.add(job1);
        exp.add(job2);
        assertThat(rsl, is(exp));
    }

}