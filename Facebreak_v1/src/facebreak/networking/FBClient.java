package facebreak.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import facebreak.common.Profile;
import facebreak.common.User;
import facebreak.networking.Request.RequestType;

public class FBClient {
	private Socket socket;
	private InetAddress serverAddr;
	private User user;
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	
	private static final int port = 4444;
	
	public FBClient() throws UnknownHostException {
		serverAddr = InetAddress.getLocalHost();
		user = null;
		socket = null;
		outStream = null;
		inStream = null;
	}

	public FBClient(InetAddress serverAddr) {
		this.serverAddr = serverAddr;
		user = null;
		socket = null;
		outStream = null;
		inStream = null;
	}
	
	public FBClient(String username, String pwd) throws UnknownHostException {
		serverAddr = InetAddress.getLocalHost();
		user = new User(username, pwd);
		socket = null;
		outStream = null;
		inStream = null;
	}
	
	public void setCurrentUser(User user) {
		this.user = user;
	}

	public void setCurrentUser(String username, String pwd) {
		user = new User(username, pwd);
	}
	
	public User getCurrentUser() {
		return user;
	}
	
	public Error login() {
		try {
			// open connection
			socket = new Socket(serverAddr, port);
			
			// create request object
			Request loginRequest = new Request();
			loginRequest.setRequestType(RequestType.LOGIN);
			loginRequest.setTimestamp(System.currentTimeMillis());
			loginRequest.getDetails().setUser(user);
			
			outStream = new ObjectOutputStream(socket.getOutputStream());
			outStream.writeObject(loginRequest);
			
			inStream = new ObjectInputStream(socket.getInputStream());
			Reply serverReply;
			try {
				serverReply = (Reply)inStream.readObject();
				return serverReply.getReturnError();
			} catch (ClassNotFoundException e1) {
				return Error.UNKNOWN_ERROR;
			}
		} catch (IOException e) {
			return Error.CONNECTION;
		}
	}

	public Error logout() {
		if(socket == null)
			return Error.LOGIN;
		
		try {
			Request logoutRequest = new Request(user.getId());
			logoutRequest.setRequestType(RequestType.LOGOUT);
			logoutRequest.setTimestamp(System.currentTimeMillis());
			
			outStream.writeObject(logoutRequest);
			try {
				Reply serverReply = (Reply) inStream.readObject();

				
				outStream.close();
				inStream.close();
				socket.close();
				
				return serverReply.getReturnError();
			} catch (ClassNotFoundException e) {
				return Error.UNKNOWN_ERROR;
			}
		} catch (IOException e) {
			return Error.UNKNOWN_ERROR;
		}
	}
	
	public Error post() {
		if(socket == null)
			return Error.LOGIN;
		
		Request postRequest = new Request(user.getId());
		
		
		return Error.SUCCESS;
	}

	public Error viewPost(int uid) {
		if(socket == null)
			return Error.LOGIN;
		
		return Error.SUCCESS;
	}
	
	public Error viewProfile(String username, Profile profile) {
		if(socket == null)
			return Error.LOGIN;
		
		Request viewProfileRequest = new Request(user.getId());
		
		return Error.SUCCESS;
	}
	
	public Error editProfile(int uid, Profile myProfile) {
		if(socket == null)
			return Error.LOGIN;
		
		return Error.SUCCESS;
	}
	
	public Error delete(int uid) {
		if(socket == null)
			return Error.LOGIN;
		
		return Error.SUCCESS;
	}

	public Error createUser(int uid) {
		if(socket == null)
			return Error.LOGIN;
		
		
		return Error.SUCCESS;
	}
	
	public Error changePassword(int uid) {
		if(socket == null)
			return Error.LOGIN;
		
		return Error.SUCCESS;
	}
	
	public static void main(String args[]) throws IOException {
		
		int p = 4444;
		InetAddress addr = InetAddress.getLocalHost();
		
		Socket sock = new Socket(addr, p);
		
	}
}
