package com.capgemini.exception;


//@ResponseStatus(value = HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception{
	public ResourceNotFoundException(String message){
    	super(message);
    }
}
