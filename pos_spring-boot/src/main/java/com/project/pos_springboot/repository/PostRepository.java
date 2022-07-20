package com.project.pos_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pos_springboot.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	

}
