package facebreak.common;

public enum Title {
	BOSS(0, "Boss"), 
	CAPO(1, "Caporegime"), 
	SOLDIER(2, "Soldier"), 
	ASSOC(3, "Associate");

	public final int rank;
	private final String title;

	private Title(int rank, String title) {
		this.rank = rank;
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}
}
