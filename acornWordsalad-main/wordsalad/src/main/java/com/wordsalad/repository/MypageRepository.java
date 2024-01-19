package com.wordsalad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wordsalad.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MypageRepository extends JpaRepository<UserInfo, String> {

}
