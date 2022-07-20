package com.project.pos_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.pos_springboot.entity.Post;
import com.project.pos_springboot.repository.PostRepository;

@Service
public class PostService {

@Autowired
private PostRepository repository;

public List<Post> getPosts(){
	return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
}

public void save(Post post) {
	repository.save(post);
}
}
