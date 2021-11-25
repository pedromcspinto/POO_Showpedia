package Events;

import java.util.*;

import Characters.*;

public class EventClass implements Event{

	private int season;
	private int episode;
	private String description;
	private List<Characters> pool;
	
	public EventClass(int season, int episode, String description, List<Characters> pool) {
		this.season = season;
		this.episode = episode;
		this.description = description;
		this.pool=pool;
		
	}

	@Override
	public String getDescription() {
		return description;
	}
}
