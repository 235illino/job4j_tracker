package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortByNameDownTest {
    @Test
    public void nameSort() {
        Item item1 = new Item("Crew");
        Item item2 = new Item("Drew");
        Item item3 = new Item("Brew");

        List<Item> rsl = new ArrayList<>();
        rsl.add(item3);
        rsl.add(item1);
        rsl.add(item2);
        Collections.sort(rsl, new SortByNameDown());
        List<Item> exp = new ArrayList<>();
        exp.add(item2);
        exp.add(item1);
        exp.add(item3);
        assertThat(rsl, is(exp));
    }

}