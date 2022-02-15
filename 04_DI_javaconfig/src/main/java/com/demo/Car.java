package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="car")
public class Car {
	@Value(value="i10")
	private String name;
	
	@Autowired
	private Engine engine;
	
	public Car() {
		System.out.println("Car()");
	}
	
	public Car(String name, Engine engine) {
		this.name = name;
		this.engine = engine;
	}
	public Car(String name) {
		System.out.println("public Car(String name) ");
		this.name = name;
	}

	public void move() {
		System.out.println("car is moving");
		engine.power();
	}
	
	public String getName() {
		return name;
	}
	//---setter for name
	public void setName(String name) {
		this.name = name;
	}
	public Engine getEngine() {
		return engine;
	}
	//--setter for engine
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
}
