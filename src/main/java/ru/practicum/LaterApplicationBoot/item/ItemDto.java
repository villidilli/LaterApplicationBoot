package ru.practicum.LaterApplicationBoot.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {
    private Long id;
    private Long userId;
    private String url;
    private Set<String> tags;
}