package Exceptions;

@SuppressWarnings("serial")
public class DuplicateCharactersException extends Exception{
	public static final String MESSAGE = "Duplicate character names are not allowed!";
	
	public DuplicateCharactersException(){
		super(MESSAGE);
		
	}
}
