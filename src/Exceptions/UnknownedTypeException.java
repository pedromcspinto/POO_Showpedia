package Exceptions;

@SuppressWarnings("serial")
public class UnknownedTypeException extends Exception{
	public static final String MESSAGE = "Unknown actor category!";
	
	public UnknownedTypeException() {
		super(MESSAGE);
		
	}
}