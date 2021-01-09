package com.moon.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}