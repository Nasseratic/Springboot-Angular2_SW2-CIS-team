package com.restful.hello.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApiUser {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String pw;
	private String type;

	public ApiUser() {
		
	}
	
	public ApiUser(Integer id, String name, String email, String pw, String type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}