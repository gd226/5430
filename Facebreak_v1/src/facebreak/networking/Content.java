package facebreak.networking;

import java.io.Serializable;

/*
 * Wrapper class
 */
public class Content implements Serializable {
	private MyUser user;
	private UserProfile profile;
	private Posting post;
	private Posting[] board;
	
	public Content() {
		user = null;
		profile = null;
		post = null;
		board = null;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}

	public Posting getPost() {
		return post;
	}

	public void setPost(Posting post) {
		this.post = post;
	}

	public Posting[] getBoard() {
		return board;
	}

	public void setBoard(Posting[] board) {
		this.board = board;
	}
	
}
