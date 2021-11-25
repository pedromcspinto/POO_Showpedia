package Exceptions;

@SuppressWarnings("serial")
public class ShowDoNotExistsException extends Exception{
	public static final String MESSAGE = "Unknown show!";
	
	public ShowDoNotExistsException() {
		super(MESSAGE);
		
	}
}
