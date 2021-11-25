import java.util.*;

import Characters.*;
import Events.*;
import Exceptions.*;
import ShowPedia.*;
import Shows.*;

public class Main {
	private enum Command{
		help("shows the available commands"), 
		exit("terminates the execution of the program"), 
		desconhecido(""),
		currentshow("show the current show"),
		addshow("add a new show"), 
		switchtoshow("change the context to a particular show"),
		addseason("add a new season to the current show"), 
		addepisode("add a new episode to a particular season of the current show"),
		addcharacter("add a new character to a show"),
		addrelationship("add a family relationship between characters"),
		addromance("add a romantic relationship between characters"), 
		addevent("add a significant event involving at least one character"),
		addquote("add a new quote to a character"), 
		seasonoutline("outline the contents of the selected seasons for the selected show"), 
		characterresume("outline the main information on a specific character"), 
		howarethesetworelated("find out if and how two characters may be related"),
		famousquotes("find out which character(s) said a particular quote"), 
		alsoappearson("which other shows and roles is the same actor on?"), 
		mostromantic("find out who is at least as romantic as X"), 
		kingofcgi("find out which company has earned more revenue with their CGI virtual actors");


		private String description;

		Command (String description) { this.description = description; }
		public String toString() { return this.description; }  
	};

	private static final String SPACE = " ";
	private static final String BYE = "Bye";
	private static final String EXCLAMATION = "!";
	private static final String DOT = ".";
	private static final String CREATED = "created";
	private static final String S = "S";
	private static final String COMA = ",";
	private static final String EP = "Ep";
	private static final String TWO_DOTS = ":";
	private static final String IS_PART_OF = "is now part of";
	private static final String THIS_IS = "This is";
	private static final String A =  "a";
	private static final String VIRTUAL = "virtual actor";
	private static final String EVENT_ADDED = "Event added";
	private static final String PARENTS = "Parents";
	private static final String KIDS = "Kids";
	private static final String KID = "kids";
	private static final String SIBLINGS = "Siblings";
	private static final String ROMANCE = "Romantic relationships";
	private static final String ROLE = "role";
	private static final String HAS_NOW = "has now";
	private static final String PARENT = "parent(s)";
	private static final String AND = "and";
	private static final String NOW_COUPLE = "are now a couple";
	private static final String NONE = "None";
	

	public static void main(String[] args) throws NoShowSelectedException, SeasonDoNotExistsException, ShowAlreadyExistsException,
	ShowDoNotExistsException, DuplicateCharactersException, NoShowSelectedException {

		ShowPedia sp = new ShowPediaClass();
		Scanner in = new Scanner(System.in);
		Command comm = getCommand(in);

		while (!comm.equals(Command.exit)){
			switch (comm) {
			case help: help(in, sp); break;
			case currentshow: currentShow(sp); break;
			case addshow: addShow(in, sp); break;
			case switchtoshow: switchShow(in, sp); break;
			case addseason: addSeason(in, sp); break;
			case addepisode: addEpisode(in, sp); break;
			case addcharacter: addCharacter(in, sp);break;
			case addrelationship: addRelashionship(in, sp); break;
			case addromance: addRomance(in, sp); break;
			case addevent: addEvent(in, sp); break;
			case addquote: break;
			case seasonoutline: seasonOutline(in, sp); break;
			case characterresume: characterResume(in, sp); break;
			case howarethesetworelated: howAreTheseTwoRelated(in, sp); break;
			case famousquotes: break;
			case alsoappearson: alsoAppears(in, sp); break;
			case mostromantic: break;
			case kingofcgi: break;
			case desconhecido: break;
			default: break;

			}
			comm = getCommand(in);
		}
		System.out.println(BYE+EXCLAMATION);
	}
	
	private static void howAreTheseTwoRelated(Scanner in, ShowPedia sp) {
		try {
			String s1 = in.nextLine();
			String s2 = in.nextLine();

			if(!sp.isShowSelected())
				throw new NoShowSelectedException();

			Show show = sp.getCurrentShow();

			if(!show.checkCharacters(s1))
				throw new WhoIsException(s1);

			if(!show.checkCharacters(s2))
				throw new WhoIsException(s2);

			if(s1.equals(s2))
				throw new SamePersonException(s1);

		}catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());

		} catch (WhoIsException e) {
			System.out.println(e.getMessage());

		} catch (SamePersonException e) {
			System.out.println(e.getMessage());

		}
	}

	private static void help(Scanner in, ShowPedia sp) {
		StringBuilder str = new StringBuilder();
		str.append("currentShow - " + Command.currentshow.toString()+ "\n");
		str.append("addShow - " + Command.addshow.toString()+ "\n");
		str.append("switchToShow - " + Command.switchtoshow.toString()+ "\n");
		str.append("addSeason - " + Command.addseason.toString()+ "\n");
		str.append("addEpisode - " + Command.addepisode.toString()+ "\n");
		str.append("addCharacter - " + Command.addcharacter.toString()+ "\n");
		str.append("addRelationship - " + Command.addrelationship.toString()+ "\n");
		str.append("addRomance - " + Command.addromance.toString()+ "\n");
		str.append("addEvent - " + Command.addevent.toString()+ "\n");
		str.append("addQuote - " + Command.addquote.toString()+ "\n");
		str.append("seasonsOutline - " + Command.seasonoutline.toString()+ "\n");
		str.append("characterResume - " + Command.characterresume.toString()+ "\n");
		str.append("howAreTheseTwoRelated - " + Command.howarethesetworelated.toString()+ "\n");
		str.append("famousQuotes - " + Command.famousquotes.toString()+ "\n");
		str.append("alsoAppearsOn - " + Command.alsoappearson.toString()+ "\n");
		str.append("mostRomantic - " + Command.mostromantic.toString()+ "\n");
		str.append("kingOfCGI - " + Command.kingofcgi.toString()+ "\n");
		str.append("help - " + Command.help.toString()+ "\n");
		str.append("exit - " + Command.exit.toString());
		System.out.println(str);

	}
	
	private static void characterResume(Scanner in, ShowPedia sp) {
		String actorName = in.nextLine();
		Show show = sp.getCurrentShow();
		Characters C = show.findCharacter(actorName);
		updateFamily(C,show);
		auxResume(C, PARENTS);
		auxResume(C, KIDS);
		auxResume(C, SIBLINGS);
		auxResume(C, ROMANCE);

	}

	private static void addRomance(Scanner in, ShowPedia sp) {
		try {
			String s1 = in.nextLine();
			String s2 = in.nextLine();

			if(!sp.isShowSelected())
				throw new NoShowSelectedException();

			Show show = sp.getCurrentShow();
			
			if(s1.equals(s2))
				throw new AlreadyRomanceException(s1);

			if(!show.checkCharacters(s1))
				throw new WhoIsException(s1);

			if(!show.checkCharacters(s2))
				throw new WhoIsException(s2);
			
			Characters P = show.findCharacter(s1);
			Characters K = show.findCharacter(s2);
			
			if(P.alreadyFamily(ROMANCE, s2))
				throw new AlreadyFamilyException();

			P.addFamily(ROMANCE, s2);
			K.addFamily(ROMANCE, s1);
			System.out.println(s1+SPACE+AND+SPACE+s2+SPACE+NOW_COUPLE+DOT);

		}catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());

		} catch (AlreadyRomanceException e) {
			System.out.println(e.getMessage());
			
		} catch (WhoIsException e) {
			System.out.println(e.getMessage());
			
		} catch (AlreadyFamilyException e) {
			System.out.println(e.getMessage());
			
		}
	}

	private static void addRelashionship(Scanner in, ShowPedia sp) {
		try {
			String parent = in.nextLine();
			String kid = in.nextLine();

			if(!sp.isShowSelected())
				throw new NoShowSelectedException();

			Show show = sp.getCurrentShow();

			if(parent.equals(kid))
				throw new SamePersonException(parent);

			if(!show.checkCharacters(parent))
				throw new WhoIsException(parent);

			if(!show.checkCharacters(kid))
				throw new WhoIsException(kid);

			Characters P = show.findCharacter(parent);
			Characters K = show.findCharacter(kid);

			if(P.alreadyFamily(KIDS, kid))
				throw new AlreadyFamilyException();

			P.addFamily(KIDS, kid);
			K.addFamily(PARENTS, parent);
		
			int Nparents = K.getFamilyNumber(PARENTS);
			int Nkids = P.getFamilyNumber(KIDS);
			System.out.println(parent+SPACE+HAS_NOW+SPACE+Nkids+SPACE+KID+DOT+SPACE+kid+SPACE+HAS_NOW+SPACE+Nparents+SPACE+PARENT+DOT);

		} catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());

		} catch (SamePersonException e) {
			System.out.println(e.getMessage());

		} catch (WhoIsException e) {
			System.out.println(e.getMessage());

		} catch (AlreadyFamilyException e) {
			System.out.println(e.getMessage());

		} 
	}
	
	private static void alsoAppears(Scanner in, ShowPedia sp) {
		try {
			String actor = in.nextLine();
			Show show = sp.getCurrentShow();
			
			if(!sp.isShowSelected())
				throw new NoShowSelectedException();
			
			if(!show.checkCharacters(actor))
				throw new WhoIsException(actor);
			
			Characters C = show.findCharacter(actor);
			
			if(!sp.isReal(C))
				throw new PlayedByVirtualException(actor);

			String realName = C.getRealName();
			Iterator<Show> it = sp.getRoles(realName);
			while(it.hasNext()) {
				Show s = it.next();
				String showName = s.getName();
				System.out.println(showName);

			}
		}catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());

		} catch (WhoIsException e) {
			System.out.println(e.getMessage());
			
		} catch (PlayedByVirtualException e) {
			System.out.println(e.getMessage());
			
		}
	}

	private static void seasonOutline(Scanner in, ShowPedia sp) {
		try {
			int start = in.nextInt();
			int end = in.nextInt(); in.nextLine();
			
			if(!sp.isShowSelected())
				throw new NoShowSelectedException();
			
			if(sp.getCurrentShow().getNseasons()<end)
				throw new InvalidIntervalException();
			
			System.out.println(sp.getCurrentShow().getName());
			for(int season = start; season<=end; season++) {
				for(int i = 1; i<=sp.getCurrentShow().numberOfEpisode(season); i++) {
					String episodeName = sp.getCurrentShow().getEpisodeName(season, i);
					System.out.println(S+season+SPACE+EP+TWO_DOTS+i+SPACE+episodeName);
					String key = (season+"") + (i+"");
					if(!sp.getCurrentShow().hasEvent(key)) 
						break;
					Iterator<Event> it = sp.getCurrentShow().listEvents(key);
					while(it.hasNext()) {
						Event e = it.next();
						System.out.println(e.getDescription());
					}
				}
			}
		}catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());
			
		} catch (InvalidIntervalException e) {
			System.out.println(e.getMessage());
			
		}
	}

	private static void addEvent(Scanner in, ShowPedia sp) {
		try {
			String description = in.nextLine();
			int season = in.nextInt();
			int episode = in.nextInt();
			int envolved = in.nextInt(); in.nextLine();

			if(!sp.isShowSelected())
				throw new NoShowSelectedException();
			
			Show show = sp.getCurrentShow();
			if(!show.existSeason(season))	
				throw new SeasonDoNotExistsException(show, season);
			
			if(show.numberOfEpisode(season)<episode)
				throw new EpisodeDoNotExistsException(show, season, episode);
			
			String key = ((season+"") + (episode+""));
			List<Characters> L = new ArrayList<Characters>();
			for(int i=0; i<envolved; i++) {
				String C = in.nextLine();
				if(!show.checkCharacters(C))
					throw new WhoIsException(C);
				
				Characters Ch = show.findCharacter(C);
				L.add(Ch);	
			}
			
			if(sp.searchForDuplicates(L))
				throw new DuplicateCharactersException();
			
			Event e = sp.createNewEvent(description, season, episode, L);
			show.addEvent(e, season, episode);
			show.addEventToCharacter(e, key, L);
			System.out.println(EVENT_ADDED+DOT);

		}catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());

		}catch(SeasonDoNotExistsException e) {
			System.out.println(e.getMessage());

		}catch(EpisodeDoNotExistsException e) {
			System.out.println(e.getMessage());
			
		} catch (WhoIsException e) {
			System.out.println(e.getMessage());
			
		} catch (DuplicateCharactersException e) {
			System.out.println(e.getMessage());
			
		}
	}

	private static void addCharacter(Scanner in, ShowPedia sp) {
		try {
			String type = in.nextLine();
			String actorName= in.nextLine();
			String name = in.nextLine();
			int fee = in.nextInt(); in.nextLine();

			if(!sp.isShowSelected())
				throw new NoShowSelectedException();

			if(!sp.isTypeKnown(type))
				throw new UnknownedTypeException();

			Characters C = sp.createNewCharacter(type, actorName, name, fee);

			if(sp.getCurrentShow().existsCharacter(C))
				throw new DuplicateCharactersException();
			
			if(fee<0)
				throw new SlaveryException();

			sp.addCharacterToShow(C);
			String currentShow = sp.getCurrentShow().getName();
			int role = sp.getNumberOfRoles(name);

			if(sp.isReal(C))
				System.out.println(actorName+SPACE+IS_PART_OF+SPACE+currentShow+DOT+SPACE+THIS_IS+
						SPACE+name+SPACE+ROLE+SPACE+role+DOT);
			else
				System.out.println(actorName+SPACE+IS_PART_OF+SPACE+currentShow+DOT+SPACE+THIS_IS+SPACE+A+SPACE+VIRTUAL+DOT);	

		}catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());

		}catch(UnknownedTypeException e) {
			System.out.println(e.getMessage());

		}catch(DuplicateCharactersException e) {
			System.out.println(e.getMessage());

		} catch (SlaveryException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void currentShow(ShowPedia sp) throws NoShowSelectedException{
		try {
			if(!sp.isShowSelected())
				throw new NoShowSelectedException();

			String current = sp.getCurrentShow().toString();
			System.out.println(current);
		}
		catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void switchShow(Scanner in, ShowPedia sp) throws ShowDoNotExistsException{
		try {
			String showName = in.nextLine();
			if(!sp.existShow(showName))
				throw new ShowDoNotExistsException();

			sp.setCurrentShow(sp.findShow(showName));
			String current = sp.getCurrentShow().toString();
			System.out.println(current);
		}catch(ShowDoNotExistsException e) {
			System.out.println(e.getMessage());

		}
	}

	private static void addShow(Scanner in, ShowPedia sp) throws ShowAlreadyExistsException{
		try {
			String showName = in.nextLine();
			if(sp.existShow(showName))
				throw new ShowAlreadyExistsException();
			sp.createNewShow(showName);
			sp.setCurrentShow(sp.findShow(showName));
			sp.addNewSeasonToShow();
			System.out.println(showName+SPACE+CREATED+DOT);
		}
		catch(ShowAlreadyExistsException e) {
			System.out.println(e.getMessage());

		}
	}

	private static void addSeason(Scanner in, ShowPedia sp) throws NoShowSelectedException{
		try {
			if(!sp.isShowSelected())
				throw new NoShowSelectedException();
			sp.addNewSeasonToShow();
			String current = sp.getCurrentShow().toString();
			System.out.println(current);
		}
		catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addEpisode(Scanner in, ShowPedia sp) throws SeasonDoNotExistsException, NoShowSelectedException{
		try {
			int season = in.nextInt();
			String episodeName = in.nextLine().trim();	
			if(!sp.isShowSelected())
				throw new NoShowSelectedException();
			if(!sp.getCurrentShow().existSeason(season))	
				throw new SeasonDoNotExistsException();

			sp.addEpisodeToShow(season, sp.createNewEpisode(episodeName));
			String current = sp.getCurrentShow().getName();
			int number = sp.getCurrentShow().numberOfEpisode(season);
			System.out.println(current+SPACE+S+season+COMA+SPACE+EP+number+TWO_DOTS+SPACE+episodeName+DOT);
		}
		catch(NoShowSelectedException e) {
			System.out.println(e.getMessage());

		}
		catch(SeasonDoNotExistsException e) {
			System.out.println(e.getMessage());

		}
	}
	
	private static void auxResume(Characters C, String type) {
		System.out.print(type+TWO_DOTS+SPACE);
		if(C.getFamilyNumber(type)!=0) {
			Iterator<String> it = C.getFamily(type);
			while(it.hasNext()){
				String next = it.next();
				if(it.hasNext())
					System.out.print(next+COMA+SPACE);
				else
					System.out.println(next);	
			}
		}else
			System.out.println(NONE+DOT);

	}
	
	private static void updateFamily(Characters C, Show show) {
		Iterator<String> it = C.getFamily(PARENTS);
		while(it.hasNext()) {
			String s = it.next();
			Characters ch = show.findCharacter(s);
			Iterator<String> it2 = ch.getFamily(KIDS);
			while(it2.hasNext()) {
				String s2 = it2.next();
				if(!C.getActorName().equals(s2))
					C.addFamily(SIBLINGS, s2);				
			}

		}
	}

	private static Command getCommand(Scanner in) {
		String comm = in.nextLine().toLowerCase();
		System.out.print("> ");
		if (!belongsToCommand(comm)) {
			return Command.desconhecido;
		} else {
			return Command.valueOf(comm);
		}
	}

	private static boolean belongsToCommand(String comm) {
		for (Command c : Command.values()) {
			if (c.name().equals(comm)) {
				return true;
			}
		}
		return false;
	}
	
	
}
