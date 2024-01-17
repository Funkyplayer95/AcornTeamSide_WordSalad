package com.wordsalad.service;

import com.wordsalad.dto.LoginDto;
import com.wordsalad.entity.UserInfo;
import com.wordsalad.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final LoginRepository loginrepository;
	
	public Optional<UserInfo> loginCheck(LoginDto logindto) {
		
		return loginrepository.findByIdAndPw(logindto.getId(), logindto.getPw());
		
	}
	
}
