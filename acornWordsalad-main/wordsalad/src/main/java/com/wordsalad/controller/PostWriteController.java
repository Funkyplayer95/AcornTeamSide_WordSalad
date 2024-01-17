package com.wordsalad.controller;

import com.wordsalad.dto.PostWriteDto;
import com.wordsalad.service.PostWriteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostWriteController {
	
	private final PostWriteService postwriteservice;
	
	@GetMapping("/postwrite")
	public String postform(){
		return "postWrite";
	}
	
	
	@PostMapping("/postwrite")
	public String postwrite(@RequestParam("title") String posttitle, @RequestParam("content") String postcontents, HttpServletRequest req) {
		
		System.out.println(posttitle);
		System.out.println(postcontents);
		
		PostWriteDto postwritedto = new PostWriteDto();
		
		postwritedto.setPOSTTITLE(posttitle);
		postwritedto.setPOSTCONTENTS(postcontents);
		
		postwriteservice.postwrite(postwritedto, req);
		
		return "redirect:/main";
	}
}
