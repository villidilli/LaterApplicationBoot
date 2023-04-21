package ru.practicum.LaterApplicationBoot.item;

import java.util.List;

interface ItemService {
    Item addNewItem(long userId, Item item);

    List<Item> getItems(long userId);

    void deleteItem(long userId, long itemId);
}