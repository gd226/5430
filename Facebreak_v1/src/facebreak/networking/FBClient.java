package facebreak.networking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FBClient {
	private Socket socket;
	private int port;
	private InetAddress serverAddr;
	private MyUser user;
//	private FileOutputStream fos;
//	private FileInputStream fis;
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	
	public FBClient() throws UnknownHostException {
		port = 4444;
		serverAddr = InetAddress.getLocalHost();
		user = null;
		socket = null;
		outStream = null;
		inStream = null;
	}

	public FBClient(InetAddress serverAddr, int port) {
		this.port = port;
		this.serverAddr = serverAddr;
		user = null;
		socket = null;
		outStream = null;
		inStream = null;
	}
	
	public FBClient(String username, String pwd) throws UnknownHostException {
		port = 4444;
		serverAddr = InetAddress.getLocalHost();
		user = new MyUser(username, pwd);
		socket = null;
		outStream = null;
		inStream = null;
	}
	
	public void setCurrentUser(MyUser user) {
		this.user = user;
	}

	public void setCurrentUser(String username, String pwd) {
		user = new MyUser(username, pwd);
	}
	
	public MyUser getCurrentUser() {
		return user;
	}
	
	public Error login() {
		try {
			// open connection
			socket = new Socket(serverAddr, port);
			
			// create request object
			Request loginRequest = new Request(user);
			loginRequest.setRequestType(RequestType.LOGIN);
			loginRequest.setTimestamp(System.currentTimeMillis());
			
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
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			outStream.close();
			inStream.close();
			socket.close();
		} catch (IOException e) {
			return Error.UNKNOWN_ERROR;
		}
		return Error.SUCCESS;
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
	
	public Error viewProfile(String username, UserProfile profile) {
		if(socket == null)
			return Error.LOGIN;
		
		Request viewProfileRequest = new Request(user.getId());
		
		return Error.SUCCESS;
	}
	
	public Error editProfile(int uid, UserProfile myProfile) {
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
