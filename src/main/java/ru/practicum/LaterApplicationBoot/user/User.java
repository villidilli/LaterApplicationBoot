package ru.practicum.LaterApplicationBoot;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String email;
    private String name;
}
