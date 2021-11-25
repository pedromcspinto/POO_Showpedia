package Characters;

import java.util.*;

import Events.*;

public class CharacterClass implements Characters {
	private String actorName; 
	private String realName; 
	private int fee;
	private Map<String, List<Event>> events;
	private static final String PARENTS = "Parents";
	private static final String KIDS = "Kids";
	private static final String SIBLINGS = "Siblings";
	private static final String ROMANCE = "Romantic relationships";
	private Map<String, Set<String>> family;

	public CharacterClass(String actorName, String realName, int fee) {
		this.actorName = actorName;
		this.realName = realName;
		this.fee = fee;
		events = new HashMap<String, List<Event>>();
		family = new HashMap<String, Set<String>>();
		Set<String> A = new LinkedHashSet<String>();
		Set<String> B = new LinkedHashSet<String>();
		Set<String> C = new LinkedHashSet<String>();
		Set<String> D = new LinkedHashSet<String>();
		family.put(PARENTS , A);
		family.put(KIDS , B);
		family.put(SIBLINGS , C);
		family.put(ROMANCE , D);
		
	}

	public String getActorName() {
		return actorName;
	}

	public String getRealName() {
		return realName;
	}

	public int getFee() {
		return fee;
	}

	@Override
	public void addEvent(String key, Event event) {
		if(events.get(key)==null) {
			List<Event> L = new ArrayList<Event>();
			L.add(event);
			events.put(key, L);
		}else {
			List<Event> L = events.get(key);
			L.add(event);

		}		
	}

	@Override
	public void addFamily(String type, String name) {
		Set<String> L = family.get(type);
		L.add(name);
		
	}

	@Override
	public Iterator<String> getFamily(String type) {
		return family.get(type).iterator();

	}

	@Override
	public int getFamilyNumber(String type) {
		Set<String> L = family.get(type);
		return L.size();
	}

	@Override
	public boolean alreadyFamily(String type, String name) {
		boolean found = false;
		Iterator<String> it = getFamily(type);
		while(it.hasNext()) {
			String next = it.next();
			if(next.equals(name))
				found = true;
		}
		return found;
	}

}
