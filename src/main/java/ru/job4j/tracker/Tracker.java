package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
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

    public Item[] findAll() {
//        Item[] itemsWithoutNull = new Item[this.items.length];
//        int size = 0;
//        for (int index = 0; index < this.items.length; index++) {
//            Item item = this.items[index];
//            if (Objects.nonNull(item)) {
//                itemsWithoutNull[size] = item;
//                size++;
//            }
//        }
        return Arrays.copyOf(this.items, position);
    }

    public Item[] findByName(String key) {
        Item[] itemsFind = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item = this.items[index];
            if (key.equals(this.items[index].getName())) {
                itemsFind[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsFind, size);
    }

    public Item findById(String id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items[index] : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        boolean rp = indexOf(id) == -1;
        if (rp) {
            System.out.println("this item doesn't exist");
        } else {
            item.setId(id);
            items[indexOf(id)] = item;
        }
        return rp;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rp = indexOf(id) == -1;
        if (rp) {
            System.out.println("this item doesn't exist");
        } else {
            int startPos = index + 1;
            System.arraycopy(items, startPos, items, index, position - startPos);
            items[position - 1] = null;
            position--;
        }
        return rp;
    }

}
