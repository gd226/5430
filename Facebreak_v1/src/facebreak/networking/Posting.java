package facebreak.networking;

import java.io.Serializable;

public class Posting implements Serializable {
	private int owner;	// id for user (owner of post)
	private RegionAccess region;
	private String text;

	public enum RegionAccess {
		PUBLIC, PRIVATE, COVERT1, COVERT2, COVERT3;
	}
	
	public Posting(int owner, RegionAccess region, String text) {
		this.owner = owner;
		this.region = region;
		this.text = text;
	}
	
	public void setRegion(RegionAccess region) {
		this.region = region;
	}
	
	public RegionAccess getRegion(RegionAccess region) {
		return region;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText(String text) {
		return text;
	}
}
