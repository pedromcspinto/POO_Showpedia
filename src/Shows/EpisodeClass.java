package Shows;

public class EpisodeClass implements Episode {
	private String episodeName;
	
	public EpisodeClass(String episodeName) {
		this.episodeName = episodeName;
		
	}

	@Override
	public String getEpisodeName() {
		return episodeName;
		
	}
}
