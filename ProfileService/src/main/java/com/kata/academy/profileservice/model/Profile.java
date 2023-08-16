package com.kata.academy.profileservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDateTime;


/**
 * Профиль пассажира, информация о пассажире
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private PassportInfo passportInfo;
}
