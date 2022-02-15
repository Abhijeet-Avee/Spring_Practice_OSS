package com.demo;
//pull: Car---------> Tyre, Engine, O

public class Car {
	private Tyre tyre;
	private Engine engine;
	
	public Car(Tyre tyre, Engine engine) {
		this.tyre= tyre;
		this.engine=engine;
	}
	
	public void move() {
		tyre.rotate();
		engine.power();
	}
}