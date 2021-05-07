package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ====");
        String id = input.askStr("Enter id for delete: ");
        if (!tracker.delete(Integer.parseInt(id))) {
            System.out.println("Success action");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
