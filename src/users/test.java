package users;

import java.rmi.RemoteException;

public class test {

	public static void main(String[] args) {
		User usr = new User("ahmad", 22);
		
		
		_Utilisateurs b = new User("amine",20);
		usr.beFriend(b);
		try {
			usr.printFriend();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
