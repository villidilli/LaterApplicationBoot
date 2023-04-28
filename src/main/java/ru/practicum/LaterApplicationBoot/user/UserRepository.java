package ru.practicum.LaterApplicationBoot.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.LaterApplicationBoot.User;

import java.util.List;

interface UserRepository extends JpaRepository<User, Long> {
}