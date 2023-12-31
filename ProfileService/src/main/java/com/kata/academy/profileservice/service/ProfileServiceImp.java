package com.kata.academy.profileservice.service;

import com.kata.academy.profileservice.dto.PassportInfoDTO;
import com.kata.academy.profileservice.dto.ProfileDTO;
import com.kata.academy.profileservice.model.Profile;
import com.kata.academy.profileservice.repositories.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PassportInfoServiceImp passportInfoService;

    @Override
    @Transactional
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        PassportInfoDTO savedPassportInfo = passportInfoService.createOrUpdatePassportInfo(profileDTO.getPassportInfo());
        profileDTO.setPassportInfo(savedPassportInfo);

        Profile profile = new Profile();
        BeanUtils.copyProperties(profileDTO, profile);
        Profile savedProfile = profileRepository.save(profile);
        ProfileDTO savedDTO = new ProfileDTO();
        BeanUtils.copyProperties(savedProfile, savedDTO);
        return savedDTO;
    }

    @Override
    @Transactional
    public ProfileDTO updateProfile(Long profileId, ProfileDTO profileDTO) {
        if (profileDTO.getPassportInfo() != null) {
            passportInfoService.createOrUpdatePassportInfo(profileDTO.getPassportInfo());
        }

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new EntityNotFoundException("Профиль не найден с ID: " + profileId));

        BeanUtils.copyProperties(profileDTO, profile);
        Profile updatedProfile = profileRepository.save(profile);
        ProfileDTO updatedDTO = new ProfileDTO();
        BeanUtils.copyProperties(updatedProfile, updatedDTO);
        return updatedDTO;
    }

    @Override
    @Transactional
    public void deleteProfile(Long accountId) {
        Profile profile = profileRepository.findByAccountId(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Профиль не найден с ID аккаунта: " + accountId));

        profileRepository.delete(profile);
    }
}