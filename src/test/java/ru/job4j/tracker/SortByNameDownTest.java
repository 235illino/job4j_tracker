package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortByNameDownTest {
    @Test
    public void nameSort() {
        List<Item> items = Arrays.asList(
                new Item("Crew"),
                new Item("Drew"),
                new Item("Brew")
        );
        Collections.sort(items, new SortByNameDown());
        String exp = "Drew";
        String rsl = items.get(0).getName();
        assertThat(exp, is(rsl));
    }

}