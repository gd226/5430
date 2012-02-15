package facebreak.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class FBServer {
	private HashMap<Integer, AuthenticatedUser> connectedUsers;
	
	public synchronized void connectToUser(AuthenticatedUser user) {
		connectedUsers.put(user.getId(), user);
	}
	
	public synchronized void disconnectToUser(AuthenticatedUser user) {
		user.logOut();
		connectedUsers.put(user.getId(), user);
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
