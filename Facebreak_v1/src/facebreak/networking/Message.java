package facebreak.networking;

import java.io.Serializable;
import java.util.Date;

import facebreak.gui.Posting;

public class Message implements Serializable {
	/**
	 * not sure what this is for...
	 */
	private static final long serialVersionUID = 1L;
	
	private MyUser user;
	private MessageType type;
	private Date timestamp;
	private Posting posts[];
	private Error error;
	
	public Message() {
		user = null;
	}
	
	public Message(MyUser user) {
		this.user = user;
	}
	
	public MyUser getUser() {
		return user;
	}
	public void setUser(MyUser user) {
		this.user = user;
	}
	public MessageType getMessageType() {
		return type;
	}
	public void setMessageType(MessageType type) {
		this.type = type;
	}
	public Error getErrorMessage() {
		return error;
	}
	public void setErrorMessage(Error error) {
		this.error = error;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTime(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Posting[] getMyPost() {
		return posts;
	}
	public void setMyPost(Posting[] posts) {
		for(int i = 0; i < posts.length; i++) 
			this.posts[i] = posts[i];
	}
}
