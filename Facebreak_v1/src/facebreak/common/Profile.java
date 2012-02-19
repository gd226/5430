package facebreak.common;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Profile implements Serializable {
	private String username;
	private String fname;
	private String lname;
	private String family;
	private Title title;
	private BufferedImage photo;
	
	public Profile(String username) {
		this.username = username;
		family = null;
		title = null;
		photo = null;
	}
	
	public Profile(String username, String fname, String lname) {
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		family = null;
		title = null;
		photo = null;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getFamily() {
		return family;
	}
	
	public void setFamily(String family) {
		this.family = family;
	}
	
	public Title getTitle() {
		return title;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	public BufferedImage getPhoto() {
		return photo;
	}
	
	public void setPhoto(BufferedImage photo) {
		this.photo = photo;
	}
}
