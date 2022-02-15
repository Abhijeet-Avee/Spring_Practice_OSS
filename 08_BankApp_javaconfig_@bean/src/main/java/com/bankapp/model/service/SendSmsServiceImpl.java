package com.bankapp.model.service;

import org.springframework.stereotype.Service;

public class SendSmsServiceImpl implements SendSmsService{

	@Override
	public void sendSms() {
		System.out.println("sms is send...");
	}

}