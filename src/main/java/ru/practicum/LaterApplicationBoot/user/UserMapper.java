package ru.practicum.LaterApplicationBoot.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.LaterApplicationBoot.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    private static final String datePattern = "yyyy.MM.dd, HH:mm:ss";
    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setState(UserState.valueOf(userDto.getState()));
        convertStringToInstant(userDto, user);
        decompileFullName(userDto.getFullName(), user);
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setState(String.valueOf(user.getState()));
        convertInstantToString(user, userDto);
        compileFullName(user, userDto);
        return userDto;
    }

    private static User decompileFullName(String fullName, User user) {
        String nameWithoutSpaces = fullName.strip();
        String[] nameParts = nameWithoutSpaces.split(" ");
        user.setFirstName(nameParts[0]);
        user.setMiddleName(nameParts[1]);
        user.setSurname(nameParts[2]);
        return user;
    }

    private static UserDto compileFullName(User user, UserDto userDto) {
        String fullName = String.join(" ", user.getFirstName(), user.getMiddleName(), user.getSurname());
        userDto.setFullName(fullName);
        return userDto;
    }

    private static UserDto convertInstantToString(User user, UserDto userDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        LocalDateTime ldt = LocalDateTime.ofInstant(user.getRegistrationDate(), ZoneOffset.UTC);
        userDto.setRegistrationDate(formatter.format(ldt));
        return userDto;
    }

    private static User convertStringToInstant(UserDto userDto, User user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        LocalDateTime dateTime = LocalDateTime.parse(userDto.getRegistrationDate(), formatter);
        user.setRegistrationDate(dateTime.toInstant(ZoneOffset.UTC));
        return user;
    }
}