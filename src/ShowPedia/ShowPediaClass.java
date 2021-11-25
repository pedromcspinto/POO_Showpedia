package ShowPedia;

import java.util.*;

import Characters.*;
import Comparator.ComparatorByName;
import Events.Event;
import Events.EventClass;
import Shows.*;

public class ShowPediaClass implements ShowPedia {
	private static final String REAL = "real";
	private static final String VIRTUAL = "virtual";
	private static final String ROMANCE = "Romantic relationships";
	private Show currentShow;
	private Map<String, Show> shows;
	private Map<String, SortedSet<Show>> real;
	private Map<String, List<Characters>> roles;
	private List<String> mostRomantic;

	public ShowPediaClass() {
		currentShow = null;
		shows = new HashMap<String, Show>();
		real = new HashMap<String,SortedSet<Show>>();
		roles = new HashMap<String, List<Characters>>();
		mostRomantic = new ArrayList<String>();
	}
	
	@Override
	public void setCurrentShow(Show show) {
		currentShow = show;
		
	}

	@Override
	public Show getCurrentShow() {
		return currentShow;
		
	}

	@Override
	public void createNewShow(String showName) {
		Show show = new ShowClass(showName);
		shows.put(showName, show);
		
	}

	@Override
	public void addNewSeasonToShow() {
		currentShow.addSeason();
		
	}
	
	public Episode createNewEpisode(String episodeName) {
		Episode e = new EpisodeClass(episodeName);
		return e;
		
	}

	@Override
	public void addEpisodeToShow(int season, Episode episode) {
		currentShow.addEpisodeToSeason(season, episode);
		
	}

	@Override
	public Show findShow(String showName) {
		return shows.get(showName);
		
	}

	@Override
	public boolean isShowSelected() {
		return currentShow!=null;
	}

	@Override
	public boolean existShow(String showName) {
		return shows.containsKey(showName);
	}

	@Override
	public Characters createNewCharacter(String type, String actorName, String name, int fee) {
		Characters c = null;
		if(type.equals(REAL))
			c = new RealCharacterClass(actorName, name, fee);
		if(type.equals(VIRTUAL))
			c = new VirtualCharacterClass(actorName, name, fee);
		
		return c;
	}

	@Override
	public void addCharacterToShow(Characters character) {
		Show s = getCurrentShow();
		s.addCharacter(character);
		String realName= character.getRealName();
		if(real.get(realName)==null) {
			SortedSet<Show> L = new TreeSet<Show>(new ComparatorByName());
			L.add(s);
			real.put(realName,L);
			
		}else {
			SortedSet<Show> L = real.get(realName);
			L.add(s);
			
		}
		
		if(roles.get(realName)==null) {
			List<Characters> L = new ArrayList<Characters>();
			L.add(character);
			roles.put(realName, L);
			
		}else {
			List<Characters> L = roles.get(realName);
			L.add(character);
			
		}
	}

	@Override
	public boolean isReal(Characters charact) {		
		return charact instanceof RealCharacterClass;
	}

	@Override
	public boolean isTypeKnown(String type) {
		return (type.equals(REAL) || type.equals(VIRTUAL));
	}

	@Override
	public Event createNewEvent(String description, int season, int episode, List<Characters> l) {
		Event E = new EventClass(episode, season, description, l);
		return E;
	}

	@Override
	public boolean searchForDuplicates(List<Characters> L) {
		boolean found = false;
		int size = L.size();
		if(size>1) {
		for(int i = 0; i<size; i++)
			for(int j = i+1; j<size; j++) {
				if(L.get(i).getActorName().equals(L.get(j).getActorName()))
					found = true;
			}
		}
		return found;
	}

	@Override
	public Iterator<Show> getRoles(String realName) {
		return real.get(realName).iterator();
		
	}

	@Override
	public boolean existCharacter(Characters character) {
		return real.containsKey(character.getRealName());
	}

	@Override
	public int getNumberOfRoles(String realName) {
		List<Characters> L = roles.get(realName);
		return L.size();
	}

	public int getNumberOfRomaces(String realName) {
		int num = 0;
		List<Characters> L = roles.get(realName);
		Iterator<Characters> it = L.iterator();
		while(it.hasNext()) {
			Characters C = it.next();
			num+=C.getFamilyNumber(ROMANCE);
		}
		return num;
	}
}
