package Exceptions;

@SuppressWarnings("serial")
public class AlreadyRomanceException extends Exception{
	public static final String MESSAGE = " cannot be in a single person romantic relationship!";
	
	public AlreadyRomanceException(String name){
		super(name+MESSAGE);
		
	}
}
