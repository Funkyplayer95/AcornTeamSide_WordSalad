package com.wordsalad.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wordsalad.entity.Postinfo;

public interface PostLIstRepository extends JpaRepository<Postinfo, Integer>{
	
	Page<Postinfo> findAll(Pageable pageable);
	
	Page<Postinfo> findByCategory(String category, Pageable pageable);
	
	Page<Postinfo> findByposttitleContaining(String keyword, Pageable pageable);
}
