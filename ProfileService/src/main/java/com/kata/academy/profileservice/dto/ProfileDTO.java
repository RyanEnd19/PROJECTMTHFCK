package com.kata.academy.profileservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {

    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
    private PassportInfoDTO passportInfo;


}
