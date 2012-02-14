package facebreak.networking;

public class AuthenticatedUser {

	private int id;
	private boolean isLoggedIn;
	
	protected AuthenticatedUser() {
		isLoggedIn = false;
	}
	
	protected void authenticate(MyUser user) {
		int uid = 0;
		id = uid;
	}
	
	protected void logIn() {
		isLoggedIn = true;
	}
	
	protected void logOut() {
		isLoggedIn = false;
	}
}
