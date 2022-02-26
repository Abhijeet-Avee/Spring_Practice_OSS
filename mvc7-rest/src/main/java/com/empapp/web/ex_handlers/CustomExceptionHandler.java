package com.empapp.web.ex_handlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.model.exceptions.EmployeeNotFoundException;

@ControllerAdvice		//AOP
@RestController
public class CustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorData> handle404Error(EmployeeNotFoundException exception){
		ErrorData data = new ErrorData();
		data.setDate(new Date());
		data.setErrorMessage(exception.getMessage());
		data.setName("contact: yashavee");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorData> handle500Error(Exception exception){
		ErrorData data = new ErrorData();
		data.setDate(new Date());
		data.setErrorMessage("server down");
		data.setName("contact: yashavee");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
	}
	
}
