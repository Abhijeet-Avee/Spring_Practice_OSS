package com.empapp.web.ex_handlers;

import java.util.Date;

public class ErrorData {
	
	private String errorMessage;
	private Date date;
	private String name;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ErrorData(String errorMessage, Date date, String name) {
		super();
		this.errorMessage = errorMessage;
		this.date = date;
		this.name = name;
	}

	public ErrorData() {
	}

}
