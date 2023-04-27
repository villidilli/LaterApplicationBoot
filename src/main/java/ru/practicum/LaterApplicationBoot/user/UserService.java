package ru.practicum.LaterApplicationBoot.user;

import ru.practicum.LaterApplicationBoot.User;

import java.util.List;

interface UserService {
    List<UserDto> getAllUsers();
    UserDto saveUser(UserDto userDto);
}