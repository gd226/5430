package facebreak.gui;

public class Posting {
	private int pid;	// id for particular post
	private int uid;	// id for user (owner of post)
	private int rid; 	// region id
	private String contents;
	private boolean permissions;
	
	public Posting() {
		
	}
	
	public Posting(String contents) {
		this.contents = contents;
	}
}
