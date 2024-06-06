package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@NoArgsConstructor

public class User {
	
	private int userId;
	private int id;
	private String title;
	private String body;

	public int getUserId() {
		return userId;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getBody() {
		return body;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBody(String body) {
		this.body = body;
	}



}
	
