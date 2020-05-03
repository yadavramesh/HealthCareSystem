package com.capgemini.exception;

public class NullValueException extends Exception {


	private static final long serialVersionUID = 1L;
	String errorMessage;
	public NullValueException(String errorMessage)
	{
		this.errorMessage=errorMessage;
	}
	public String toString() {
		return errorMessage;
	}
}
