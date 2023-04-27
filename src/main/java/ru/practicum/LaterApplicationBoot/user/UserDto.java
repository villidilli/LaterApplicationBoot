package ru.practicum.LaterApplicationBoot.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String fullName;
    private String registrationDate;
    private String state;
}