package ru.job4j.tracker;

public class ShowAll implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName() + " " + item.getId());
        }
        return true;
    }
}
