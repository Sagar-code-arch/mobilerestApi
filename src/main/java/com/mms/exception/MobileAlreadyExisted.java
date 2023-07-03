package com.mms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class MobileAlreadyExisted extends Exception{
	public MobileAlreadyExisted(String message) {
		
		super(message);
		
	}

}
