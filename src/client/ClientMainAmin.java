package client;

import java.rmi.Naming;
import java.util.Scanner;

import bd._Users;

public class ClientMainAmin {

	public static void main(String[] args) {
		try {
			Client c = new Client("Zak");
			String url = "rmi://localhost/Gnaouas";
			_Users server = (_Users) Naming.lookup(url);
			//c.connectUser("amalm", "123");
			//c.inscription("amalm", "159", "159", 1, 22);
			//c.connectUser("new","159");
			//c.connectUser("amalm","159");
			c.connectUser("leo","159");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
