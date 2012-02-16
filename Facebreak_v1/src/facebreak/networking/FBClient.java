package facebreak.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FBClient implements Client {

	private Socket mySocket;
	private int portNum;
	private InetAddress serverAddr;
	private AuthenticatedUser myUser;
	
	public FBClient() throws UnknownHostException {
		portNum = 4444;
		serverAddr = InetAddress.getLocalHost();
		mySocket = null;
	}
	
	public FBClient(InetAddress serverAddr, int portNum) {
		this.portNum = portNum;
		this.serverAddr = serverAddr;
		mySocket = null;
	}
	
	public Error login(MyUser user) {
		try {
			mySocket = new Socket(serverAddr, portNum);
		} catch (IOException e) {
			return Error.CONNECTION;
		}
		
		return Error.SUCCESS;
	}

	public Error logout(MyUser user) {
		try {
			mySocket.close();
		} catch (IOException e) {
			return Error.UNKNOWN_ERROR;
		}
		
		return Error.SUCCESS;
	}
	
	public Error post(MyUser user) {
		
		return Error.SUCCESS;
	}

	public Error viewPost(MyUser user) {
		
		return Error.SUCCESS;
	}
	
	public Error viewProfile(MyUser user) {
		
		return Error.SUCCESS;
	}
	
	public Error delete(MyUser user) {
		
		return Error.SUCCESS;
	}

	public Error createUser(MyUser user) {
		
		
		return Error.SUCCESS;
	}
	
	public Error changePassword(MyUser user) {
		
		return Error.SUCCESS;
	}
	
	public static void main(String args[]) throws IOException {
		
		int port = 4444;
		InetAddress addr = InetAddress.getLocalHost();
		
		Socket sock = new Socket(addr, port);
		
		
	}
}
