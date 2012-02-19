package facebreak.networking;

import java.io.Serializable;

public class MyUser implements Serializable {
	private int uid;
	private String name;
	private String password;
	private String hashedPassword;
	
	public MyUser() {
		this.name = new String();
		this.password = new String();
	}
	
	public MyUser(String name, String password) {
		this.name = new String(name);
		this.password = new String(password);
	}
	
	public int getId() {
		return uid;
	}
	public void setId(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
