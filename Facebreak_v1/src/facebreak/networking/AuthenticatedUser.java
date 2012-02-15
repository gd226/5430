package facebreak.networking;

public class AuthenticatedUser {
	private int id;
	private boolean isLoggedIn;
	// more stuff here in future
	
	protected AuthenticatedUser() {
		isLoggedIn = false;
	}
	
	protected void logIn() {
		isLoggedIn = true;
	}
	
	protected void logOut() {
		isLoggedIn = false;
	}
	
	protected void authenticate(MyUser user) {
		int uid = 0;
		id = uid;
		// if user exists && password matches, then logIn();
	}
	protected boolean isLoggedIn() {
		return isLoggedIn;
	}
}
