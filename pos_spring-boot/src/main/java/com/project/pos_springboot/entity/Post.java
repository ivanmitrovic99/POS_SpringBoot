package com.project.pos_springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String author;
	private String content;
	private String date;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(long id, String author, String content, String date) {
		super();
		this.id = id;
		this.author = author;
		this.content = content;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", author=" + author + ", content=" + content + ", date=" + date + "]";
	}
	
	
	
}
