package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

//    @Test
//    public void createItem() {
//        String[] answers = {"Fix PC"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("Fix PC");
//        assertThat(created.getName(), is(expected.getName()));
//    }
//
//    @Test
//    public void showAll() {
//    }
//
//    @Test
//    public void replaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {
//                item.getId(), // id сохраненной заявки в объект tracker.
//                "replaced item"
//        };
//        StartUI.replaceItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertThat(replaced.getName(), is("replaced item"));
//    }
//
//    @Test
//    public void deleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {
//                item.getId()
//        };
//        StartUI.deleteItem(new StubInput(answers), tracker);
//        Item deleted = tracker.findById(item.getId());
//        Item exp = null;
//        assertThat(deleted, is(exp));
//    }
//
//    @Test
//    public void findId() {
//    }
//
//    @Test
//    public void findName() {
//    }
//
//    @Test
//    public void init() {
//    }
//
//    @Test
//    public void main() {
//    }
}