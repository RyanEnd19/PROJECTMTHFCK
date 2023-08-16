package com.kata.academy.profileservice.service;

import com.kata.academy.profileservice.dto.PassportInfoDTO;
import com.kata.academy.profileservice.model.PassportInfo;
import com.kata.academy.profileservice.repositories.PassportInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportInfoServiceImp implements PassportInfoService {

    @Autowired
    private PassportInfoRepository passportInfoRepository;

    @Override
    public PassportInfoDTO createOrUpdatePassportInfo(PassportInfoDTO passportInfoDTO) {
        PassportInfo passportInfo = new PassportInfo();
        BeanUtils.copyProperties(passportInfoDTO, passportInfo);
        PassportInfo savedPassportInfo = passportInfoRepository.save(passportInfo);
        PassportInfoDTO savedDTO = new PassportInfoDTO();
        BeanUtils.copyProperties(savedPassportInfo, savedDTO);
        return savedDTO;
    }
}