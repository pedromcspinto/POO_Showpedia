package Exceptions;

@SuppressWarnings("serial")
public class PlayedByVirtualException extends Exception{
	public static final String MESSAGE = " is played by a virtual actor!";
	
	public PlayedByVirtualException(String name){
		super(name+MESSAGE);
		
	}
}
