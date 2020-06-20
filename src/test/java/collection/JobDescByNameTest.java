package collection;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobDescByNameTest {

    @Test
    public void nameSort() {
        Job job1 = new Job("Crew", 0);
        Job job2 = new Job("Drew", 2);
        Job job3 = new Job("Brew", 1);

        List<Job> rsl = new ArrayList<>();
        rsl.add(job1);
        rsl.add(job2);
        rsl.add(job3);
        Collections.sort(rsl, new JobDescByName());
        List<Job> exp = new ArrayList<>();
        exp.add(job2);
        exp.add(job1);
        exp.add(job3);
        assertThat(rsl, is(exp));
    }
}