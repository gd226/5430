package facebreak.networking;

public interface Client {
	Error login(MyUser user);
	Error logout(MyUser user);
	Error view(MyUser user);
	Error post(MyUser user);
	Error delete(MyUser user);
	Error createUser(MyUser user);
}
