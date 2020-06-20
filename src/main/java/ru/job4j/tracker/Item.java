package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Item implements Comparable<Item>, Comparator<Item> {

    private String id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Item item1, Item item2) {
        return item1.getName().compareTo(item2.getName());
    }

    @Override
    public int compareTo(Item item) {
        return name.compareTo(item.getName());
    }

    public static void sortReverse(List<Item> items) {
        Collections.sort(items, Collections.reverseOrder());
    }
}
