package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id for delete: ");
        if (!tracker.delete(id)) {
            System.out.println("Success action");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
