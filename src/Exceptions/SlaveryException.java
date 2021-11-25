package Exceptions;

@SuppressWarnings("serial")
public class SlaveryException extends Exception{
	public static final String MESSAGE = "Slavery is long gone and this is outrageous!";
	
	public SlaveryException(){
		super(MESSAGE);
		
	}
}
