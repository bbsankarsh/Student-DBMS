package com.CustomException;

public class InvalidChoiceException extends Exception {
	
	private String message;

	public InvalidChoiceException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
		
}
