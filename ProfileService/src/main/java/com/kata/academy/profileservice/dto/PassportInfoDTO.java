package com.kata.academy.profileservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportInfoDTO {

    private String passSeries;
    private String passNumber;
    private LocalDate passExpired;
    private String latinName;
    private String latinSurname;


}

