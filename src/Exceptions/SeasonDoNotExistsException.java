package Exceptions;

import Shows.*;

@SuppressWarnings("serial")
public class SeasonDoNotExistsException extends Exception{
	public static final String MESSAGE = "Unknown season!";
	public static final String DO_NOT_HAVE = "does not have";
	public static final String SPACE = " ";
	public static final String SEASON = "season";
	public static final String EXCLAMATION= "!";
	
	public SeasonDoNotExistsException() {
		super(MESSAGE);
		
	}
	
	public SeasonDoNotExistsException(Show show, int season) {
		super(show.getName()+SPACE+DO_NOT_HAVE+SPACE+SEASON+SPACE+season+EXCLAMATION);
		
	}
}
