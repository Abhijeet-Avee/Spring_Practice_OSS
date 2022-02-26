package com.client;

import com.demo.Calculator;
import com.demo.CalculatorService;

public class DemoClient {
	public static void main(String[] args) {
		CalculatorService calculatorService = new CalculatorService();
		
		Calculator calculator = calculatorService.getCalculatorPort();
		
		System.out.println(calculator.add(2, 2));
	}
}
