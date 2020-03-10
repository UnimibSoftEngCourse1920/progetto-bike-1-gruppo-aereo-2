package edu.progetto.exception;

public class ExistingUserException extends RuntimeException{
    
	private static final long serialVersionUID = -5015579004371326985L;

	public ExistingUserException(String message) {super(message);}
}
