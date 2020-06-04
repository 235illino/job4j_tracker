package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ====");
        String id = input.askStr("Enter id for edit: ");
        String name = input.askStr("Enter name: ");
        Item newItem = new Item(name);
        if (!tracker.replace(id, newItem)) {
            System.out.println("Success action");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
