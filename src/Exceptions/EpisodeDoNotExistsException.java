package Exceptions;

import Shows.*;

@SuppressWarnings("serial")
public class EpisodeDoNotExistsException extends Exception{
	public static final String MESSAGE = "No show is selected!";
	public static final String DO_NOT_HAVE = "does not have";
	public static final String SPACE = " ";
	public static final String EPISODE = "episode";
	public static final String EXCLAMATION= "!";
	public static final String S = "S";
	
	public EpisodeDoNotExistsException(Show show, int season, int episode){
		super(show.getName()+SPACE+S+season+SPACE+DO_NOT_HAVE+SPACE+EPISODE+SPACE+episode+EXCLAMATION);
		
	}
}