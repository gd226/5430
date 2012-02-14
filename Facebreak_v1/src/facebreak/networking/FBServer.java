package facebreak.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FBServer {
	private int portnum;
	private ServerSocket listener;

	public static void main(String args[]) {
		int port = 4444;
		ServerSocket server = null;
		
		// create server
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println
		    ("Could not listen on port: 4444");
			System.exit(-1);
		}
		Socket client = null;
		try {
			client = server.accept();
		} catch (IOException e) {
			System.out.println("Accept failed: 4444");
			System.exit(-1);
		}
	}
}
