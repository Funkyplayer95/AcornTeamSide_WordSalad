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
public class CmtDto{
	
	private int COMMENT_SEQ;
	private int POSTNUMBER;
	private String COMMENTCONTENTS;
	private String COMMENTWRITER;
	private String COMMENTDATE;
	private int COMMENTLIKE;
	private int COMMENTHATE;
	
}
