package Exceptions;

@SuppressWarnings("serial")
public class ShowAlreadyExistsException extends Exception{
	public static final String MESSAGE = "Show already exists!";
	
	public ShowAlreadyExistsException() {
		super(MESSAGE);
		
	}
}
