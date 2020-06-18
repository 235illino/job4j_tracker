package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {

    /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
//    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public void add(Item item) {
        item.setId(generateId());
        items.add(item);
//        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsFind = new ArrayList<>();
        int size = 0;
        for (Item item : items) {
            if (key.equals(item.getName())) {
                itemsFind.add(item);
            }
        }
        return itemsFind;
    }

    public Item findById(String id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (Item item : items) {
            if (id.equals(item.getId())) {
                rsl = items.indexOf(item);
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rp = index == -1;
        if (!rp) {
            item.setId(id);
            items.add(index, item);
            items.remove(index + 1);
        }
        return rp;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rp = index == -1;
        if (!rp) {
            items.remove(index);
        }
        return rp;
    }

}
