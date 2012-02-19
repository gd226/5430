package facebreak.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class FBClientHandler extends Thread {
	private Socket client;
	private AuthenticatedUser user;
//	private FileOutputStream fos;
//	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public FBClientHandler(Socket client) {
		this.client = client;
		oos = null;
		ois = null;
	}

	public static Reply parseRequest(Request msg) {
		RequestType type = msg.getRequestType();

		Reply reply = new Reply();

		switch (type) {
		case LOGIN:
			processLogin(reply);
			break;
		case LOGOUT:
			processLogout(reply);
			break;
		case CREATE_USER:
			processCreateUser(reply);
		case CHANGE_PWD:
			processChangePassword(reply);
			break;
		case VIEW_BOARD:
			processViewPost(reply);
			break;
		case VIEW_PROFILE:
			processViewPost(reply);
			break;
		case POST:
			processCreatePost(reply);
			break;
		case DELETE_POST:
			processDeletePost(reply);
			break;
		default:

		}
		return reply;
	}

	public static void sendReply(Reply reply) {
		
	}

	public static void processLogin(Reply reply) {
		
	}

	public static void processLogout(Reply reply) {
		
	}

	public static void processCreateUser(Reply reply) {
		
	}

	public static void processChangePassword(Reply reply) {
		
	}

	public static void processDeletePost(Reply reply) {
		
	}

	public static void processCreatePost(Reply reply) {
		
	}

	public static void processViewPost(Reply reply) {
		
	}

	public void run() {
		System.out.println("Accepted client on machine "
				+ client.getInetAddress().getHostName());

		try {
			ois = new ObjectInputStream(client.getInputStream());			
			
			while (true) {
				// do stuff here
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
