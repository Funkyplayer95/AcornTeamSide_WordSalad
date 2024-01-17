package com.wordsalad.service;




import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.wordsalad.dto.UserDto;
import com.wordsalad.entity.UserInfo;
import com.wordsalad.repository.MypageRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 데이터를 불러와서 db에 넣고 실행이 끝나면 모든 작업들을 원상태로 되돌릴 수 있다. 안쓰는곳엔 (readOnly=true)
@RequiredArgsConstructor
public class MypageService {

	private final MypageRepository mypageRepository;

	public UserDto getuserInfo(String id) {

		UserInfo user = mypageRepository.findById(id).orElseThrow(EntityNotFoundException::new); // 언제나 ID값을 같이 넘겨야 null이 뜨지않음.
		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setPw(user.getPw());
		userDto.setNickname(user.getNickname());
		userDto.setTELENUM(user.getTeleNum());
		userDto.setCOMMENTCOUNT(user.getCmtCount());
		userDto.setPOSTCOUNT(user.getPostCount());
		userDto.setState(user.getState());
		userDto.setRegistdate(user.getRegistDate());

		return userDto;
	}

	public void updatePassword(String id, String newPw) {
		
		UserInfo user = mypageRepository.findById(id).orElse(null);
		
		if (user != null) {
			user.setPw(newPw);
			user.setCmtCount(user.getCmtCount());
			user.setNickname(user.getNickname());
			user.setPostCount(user.getPostCount());
			user.setRegistDate(user.getRegistDate().substring(0,10));
			user.setTeleNum(user.getTeleNum());
			user.setState(user.getState());
		
			mypageRepository.save(user);
		}
	}
	public void updateNickName(String id, String newNickname) {
		
		UserInfo user = mypageRepository.findById(id).orElse(null);
		
		if (user != null) {
			user.setPw(user.getPw());
			user.setCmtCount(user.getCmtCount());
			user.setNickname(newNickname);
			user.setPostCount(user.getPostCount());
			user.setRegistDate(user.getRegistDate().substring(0,10));
			user.setTeleNum(user.getTeleNum());
			user.setState(user.getState());
			
			mypageRepository.save(user);
		}
	}
	public void updateTel(String id, String newTel) {
		
		UserInfo user = mypageRepository.findById(id).orElse(null);
		
		if (user != null) {
			user.setPw(user.getPw());
			user.setCmtCount(user.getCmtCount());
			user.setNickname(user.getNickname());
			user.setPostCount(user.getPostCount());
			user.setRegistDate(user.getRegistDate().substring(0,10));
			user.setTeleNum(newTel);
			user.setState(user.getState());
			
			mypageRepository.save(user);
		}
	}

	public void checkPassword(String id, String Pw) {
		UserInfo user = mypageRepository.findById(id).orElse(null);
		if (user != null) {
			if (user.getPw() == Pw) {

			} else {
				System.out.println("실패");
			}
		}
	}

}
