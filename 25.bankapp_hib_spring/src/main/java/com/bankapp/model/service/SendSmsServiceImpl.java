package com.bankapp.model.service;

import org.springframework.stereotype.Service;

import com.bankapp.model.service.exceptions.NotYetImplementedException;

@Service
public class SendSmsServiceImpl implements SendSmsService{

	@Override
	public void sendSms() {
		System.out.println("sms is send...");
		throw new NotYetImplementedException("not yet implemented");
	}

}
