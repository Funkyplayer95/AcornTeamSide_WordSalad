package com.wordsalad.controller;


import com.wordsalad.dto.CmtDto;
import com.wordsalad.dto.PostDto;
import com.wordsalad.service.CmtService;
import com.wordsalad.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
	String date = LocalDate.now().toString().substring(0, 10);
	@Autowired
	private final PostService postService;
	private final CmtService cmtService;

	@GetMapping("/Post")
	public String findById(@RequestParam("postnum") int postnum ,ModelMap modelMap) {
		
		PostDto postData = postService.getpostInfo(postnum);
		List<CmtDto> cmtData = cmtService.getcmtInfo(postnum);
		modelMap.addAttribute("postinfo", postData);		
		modelMap.addAttribute("cmtinfo", cmtData);		
		
		return "Post";
	}
	
	@GetMapping("/newCmt")
	public String newComment(@RequestParam("postnum") int postnum, @RequestParam("cmtcontenct")String cmtcontenct, 
			ModelMap modelMap, HttpServletRequest req) {
		
		System.out.println("시간"+date);
		cmtService.newComment(req, postnum, date, cmtcontenct);
		findById(postnum, modelMap);
		
		return "Post";
	}
	
	@GetMapping("/likeAndHate")
	public String likeAndHate(ModelMap modelMap, @RequestParam("postnum") int postnum, @RequestParam("butname") String butname){
		
		postService.updateLikeAndHate(postnum,butname);
		findById(postnum, modelMap);
		
		return "Post";
	}
}
