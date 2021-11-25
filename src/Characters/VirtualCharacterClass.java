package Characters;

public class VirtualCharacterClass extends CharacterClass implements VirtualCharacter{
	private String companyName;
	private int costPerSeason;

	public VirtualCharacterClass(String actorName, String realName, int fee) {
		super(actorName, realName, fee);
		this.companyName = realName;
		this.costPerSeason = fee;
	}

	@Override
	public String getCompanyName() {
		return companyName;
		
	}

	@Override
	public int getCostPerSeason() {
		return costPerSeason;
		
	}
}
