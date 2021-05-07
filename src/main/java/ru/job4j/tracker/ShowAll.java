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
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Show all items ====");
        for (Item item : memTracker.findAll()) {
            System.out.println(item.getName() + " " + item.getId());
        }
        return true;
    }
}
