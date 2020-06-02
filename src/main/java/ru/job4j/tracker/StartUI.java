package ru.job4j.tracker;

import java.util.Objects;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show all items ====");
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName() + " " + item.getId());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String name = input.askStr("Enter name: ");
        String id = input.askStr("Enter id for edit: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Success action");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Enter id for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Success action");
        } else {
            System.out.println("Error");
        }
    }

    public static void findId(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id====");
        String id = input.askStr("Enter id for searching: ");
        Item itemFindId = tracker.findById(id);
        boolean rsl = Objects.isNull(itemFindId);
        if (rsl) {
            System.out.println("Found nothing");
        } else {
            System.out.println("Your item - " + itemFindId.getName());
        }
    }

    public static void findName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name====");
        String name = input.askStr("Enter name for searching: ");
        Item[] itemFindName = tracker.findByName(name);
        boolean rsl = Objects.isNull(itemFindName);
        if (rsl) {
            System.out.println("Found nothing");
        } else {
            for (Item item : itemFindName) {
                System.out.println(item.getName());
            }
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findId(input, tracker);
            } else if (select == 5) {
                StartUI.findId(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.\n"
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program");
        // добавить остальные пункты меню.
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
