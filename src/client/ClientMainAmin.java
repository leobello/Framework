package client;

import java.rmi.Naming;

import bd._Users;
import serveur.Serveur;
import users.User;
import users.Utilisateurs;
import users._Utilisateurs;

public class ClientMainAmin {

	public static void main(String[] args) {
		try {
			Client c = new Client("Zak");
			String url = "rmi://"+Serveur.listen+"/Gnaouas";
			_Users server = (_Users) Naming.lookup(url);
			//c.connectUser("amalm", "123");
			//c.inscription("amalm", "159", "159", 1, 22);
			Utilisateurs usr2= new User("leo",21);
			usr2=c.connectUser("new","159");
			//c.connectUser("amalm","159");
			Utilisateurs usr=new User("kkl,l,",12);
			usr=c.connectUser("leo","159");
			server.getUser("amalm");
			Utilisateurs usr1=c.connectUser("amalm","159");
			//usr.printFriend();
		//	usr.beFriend((_Utilisateurs)usr1);
		//	usr.beFriend((_Utilisateurs)usr2);
			//usr.printFriend();
			//System.out.println(usr.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
