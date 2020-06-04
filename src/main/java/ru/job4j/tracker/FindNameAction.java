package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name====");
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
