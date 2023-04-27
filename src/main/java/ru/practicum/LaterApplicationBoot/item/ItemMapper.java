package ru.practicum.LaterApplicationBoot.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemMapper {
    public static Item toItem(ItemDto itemDto) {
        Item item = new Item();
        item.setUserId(itemDto.getUserId());
        item.setUrl(itemDto.getUrl());
        item.setTags(itemDto.getTags());
        return item;
    }

    public static ItemDto toItemDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setTags(item.getTags());
        itemDto.setUrl(item.getUrl());
        itemDto.setUserId(item.getUserId());
        return itemDto;
    }
}