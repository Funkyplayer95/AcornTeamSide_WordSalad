package com.wordsalad.controller;


import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordsalad.dto.PostListDto;
import com.wordsalad.service.PostListService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
@RequiredArgsConstructor
public class PostListController {
	private final PostListService postListService;
	
	@GetMapping(value = "/postlist")
	public String showAllPostList(@RequestParam("category")String category, 
								ModelMap modelMap,
								@PageableDefault(sort = "posttitle", direction = Sort.Direction.DESC)Pageable pageable) {
		
		Page<PostListDto> postDtoList = postListService.findBycategory(category, pageable);

		int pageNumber= postDtoList.getPageable().getPageNumber(); //현재페이지
		int totalPages= postDtoList.getTotalPages(); //총 페이지 수. 검색에따라 10개면 10개..
		int pageBlock = 5; //블럭의 수 1, 2, 3, 4, 5	
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1; //현재 페이지가 7이라면 1*5+1=6
		int endBlockPage = startBlockPage+pageBlock-1; //6+5-1=10. 6,7,8,9,10해서 10.
		endBlockPage= totalPages<endBlockPage ? totalPages:endBlockPage;
		
		modelMap.addAttribute("postlist", postDtoList);
		modelMap.addAttribute("startBlockPage", startBlockPage);
		modelMap.addAttribute("endBlockPage", endBlockPage);

		return "postlist";

	}

}
