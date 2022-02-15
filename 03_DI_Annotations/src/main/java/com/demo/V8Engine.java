package com.demo;

import org.springframework.stereotype.Component;

@Component
public class V8Engine implements Engine{

	public V8Engine() {
		System.out.println("it is V8Engine engine");
	}
	
	public void power() {
		System.out.println("powered by v8");
	}
}