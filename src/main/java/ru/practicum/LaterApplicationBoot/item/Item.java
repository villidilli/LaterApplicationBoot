package ru.practicum.LaterApplicationBoot.item;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
class Item {
    private Long id;
    private Long userId;
    private String url;
}