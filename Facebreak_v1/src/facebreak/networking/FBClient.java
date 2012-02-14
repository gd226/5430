package facebreak.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FBClient {

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
			return Error.MISC_ERROR;
		}
		
		return Error.SUCCESS;
	}
	
	public Error post() {
		
		return Error.SUCCESS;
	}

	public Error view() {
		
		return Error.SUCCESS;
	}
	
	public Error delete() {
		
		return Error.SUCCESS;
	}

	public Error createUser() {
		
		
		return Error.SUCCESS;
	}
	
	public static void main(String args[]) throws IOException {
		
		int port = 4444;
		InetAddress addr = InetAddress.getLocalHost();
		
		Socket sock = new Socket(addr, port);
		
		
	}
}
