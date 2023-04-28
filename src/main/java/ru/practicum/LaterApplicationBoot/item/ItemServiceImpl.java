package ru.practicum.LaterApplicationBoot.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.REPEATABLE_READ)
class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> getItems(long userId) {
        return repository.findByUserId(userId).stream()
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto addNewItem(long userId, ItemDto itemDto) {
        itemDto.setUserId(userId);
        return ItemMapper.toItemDto(repository.save(ItemMapper.toItem(itemDto)));
    }

    @Override
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}