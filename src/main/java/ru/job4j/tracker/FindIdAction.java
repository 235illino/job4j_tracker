package ru.job4j.tracker;

import java.util.Objects;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find Id";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Find item by Id====");
        String id = input.askStr("Enter id for searching: ");
        Item itemFindId = memTracker.findById(Integer.parseInt(id));
        boolean rsl = Objects.isNull(itemFindId);
        if (rsl) {
            System.out.println("Found nothing");
        } else {
            System.out.println("Your item - " + itemFindId.getName());
        }
        return true;
    }
}
