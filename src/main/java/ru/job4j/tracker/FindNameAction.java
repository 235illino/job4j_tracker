package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name for searching: ");
        Item[] itemFindName = tracker.findByName(name);
        boolean rsl = itemFindName.length == 0;
        if (rsl) {
            System.out.println("Found nothing");
        } else {
            for (Item item : itemFindName) {
                System.out.println(item.getName());
            }
        }
        return true;
    }
}
