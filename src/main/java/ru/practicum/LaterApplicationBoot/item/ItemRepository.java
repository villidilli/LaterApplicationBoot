package ru.practicum.LaterApplicationBoot.item;

import java.util.List;

interface ItemRepository {

    List<Item> findByUserId(long userId);

    Item save(Item item);

    void deleteByUserIdAndItemId(long userId, long itemId);
}