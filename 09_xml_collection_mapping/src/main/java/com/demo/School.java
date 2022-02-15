package com.demo;
import java.util.*;
public class School {
	
	private String schoolName;
	private Map<String, Teacher> teacherMap;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Map<String, Teacher> getTeacherMap() {
		return teacherMap;
	}
	public void setTeacherMap(Map<String, Teacher> teacherMap) {
		this.teacherMap = teacherMap;
	}
	
	public void print() {
		System.out.println("school naem: "+ schoolName);
		teacherMap.forEach((k, v)-> System.out.println(k +" : "+ v));
	}
	
}