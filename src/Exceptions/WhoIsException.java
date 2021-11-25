package Exceptions;


@SuppressWarnings("serial")
public class WhoIsException extends Exception{
	public static final String MESSAGE = "Who is";
	public static final String SPACE = " ";
	public static final String INTERROGATION = "?";
	
	public WhoIsException(String actorName) {
		super(MESSAGE+SPACE+actorName+INTERROGATION);
		
	}
}