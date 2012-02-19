package facebreak.common;

import java.io.Serializable;

public class Post implements Serializable {
	private int owner;			// id for owner of board
	private int pid;
	private RegionType region;
	private String writer;		// username of the writer of this post (not always same as owner)
	private String text;		// content, obviously, of the post

	public enum RegionType {
		PUBLIC, PRIVATE, COVERT;
	}
	
	public Post(int owner, RegionType region, String writer, String text) {
		this.owner = owner;
		this.region = region;
		this.writer = writer;
		this.text = text;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getPid() {
		return pid;
	}

	public RegionType getRegion() {
		return region;
	}

	public void setRegion(RegionType region) {
		this.region = region;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
