package com.kata.academy.profileservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Профиль пассажира, паспортные данные
 */

@Entity
@Data
@NoArgsConstructor
public class PassportInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //серия паспорта
    @Column(name = "passport_series")
    private String passSeries;

    //номер паспорта
    @Column(name = "passport_number")
    private String passNumber;

    //срок действия паспорта
    @Column(name = "expired_date")
    private LocalDate passExpired;

    //имя латинскими буквами
    @Column(name = "name_lat")
    private String latinName;

    //фамилия латинскими буквами
    @Column(name = "surname_lat")
    private String latinSurname;

    @OneToOne(mappedBy = "passportInfo")
    private Profile profile;

}
