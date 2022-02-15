package com.demo;

import java.util.*;

public class Shape {
	private Set<Point> points;

	
	public void setPoints(Set<Point> points) {
		this.points = points;
	}

	public void printShape() {
		points.forEach(p -> System.out.println(p));
	}

}