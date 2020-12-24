package com.moon.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.blog.model.Reply;

public interface ReplyRepository  extends JpaRepository<Reply, Integer>{
	

}
