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
public class RegistUserDto {
	private String id;
	private String pw;
	private String nickName;
	private String teleNum;
	private String STATE;
	private String REGISTDATE;
}
