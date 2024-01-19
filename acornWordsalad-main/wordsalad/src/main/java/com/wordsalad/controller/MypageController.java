package com.wordsalad.controller;

import com.wordsalad.dto.UserDto;
import com.wordsalad.service.MypageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MypageController {

	@Autowired
	private final MypageService mypageService;

	@GetMapping("/") // URL주소
	public String main() {
		return "main"; // JSP파일
	}

	@GetMapping("/Mypage")
	public String findById(ModelMap modelMap, HttpServletRequest req) {

		String id = req.getSession().getAttribute("id").toString();
		
		UserDto userInfoData = mypageService.getuserInfo(id);

		modelMap.addAttribute("userinfo", userInfoData);

		return "Mypage";
	}
	
	//비밀번호 변경
	@PostMapping("/Mypage/changepw")
	public String changePassword(HttpServletRequest req, Model model) {
	
		String id = req.getSession().getAttribute("id").toString();
		
		UserDto userDto = mypageService.getuserInfo(id);
		model.addAttribute("id", userDto.getId());
		
		return "changepw";
	}
	
	@PostMapping("/Mypage/changepw2")
	public String changePassword2(HttpServletRequest req, @RequestParam("pw") String pw,
			@RequestParam("newPw") String newPw, @RequestParam("checkNewPw") String checkNewPw, Model model) {
		
		String id = req.getSession().getAttribute("id").toString();
		
		UserDto userinfo = mypageService.getuserInfo(id);
		
		if (!newPw.equals(checkNewPw)) {
			model.addAttribute("errorMessage", "비밀번호 확인이 맞지않습니다.");
		} else if (!pw.equals(userinfo.getPw())) {
			model.addAttribute("errorMessage", "현재 비밀번호가 일치하지 않습니다.");
		}
		
		if (newPw.equals(checkNewPw)&&pw.equals(userinfo.getPw())) {
			mypageService.updatePassword(id, newPw);
			model.addAttribute("successMessage", "비밀번호 변경완료!");
			model.addAttribute("userinfo", userinfo);
			model.addAttribute("id", id);
		
			return "redirect:/Mypage?id="+userinfo.getId();
		}
		
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("id", id);
		
		return "changepw";
	}

	
	
	//닉네임 변경
	@PostMapping("/Mypage/changenickname")
	public String changeNickName(HttpServletRequest req, Model model) {
		
		String id = req.getSession().getAttribute("id").toString();
		
		UserDto userDto = mypageService.getuserInfo(id);
		model.addAttribute("id", userDto.getId());
		model.addAttribute("nickname", userDto.getNickname());
	
		return "changenickname";
	}
	
	@PostMapping("/Mypage/changenickname2")
	public String changeNickName(HttpServletRequest req, @RequestParam("pw") String pw,
			@RequestParam("newNickName") String newNickName, Model model) {
		
		String id = req.getSession().getAttribute("id").toString();
		
		UserDto userinfo = mypageService.getuserInfo(id);
		
		if (!pw.equals(userinfo.getPw())) {
			model.addAttribute("errorMessage", "현재 비밀번호가 일치하지 않습니다.");
		}
		
		if (pw.equals(userinfo.getPw())&& newNickName != null) {
			mypageService.updateNickName(id, newNickName);
			model.addAttribute("successMessage", "닉네임 변경완료!");
			model.addAttribute("userinfo", userinfo);
			model.addAttribute("id", id);
		
			return "redirect:/Mypage?id="+userinfo.getId();
		}
		
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("id", id);
		
		return "changenickname";
	}
	
	
	// 전화번호 변경
	@PostMapping("/Mypage/changetel")
	public String changeTel(@RequestParam("id") String id, Model model) {
		UserDto userDto = mypageService.getuserInfo(id);
		model.addAttribute("id", userDto.getId());
		model.addAttribute("tel", userDto.getTELENUM());
		return "changetel";
	}
	@PostMapping("/Mypage/changetel2")
	public String changeTel2(@RequestParam("id") String id, @RequestParam("pw") String pw,
			@RequestParam("newTel") String newTel, Model model) {
		UserDto userinfo = mypageService.getuserInfo(id);
		
		if (!pw.equals(userinfo.getPw())) {
			model.addAttribute("errorMessage", "현재 비밀번호가 일치하지 않습니다.");
		}
		if (pw.equals(userinfo.getPw())&& newTel != null) {
			mypageService.updateTel(id, newTel);
			model.addAttribute("successMessage", "전화번호 변경완료!");
			model.addAttribute("userinfo", userinfo);
			model.addAttribute("id", id);
			return "redirect:/Mypage?id="+userinfo.getId();
		}
		
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("id", id);
		
		return "changetel";
		
	}

	
	
	
	@GetMapping("/Mypage2") // URL주소
	public String mypage2() {
		return "Mypage"; // JSP파일
	}

}
