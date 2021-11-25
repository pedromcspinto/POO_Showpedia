package Exceptions;

@SuppressWarnings("serial")
public class SamePersonException extends Exception{
	public static final String MESSAGE = " cannot be parent and child at the same time!";
	
	public SamePersonException(String name){
		super(name+MESSAGE);
		
	}
}
