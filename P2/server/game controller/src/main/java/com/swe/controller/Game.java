package com.swe.controller;

import java.util.ArrayList;

public class Game {
	
	ArrayList<Game> allGames= new ArrayList<Game>();
	//int gCount= 0;
	
	String id;
	String name;
	String courseId;
	String category;
	String teacher;
	
public Game() {
		
	}

	public Game(String id, String name, String teacher, String category, String courseId) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.category = category;
		this.courseId= courseId;
	//	this.qs = qs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

//	public Q getQs() {
//		return qs;
//	}
//
//	public void setQs(Q qs) {
//		this.qs = qs;
//	}

}
