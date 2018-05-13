package bd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import users.User;

public class testmouataz2 {

	
		public static void main(String[] args) throws RemoteException{
			Users BD = new Users();
			
			User e = new User("amalm", 22);
			BD.inscrits.add(e);
			System.out.println("ouloulou : "+BD.getUser("amalm").getName());
			System.out.println("ouloulou : "+BD.getIndexOfUser("amalm"));
			
		}

}
