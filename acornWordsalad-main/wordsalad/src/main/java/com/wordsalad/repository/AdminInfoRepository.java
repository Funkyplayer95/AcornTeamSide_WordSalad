package com.wordsalad.repository;

import com.wordsalad.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminInfoRepository extends JpaRepository<UserInfo, String> {

}
