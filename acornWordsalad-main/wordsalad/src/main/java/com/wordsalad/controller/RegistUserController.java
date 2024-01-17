package com.wordsalad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordsalad.dto.RegistUserDto;
import com.wordsalad.service.RegistUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistUserController {
	
	
	private final RegistUserService rergistuserservice;
	
	@GetMapping("/regist")
	public String registForm(@ModelAttribute RegistUserDto rud) {
		
		return "registUser";
	}
	
	@PostMapping("/regist")
	public String registUser(@RequestParam("id") String id, @RequestParam("nickName") String nickName,
								@RequestParam("pw") String pw, @RequestParam("teleNum") String teleNum) {
		
		RegistUserDto registUser = new RegistUserDto();
		
		registUser.setId(id);
		registUser.setPw(pw);
		registUser.setNickName(nickName);
		registUser.setTeleNum(teleNum);
		
		rergistuserservice.registUser(registUser);
		
		return "redirect:/main";
	}

}
