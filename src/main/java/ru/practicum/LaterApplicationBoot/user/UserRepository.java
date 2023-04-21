package ru.practicum.LaterApplicationBoot.user;

import ru.practicum.LaterApplicationBoot.User;

import java.util.List;

interface UserRepository {
    List<User> findAll();
    User save(User user);
}