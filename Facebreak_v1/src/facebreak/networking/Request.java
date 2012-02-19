package facebreak.networking;

public class Request {
	private int uid;
	private long timestamp;
	private RequestType type;
	private Content requestDescription;
	
	public Request() {
		requestDescription = null;
	}
	
	public Request(int uid) {
		this.uid = uid;
	}
	
	public int getUserId() {
		return uid;
	}
	
	public void setUserId(int uid) {
		this.uid = uid;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public RequestType getRequestType() {
		return type;
	}
	
	public void setRequestType(RequestType type) {
		this.type = type;
	}
}
