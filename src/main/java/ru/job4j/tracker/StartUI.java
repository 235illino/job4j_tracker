package ru.job4j.tracker;

import java.util.Objects;

public class StartUI {

//    public static void createItem(Input input, Tracker tracker) {
//        System.out.println("=== Create a new Item ====");
//        String name = input.askStr("Enter name: ");
//        Item item = new Item(name);
//        tracker.add(item);
//    }
//
//    public static void showAll(Tracker tracker) {
//        System.out.println("=== Show all items ====");
//        for (Item item : tracker.findAll()) {
//            System.out.println(item.getName() + " " + item.getId());
//        }
//    }
//
//    public static void replaceItem(Input input, Tracker tracker) {
//        System.out.println("=== Edit item ====");
//        String id = input.askStr("Enter id for edit: ");
//        String name = input.askStr("Enter name: ");
//        Item newItem = new Item(name);
//        if (!tracker.replace(id, newItem)) {
//            System.out.println("Success action");
//        } else {
//            System.out.println("Error");
//        }
//    }
//
//    public static void deleteItem(Input input, Tracker tracker) {
//        System.out.println("=== Delete item ====");
//        String id = input.askStr("Enter id for delete: ");
//        if (!tracker.delete(id)) {
//            System.out.println("Success action");
//        } else {
//            System.out.println("Error");
//        }
//    }
//
//    public static void findId(Input input, Tracker tracker) {
//        System.out.println("=== Find item by Id====");
//        String id = input.askStr("Enter id for searching: ");
//        Item itemFindId = tracker.findById(id);
//        boolean rsl = Objects.isNull(itemFindId);
//        if (rsl) {
//            System.out.println("Found nothing");
//        } else {
//            System.out.println("Your item - " + itemFindId.getName());
//        }
//    }
//
//    public static void findName(Input input, Tracker tracker) {
//        System.out.println("=== Find item by name====");
//        String name = input.askStr("Enter name for searching: ");
//        Item[] itemFindName = tracker.findByName(name);
//        boolean rsl = itemFindName.length == 0;
//        if (rsl) {
//            System.out.println("Found nothing");
//        } else {
//            for (Item item : itemFindName) {
//                System.out.println(item.getName());
//            }
//        }
//    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
        // добавить остальные пункты меню.
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAll(),
                new EditAction(),
                new DeleteAction(),
                new FindIdAction(),
                new FindNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }

}
