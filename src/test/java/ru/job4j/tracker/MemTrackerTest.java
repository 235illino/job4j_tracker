package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findAll() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        Item item2 = new Item("test2");
        memTracker.add(item);
        memTracker.add(item2);
        List<Item> result = memTracker.findAll();
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item2);
        assertThat(result, is(expected));
    }

    @Test
    public void findByName() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        Item item2 = new Item("test2");
        memTracker.add(item);
        memTracker.add(item2);
        String key = "test1";
        List<Item> result = memTracker.findByName(key);
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        assertThat(result, is(expected));
    }

    @Test
    public void findById() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        Item item2 = new Item("test2");
        memTracker.add(item);
        memTracker.add(item2);
        String id = "000";
        Item result = memTracker.findById(id);
        Item exp = null;
        assertThat(result, is(exp));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

}