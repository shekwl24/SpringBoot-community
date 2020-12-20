package com.moon.blog.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moon.blog.model.Board;
import com.moon.blog.model.User;


public interface BoardRepository extends JpaRepository<Board, Integer>{

}
