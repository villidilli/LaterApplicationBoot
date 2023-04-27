package ru.practicum.LaterApplicationBoot;

import lombok.*;
import ru.practicum.LaterApplicationBoot.user.UserState;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column
    private String surname;
    @Column(name = "registration_date")
    private Instant registrationDate;
    @Enumerated(value = EnumType.STRING)
    private UserState state;
}
