package ru.job4j.tracker;

public class ShowAll implements UserAction {
    private final Output out;

    public ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName() + " " + item.getId());
        }
        return true;
    }
}
