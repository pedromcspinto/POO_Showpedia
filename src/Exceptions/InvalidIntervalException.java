package Exceptions;

@SuppressWarnings("serial")
public class InvalidIntervalException extends Exception{
	public static final String MESSAGE = "Invalid seasons interval!";
	
	public InvalidIntervalException(){
		super(MESSAGE);
		
	}
}