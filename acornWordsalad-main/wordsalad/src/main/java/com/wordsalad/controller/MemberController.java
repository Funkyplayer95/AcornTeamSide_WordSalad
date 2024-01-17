package com.wordsalad.controller;

import com.wordsalad.dto.LoginDto;
import com.wordsalad.entity.UserInfo;
import com.wordsalad.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	@Autowired
	private final LoginService loginservice;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginDto logindto, HttpSession session) {
		
		Optional<UserInfo> useinfo = loginservice.loginCheck(logindto);
		String path;
		
		if(useinfo.isEmpty()) {
			path="login";
		}
		else {
			System.out.println("성공");
			UserInfo uinfo = useinfo.get();
			session.setAttribute("id", uinfo.getId());
			session.setAttribute("nickName", uinfo.getNickname());
			session.setAttribute("state", uinfo.getState());
			
			path="redirect:/main";
		}
		
		return path;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/main";
	}
	

}
