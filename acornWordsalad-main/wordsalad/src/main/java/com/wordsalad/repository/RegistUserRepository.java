package com.wordsalad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wordsalad.entity.UserInfo;

@Repository
public interface RegistUserRepository extends JpaRepository<UserInfo, String>{

}
