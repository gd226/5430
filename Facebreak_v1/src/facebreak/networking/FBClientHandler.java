package facebreak.networking;

public class FBClientHandler extends Thread {
	
	public FBClientHandler() {
		
	}

	public static Message parseMessage(Message msg) {
		MessageType type = msg.getMessageType();
		
		Message reply = new Message(msg.getUser());
		reply.setMessageType(MessageType.REPLY_FROM_SERVER);
		
		switch(type) {
		case REQUEST_LOGIN:
			processLogin(reply);
			break;
		case REQUEST_LOGOUT:
			processLogout(reply);
			break;
		case REQUEST_CREATE_USER:
			processCreateUser(reply);
		case REQUEST_CHANGE_PWD:
			processChangePassword(reply);
			break;
		case REQUEST_VIEW:
			processViewPost(reply);
			break;
		case REQUEST_POST:
			processCreatePost(reply);
			break;
		case REQUEST_DELETE:
			processDeletePost(reply);
			break;
		default:
			reply.setMessageType(MessageType.REPLY_ERROR);
			reply.setErrorMessage(Error.UNKNOWN_REQUEST);
		}
		return reply;
	}
	
	public static void sendReply(Message reply) {
		
	}
	
	public static void processLogin(Message reply) {
		
	}

	public static void processLogout(Message reply) {
		
	}

	public static void processCreateUser(Message reply) {
		
	}
	
	public static void processChangePassword(Message reply) {
		
	}

	public static void processDeletePost(Message reply) {
		
	}
	
	public static void processCreatePost(Message reply) {
		
	}
	
	public static void processViewPost(Message reply) {
		
	}
	
	
	public void run() {
		
	}

}
