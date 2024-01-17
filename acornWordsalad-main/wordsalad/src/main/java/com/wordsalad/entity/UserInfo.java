package com.wordsalad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name="USERINFO")
@Getter
@Setter
@ToString
@AllArgsConstructor 
@NoArgsConstructor
public class UserInfo {
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="PW")
	private String pw;

	private String nickname;
	
	@Column(name="TELENUM")
	private String teleNum;
	
	@Column(name="POSTCOUNT")
	private int postCount;
	
	@Column(name="COMMENTCOUNT")
	private int cmtCount;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="REGISTDATE")
	private String registDate;
	
//	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	private List<CommentInfo> commentInfo = new ArrayList<CommentInfo>();

}
