package com.wordsalad.service;

import com.wordsalad.dto.PostDto;
import com.wordsalad.entity.Postinfo;
import com.wordsalad.repository.PostLIstRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 데이터를 불러와서 db에 넣고 실행이 끝나면 모든 작업들을 원상태로 되돌릴 수 있다. 안쓰는곳엔 (readOnly=true)
@RequiredArgsConstructor
public class PostService {

	private final PostLIstRepository postRepository;

	public PostDto getpostInfo(int postnum) {

		Postinfo postinfo = postRepository.findById(postnum).orElseThrow(EntityNotFoundException::new);
		PostDto postDto = new PostDto();
		
		postDto.setPOSTNUMBER(postinfo.getPostnumber());
		postDto.setPOSTTITLE(postinfo.getPosttitle());
		postDto.setPOSTCONTENTS(postinfo.getPostcontents());
		postDto.setPOSTWRITER(postinfo.getUserinfo().getId());
		postDto.setPOSTDATE(postinfo.getPostdate().substring(0,10));
		postDto.setPOSTLIKE(postinfo.getPostlike());
		postDto.setPOSTHATE(postinfo.getPosthate());
		
		return postDto;

	}
	
	public void updateLikeAndHate(int postnum, String butname) {
		System.out.println("sjan");
		Postinfo postinfo = null;
		postinfo = postRepository.findById(postnum).orElseThrow(EntityNotFoundException::new);
		if (butname.equals("좋아"))postinfo.setPostlike(postinfo.getPostlike()+1);
		if (butname.equals("싫어"))postinfo.setPosthate(postinfo.getPosthate()+1);
        postinfo.setPostdate(postinfo.getPostdate().substring(0,10));

		postRepository.save(postinfo);
	}
}
