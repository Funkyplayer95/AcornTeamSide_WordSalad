package com.wordsalad.dto;

//import com.wordsalad.entity.Postinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto  {
	
	private int POSTNUMBER;
	private String POSTTITLE;
	private String POSTCONTENTS;
	private String POSTWRITER;
	private String POSTDATE;
	private int POSTLIKE;
	private int POSTHATE;
	

	//repository 를 통해 조회한 entity 를 dto 로 변환 용도 
//    public UserDto2( user) {
//        this.id = user.getId();
//        this.pw = user.getPw();
//        this.tel = user.getTel();
//        this.nickname = user.getNickname();
//        this.state = user.getState();
//        this.registdate = user.getRegistdate();
//    }
}
