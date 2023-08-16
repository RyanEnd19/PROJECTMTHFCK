package com.kata.academy.profileservice.repositories;

import com.kata.academy.profileservice.model.PassportInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportInfoRepository extends JpaRepository<PassportInfo, Long> {

}
