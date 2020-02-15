package edu.progetto.exception;

public class EmailAlreadyRegistered extends RuntimeException{
	public EmailAlreadyRegistered(String message) {super(message);}
}
