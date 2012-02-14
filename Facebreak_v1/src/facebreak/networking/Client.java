package facebreak.networking;

public interface Client {
	Error login(MyUser user);
	Error logout(MyUser user);
	Error view();
	Error post();
	Error delete();
	Error createUser();
}
