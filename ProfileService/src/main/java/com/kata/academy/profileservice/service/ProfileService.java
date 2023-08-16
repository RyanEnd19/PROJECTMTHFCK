package com.kata.academy.profileservice.service;

import com.kata.academy.profileservice.dto.ProfileDTO;

public interface ProfileService {

    ProfileDTO createProfile(ProfileDTO profileDTO); // Создание профиля

    ProfileDTO updateProfile(Long profileId, ProfileDTO profileDTO); // Обновление профиля

    void deleteProfile(Long profileId); // Удаление профиля
}