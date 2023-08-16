package com.kata.academy.profileservice.service;

import com.kata.academy.profileservice.dto.PassportInfoDTO;

public interface PassportInfoService {
    PassportInfoDTO createOrUpdatePassportInfo(PassportInfoDTO passportInfoDTO);
}