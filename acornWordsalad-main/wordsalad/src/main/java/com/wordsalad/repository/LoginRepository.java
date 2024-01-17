package com.wordsalad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wordsalad.entity.UserInfo;

@Repository
public interface LoginRepository extends JpaRepository<UserInfo, String>{
	
	Optional<UserInfo> findByIdAndPw(String id, String pw);
}
