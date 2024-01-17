package com.wordsalad.dto;

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
public class UserDto  {
	
	private String id;
	
	private String pw;
	
	private String TELENUM;
	
	private String nickname;
	
	private int POSTCOUNT;
	private int COMMENTCOUNT;
	private String state;
	private String registdate;
	
}
