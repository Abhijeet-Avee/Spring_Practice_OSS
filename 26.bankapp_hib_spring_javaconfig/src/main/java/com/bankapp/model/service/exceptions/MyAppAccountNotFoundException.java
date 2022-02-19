package com.bankapp.model.service.exceptions;

public class MyAppAccountNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public MyAppAccountNotFoundException(String arg0) {
		super(arg0);
		
	}
	
}
