package facebreak.networking;

public class MyClient {

	public void login() {
		
	}

	public void logout() {
		
	}
	
	public void post() {
		
	}

	public void view() {
		
	}
	
	public void delete() {
		
	}

	public void createUser() {
		
	}

	public enum ReturnValue {
		FAILURE(0), SUCCESS(1);

		private final int code;

		private ReturnValue(int code) {
			this.code = code;
		}

		public int getReturnValue() {
			return code;
		}
	}

	public enum Error {
		SUCCESS(0, "Successfully completed request."),
		TIMEOUT(1, "Request has timed out."), 
		DUPLICATE_USER(2, "This user already exists."), 
		NO_USER(3, "This user does not exist."),
		PRIVILEGE(4, "This user does not have the privilege."), 
		CONNECTION(5, "Could not connect to server.");

		private final int code;
		private final String msg;

		private Error(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String getDescription() {
			return msg;
		}

		public int getCode() {
			return code;
		}

		@Override
		public String toString() {
			return code + ": " + msg;
		}
	}

	public static void main(String args[]) {
		System.out.println("Hello World!");
	}
}
