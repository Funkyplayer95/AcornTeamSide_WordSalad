package com.wordsalad.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "COMMENTINFO")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cmtinfo {
	@Id
	private int COMMENT_SEQ;
	private int POSTNUMBER;
	private String COMMENTCONTENTS;
	private String ID;
	private String COMMENTDATE;
	@Builder.Default 
	private int COMMENTLIKE = 0;
	@Builder.Default 
	private int COMMENTHATE = 0;

}
