package Exceptions;

@SuppressWarnings("serial")
public class AlreadyFamilyException extends Exception{
	public static final String MESSAGE = "What else is new? We already know about those two...";
	
	public AlreadyFamilyException(){
		super(MESSAGE);
		
	}
}
