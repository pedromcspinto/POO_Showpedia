package Shows;

import java.util.*;

import Characters.*;
import Events.*;

public class ShowClass implements Show, Comparable<Show>{
	private static final String SPACE=" ";
	private static final String DOT=".";
	private static final String TWO_DOTS=":";
	private static final String SEASONS="Seasons";
	private static final String EPISODES="Episodes";
	private static final String PARENTS = "Parents";
	private static final String KIDS = "Kids";
	private static final String SIBLINGS = "Siblings";
	private static final String ROMANCE = "Romantic relationships";
	private String showName;
	private int Nseasons;
	private int Nepisodes;
	private Map<Integer, List<Episode>> seasons;
	private Map<String, List<Event>> events;
	private List<Characters> characters;
	
	
	public ShowClass(String showName) {
		this.showName=showName;
		Nseasons=0;
		Nepisodes=0;
		seasons = new HashMap<Integer, List<Episode>>();
		characters = new ArrayList<Characters>();
		events = new HashMap<String, List<Event>>();
		
	}

	@Override
	public String getName() {
		return showName;
		
	}

	@Override
	public int getNseasons() {
		return Nseasons;
		
	}

	@Override
	public int getNepisodes() {
		return Nepisodes;
		
	}

	@Override
	public void addSeason() {
		List<Episode> L = new ArrayList<Episode>();
		int key = seasons.size()+1;
		seasons.put(key, L);
		Nseasons++;
		
	}

	@Override
	public void addEpisodeToSeason(int season, Episode episode) {
		seasons.get(season).add(episode);
		Nepisodes++;
		int ep = seasons.get(season).indexOf(episode)+1;
		String key = (season+"") + (ep+"");
		List<Event> L = new ArrayList<Event>();
		events.put(key, L);
		
	}
	
	public String toString() {
		return getName()+DOT+SPACE+SEASONS+TWO_DOTS+SPACE+getNseasons()+SPACE+EPISODES+TWO_DOTS+SPACE+getNepisodes();
		
	}

	@Override
	public int numberOfEpisode(int season) {
		return seasons.get(season).size();
		
	}

	@Override
	public boolean existSeason(int season) {
		return seasons.containsKey(season);
		
	}

	@Override
	public void addCharacter(Characters charact) {
		characters.add(charact);
		
	}

	@Override
	public boolean existsCharacter(Characters charact) {
		Iterator<Characters> it = characters.iterator();
		boolean found = false;
		while(it.hasNext()) {
			Characters c = it.next();
			if(c.getActorName().equals(charact.getActorName()))
				found = true;
		}
		return found;
	}

	@Override
	public void addEvent(Event e, int season, int episode) {	
		String key = (season+"") + (episode+"");
		List<Event> L = events.get(key);
		L.add(e);
	}

	@Override
	public Iterator<Episode> listEpisodes(int season) {
		return seasons.get(season).iterator();
	}

	@Override
	public Iterator<Event> listEvents(String key) {	
		return events.get(key).iterator();
	}

	@Override
	public boolean hasEvent(String key) {
		List<Event> L = events.get(key);
		return (L.size()!=0);
	}

	@Override
	public String getEpisodeName(int season, int episode) {
		Episode e = seasons.get(season).get(episode-1);
		return e.getEpisodeName();
	}

	@Override
	public Characters findCharacter(String actorName) {
		Iterator<Characters> it = characters.iterator();
		Characters C = null;
		while(it.hasNext()) {
			C = it.next();
			if(C.getActorName().equals(actorName))
				break;		
		}
		return C;
	}

	@Override
	public void addEventToCharacter(Event e, String key, List<Characters> L) {
		Iterator<Characters> it = L.iterator();
		while(it.hasNext()) {
			Characters C = it.next();
			C.addEvent(key, e);
			
		}
		
	}

	@Override
	public boolean checkCharacters(String actorName) {
		boolean found = false; 
		Iterator<Characters> it = characters.iterator();
		while (it.hasNext()) {
			Characters C = it.next();
			if(C.getActorName().equals(actorName))
				found = true;
		}				
		return found;
	}

	@Override
	public int compareTo(Show show) {
		int compare = this.getName().compareTo(show.getName());
		return compare;
	}
}
