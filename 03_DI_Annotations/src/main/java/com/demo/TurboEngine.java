package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TurboEngine implements Engine{

	public TurboEngine() {
		System.out.println("it is turbo engine");
	}
	public void power() {
		System.out.println("powered by turbo");
	}
}