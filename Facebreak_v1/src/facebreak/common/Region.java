package facebreak.common;

import java.lang.reflect.Array;
import java.util.ArrayList;

import facebreak.common.Post.RegionType;

public class Region {
	private int owner;
	private RegionType regionType;
	private ArrayList<Post> posts;
	private ArrayList<User> permissibleUsers;
	
	public Region(int owner, RegionType regionType) {
		this.owner = owner;
		this.regionType = regionType;
	}
	
	public int getOwner() {
		return owner;
	}
	public RegionType getRegionType() {
		return regionType;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	public ArrayList<User> getPermissibleUsers() {
		return permissibleUsers;
	}
	public void setPermissibleUsers(ArrayList<User> permissibleUsers) {
		this.permissibleUsers = permissibleUsers;
	}
}
