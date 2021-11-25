package Exceptions;

@SuppressWarnings("serial")
public class NoShowSelectedException extends Exception{
	public static final String MESSAGE = "No show is selected!";
	
	public NoShowSelectedException(){
		super(MESSAGE);
		
	}
}
