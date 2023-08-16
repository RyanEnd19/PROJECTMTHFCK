package com.kata.academy.profileservice.service;

import com.kata.academy.profileservice.dto.PassportInfoDTO;
import com.kata.academy.profileservice.dto.ProfileDTO;
import com.kata.academy.profileservice.model.PassportInfo;
import com.kata.academy.profileservice.model.Profile;
import com.kata.academy.profileservice.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setBirthDate(profileDTO.getBirthDate());

        PassportInfoDTO passportInfoDTO = profileDTO.getPassportInfo();
        profile.setPassportInfo(passportInfoDTO);

        profile = profileRepository.save(profile);

        return profileDTO;
    }

    @Override
    public ProfileDTO updateProfile(Long profileId, ProfileDTO profileDTO) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Профиль не найден с ID: " + profileId));

        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setBirthDate(profileDTO.getBirthDate());
        profile.setPassportInfo(profileDTO.getPassportInfo());

        profile = profileRepository.save(profile);
        return profileDTO;
    }

    @Override
    public void deleteProfile(Long accountId) {
        Profile profile = profileRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("Профиль не найден с ID аккаунта: " + accountId));

        profileRepository.delete(profile);
    }
}
