package ru.job4j.tracker;

import java.util.Objects;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id for searching: ");
        Item itemFindId = tracker.findById(id);
        boolean rsl = Objects.isNull(itemFindId);
        if (rsl) {
            System.out.println("Found nothing");
        } else {
            System.out.println("Your item - " + itemFindId.getName());
        }
        return true;
    }
}
