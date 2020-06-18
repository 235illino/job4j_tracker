package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//public class StartUITest {

//    @Test
//    public void whenFindByIdAction() {
//        Output output = new ConsoleOutput();
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Find item"));
//        String findId = item.getId();
//        Input in = new StubInput(
//                new String[] {"0", findId, "1"}
//        );
//        UserAction[] actions = {
//                new FindIdAction(output),
//                new ExitAction()
//        };
//        new StartUI(output).init(in, tracker, actions);
//        assertThat(tracker.findById(findId).getId(), is(findId));
//    }
//
//    @Test
//    public void whenFindByNameAction() {
//        Output output = new ConsoleOutput();
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Find item"));
//        String findName = "Find item";
//        Input in = new StubInput(
//                new String[] {"0", findName, "1"}
//        );
//        UserAction[] actions = {
//                new FindNameAction(output),
//                new ExitAction()
//        };
//        new StartUI(output).init(in, tracker, actions);
//        assertThat(tracker.findByName(findName)[0].getName(), is(findName));
//    }
//
//    @Test
//    public void whenFindItem() {
//        Output output = new ConsoleOutput();
//        Input in = new StubInput(
//                new String[] {"0", "Item name1", "0", "Item name2", "1", "2"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(output),
//                new ShowAll(output),
//                new ExitAction()
//        };
//        new StartUI(output).init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name1"));
//    }
//
//    @Test
//    public void whenCreateItem() {
//        Output output = new ConsoleOutput();
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(output),
//                new ExitAction()
//        };
//        new StartUI(output).init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Output output = new ConsoleOutput();
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Replaced item"));
//        /* Входные данные должны содержать ID добавленной заявки item.getId() */
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", item.getId(), replacedName, "1"}
//        );
//        UserAction[] actions = {
//                new EditAction(output),
//                new ExitAction()
//        };
//        new StartUI(output).init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Output output = new ConsoleOutput();
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Deleted item"));
//        /* Входные данные должны содержать ID добавленной заявки item.getId() */
//        Input in = new StubInput(
//                new String[] {"0", item.getId(), "1"}
//        );
//        UserAction[] actions = {
//                new DeleteAction(output),
//                new ExitAction()
//        };
//        new StartUI(output).init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }
//
//    @Test
//    public void whenExit() {
//        Output output = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0"}
//        );
//        ValidateInput input = new ValidateInput(output, in);
//        int selected = input.askInt("Enter menu:");
//        assertThat(selected, Matchers.is(0));
//    }
//
//    @Test
//    public void whenInvalidInput() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] {"one", "1"}
//        );
//        ValidateInput input = new ValidateInput(out, in);
//        int selected = input.askInt("Enter menu:");
//        assertThat(selected, Matchers.is(1));
//    }
//
//    @Test
//    public void whenInvalidExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] { "63", "0" }
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new ExitAction()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                String.format(
//                        "Menu.%n"
//                                + "0. Exit%n"
//                                + "Wrong input, you can select: 0 .. 0%n"
//                                + "Menu.%n"
//                                + "0. Exit%n"
//                )
//        ));
//    }
//
//}