package facebreak.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import facebreak.common.User;
import facebreak.dummyserver.DummyQuery;
import facebreak.networking.Request.RequestType;

public class FBClientHandler extends Thread {
	private Socket client;
	private AuthenticatedUser user;
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	
	public FBClientHandler(Socket client) {
		this.client = client;
		outStream = null;
		inStream = null;
	}

	public Reply parseRequest(Request r) {
		RequestType type = r.getRequestType();
		Reply myReply;
		
		switch (type) {
		case LOGIN:
			myReply = processLogin(r.getDetails().getUser());
			break;
		case LOGOUT:
			myReply = processLogout();
			break;
		case CREATE_USER:
			myReply = processCreateUser(r.getDetails().getUser());
			break;
		case CHANGE_PWD:
			myReply = processChangePwd(r.getDetails().getUser());
			break;
		case VIEW_BOARD:
			myReply = processViewPost();
			break;
		case VIEW_PROFILE:
			myReply = processViewPost();
			break;
		case POST:
			myReply = processCreatePost();
			break;
		case DELETE_POST:
			myReply = processDeletePost();
			break;
		default:
			myReply = new Reply();
			myReply.setReturnError(Error.MALFORMED_REQUEST);
			break;
		}
		myReply.setTimestamp(System.currentTimeMillis());
		return myReply;
	}

	public Reply processLogin(User client) {
		Reply r = new Reply();
		int uid = DummyQuery.loginUser(client);
		
		if(client == null) {
			r.setReturnError(Error.MALFORMED_REQUEST);
			return r;
		}
		
		// if not valid username/passwd combo, return only error
		if(uid == -1) {
			r.setReturnError(Error.USERNAME_PWD);
			return r;
		}
		
		if(client == null) {
			r.setReturnError(Error.MALFORMED_REQUEST);
			return r;
		}
		
		// otherwise authenticate user and reply with success
		user.setId(uid);
		user.logIn();
		
		client.setId(uid);
		r.getContents().setUser(client);
		r.setReturnError(Error.SUCCESS);
		return r;
	}

	public Reply processLogout() {
		Reply r = new Reply();

		if(user == null || !user.isLoggedIn()) {
			r.setReturnError(Error.LOGIN);
			return r;
		}
		
		user.logOut();
		r.setReturnError(Error.SUCCESS);
		return r;
	}

	public Reply processCreateUser(User client) {
		Reply r = new Reply();
		
		if(user == null || !user.isLoggedIn()) {
			r.setReturnError(Error.LOGIN);
			return r;
		}

		if(client == null) {
			r.setReturnError(Error.MALFORMED_REQUEST);
			return r;
		}
		
		int uid = DummyQuery.createUser(client);
		// if username already exists
		if(uid == -1) {
			r.setReturnError(Error.DUPLICATE_USER);
			return r;
		}
		// assumes when new user is created successfully, 
		// user is logged in automatically
		user.setId(uid);
		user.logIn();

		client.setId(uid);
		r.getContents().setUser(client);
		r.setReturnError(Error.SUCCESS);
		
		return r;
	}

	public Reply processChangePwd(User client) {
		Reply r = new Reply();
		
		if(user == null || !user.isLoggedIn()) {
			r.setReturnError(Error.LOGIN);
			return r;
		}

		if(client == null) {
			r.setReturnError(Error.MALFORMED_REQUEST);
			return r;
		}
		
		DummyQuery.changePassword(client);
		r.setReturnError(Error.SUCCESS);

		return r;
	}

	public Reply processDeletePost() {
		Reply r = new Reply();
		
		if(user == null || !user.isLoggedIn()) {
			r.setReturnError(Error.LOGIN);
			return r;
		}
		
		return r;
		
	}

	public Reply processCreatePost() {
		Reply r = new Reply();
		
		if(user == null || !user.isLoggedIn()) {
			r.setReturnError(Error.LOGIN);
			return r;
		}

		return r;
	}

	public Reply processViewPost() {
		Reply r = new Reply();
		
		if(user == null || !user.isLoggedIn()) {
			r.setReturnError(Error.LOGIN);
			return r;
		}

		
		return r;
	}

	public void run() {
		if(client == null)
			return;
		
		System.out.println("Accepted client on machine "
				+ client.getInetAddress().getHostName());

		try {
			inStream = new ObjectInputStream(client.getInputStream());
			outStream = new ObjectOutputStream(client.getOutputStream());
			
			while(true) {
				// examine client's request
				Request clientRequest = (Request) inStream.readObject();
				Reply myReply = parseRequest(clientRequest);
				
				// send reply back to client
				outStream.writeObject(myReply);
				
				// exit loop on logout
				if(clientRequest.getRequestType() == RequestType.LOGOUT)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Closing connection.");
				user = null;
				inStream.close();
				outStream.close();
				client.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
