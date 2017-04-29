package com.swe2.controller;

import java.util.ArrayList;

public class Courses {
	static ArrayList<Courses> AllCourses= new ArrayList<Courses>(); 
String name ;
String description ;
String category ; 
String courseid ;
String teacherId ; 
static int counter =0; 

Courses(){
	
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getId() {
	return courseid;
}
public void setId(String id) {
	this.courseid = id;
}
public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getCourseid() {
	return courseid;
}

public void setCourseid(String courseid) {
	this.courseid = courseid;
}

public String getTeacherId() {
	return teacherId;
}

public void setTeacherId(String teacherId) {
	this.teacherId = teacherId;
}

}
