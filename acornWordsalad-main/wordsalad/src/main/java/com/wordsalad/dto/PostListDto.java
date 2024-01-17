package com.wordsalad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostListDto{
	private int postnumber;
	private String posttitle;
	private String postcontents;
	private String userInfo_Id;
	private String postdate;
//	entity에서 int로 받아서 후처리(+"개")를 해주고 싶어 String 타입으로 바꾼 
	private int postlike;
	private int posthate;
	private String category;
}
