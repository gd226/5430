package facebreak.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class FBServer {
	private int portnum;
	private ServerSocket listener;
	private HashMap<Integer, AuthenticatedUser> connectedUsers;
	
	public FBServer() {
		portnum = 4444;
		listener = null;
		connectedUsers = new HashMap<Integer, AuthenticatedUser>();
	}
	
	private void authenticateUser(MyUser user) {
		// if user's credentialsl check out
		AuthenticatedUser au = new AuthenticatedUser();
		au.authenticate(user);
	}

	public static void main(String args[]) {
		int port = 4444;
		ServerSocket server = null;
		
		System.out.println("Starting up server");
		
		// create server
		try {
			server = new ServerSocket(port);
			System.out.println("Created server on port " + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println
		    ("Could not listen on port: " + port);
			System.exit(-1);
		}
		Socket client = null;
		try {
			client = server.accept();
			System.out.println("Accepted Client");
		} catch (IOException e) {
			System.out.println("Accept failed: " +  + port);
			System.exit(-1);
		}
	}
}
