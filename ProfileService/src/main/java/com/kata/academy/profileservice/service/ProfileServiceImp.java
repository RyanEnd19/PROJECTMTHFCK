package com.kata.academy.profileservice.service;

import com.kata.academy.profileservice.dto.PassportInfoDTO;
import com.kata.academy.profileservice.dto.ProfileDTO;
import com.kata.academy.profileservice.model.PassportInfo;
import com.kata.academy.profileservice.model.Profile;
import com.kata.academy.profileservice.repositories.PassportInfoRepository;
import com.kata.academy.profileservice.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PassportInfoRepository passportInfoRepository;

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        // Преобразование DTO в сущность
        Profile profile = new Profile();
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setBirthDate(profileDTO.getBirthDate());

        PassportInfo passportInfo = new PassportInfo();
        passportInfo.setPassSeries(profileDTO.getPassportInfo().getPassSeries());
        passportInfo.setPassNumber(profileDTO.getPassportInfo().getPassNumber());
        passportInfo.setPassExpired(profileDTO.getPassportInfo().getPassExpired());
        passportInfo.setLatinName(profileDTO.getPassportInfo().getLatinName());
        passportInfo.setLatinSurname(profileDTO.getPassportInfo().getLatinSurname());

        profile.setPassportInfo(passportInfo);
        profile = profileRepository.save(profile);

        // Возвращаем сущность обратно в DTO
        profileDTO.setPassportInfo(new PassportInfoDTO(
                passportInfo.getPassSeries(),
                passportInfo.getPassNumber(),
                passportInfo.getPassExpired(),
                passportInfo.getLatinName(),
                passportInfo.getLatinSurname()
        ));
        return profileDTO;
    }

    @Override
    public ProfileDTO updateProfile(Long profileId, ProfileDTO profileDTO) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Профиль не найден с ID: " + profileId));

        // Обновляем поля профиля
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setBirthDate(profileDTO.getBirthDate());

        // Обновляем паспортные данные
        PassportInfo passportInfo = profile.getPassportInfo();
        passportInfo.setPassSeries(profileDTO.getPassportInfo().getPassSeries());
        passportInfo.setPassNumber(profileDTO.getPassportInfo().getPassNumber());
        passportInfo.setPassExpired(profileDTO.getPassportInfo().getPassExpired());
        passportInfo.setLatinName(profileDTO.getPassportInfo().getLatinName());
        passportInfo.setLatinSurname(profileDTO.getPassportInfo().getLatinSurname());

        profile = profileRepository.save(profile);

        // Возвращаем сущность обратно в DTO
        profileDTO.setPassportInfo(new PassportInfoDTO(
                passportInfo.getPassSeries(),
                passportInfo.getPassNumber(),
                passportInfo.getPassExpired(),
                passportInfo.getLatinName(),
                passportInfo.getLatinSurname()
        ));
        return profileDTO;
    }

    @Override
    public void deleteProfile(Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Профиль не найден с ID: " + profileId));

        profileRepository.delete(profile);
    }
}
