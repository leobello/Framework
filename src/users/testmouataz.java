package users;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bd.Publications;
import bd.Users;

public class testmouataz {

	
		
		public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
			
			
			Users BD = new Users();
			// test recherche d'utilisateur
			User pers = new User("mouataz", 22);
			
			String url = "rmi://localhost/Gnaouas";
			
			@SuppressWarnings("unused")
			Publications  OpenSpace = (Publications)Naming.lookup(url);
			
			if (pers.searchUser("amalm") != null) {
				System.out.println("trouv�");
			} else System.out.println("pas trouv�");
			
			
			// test bannir une personne
			
			Admin dieu = new Admin("mouayaz", "123456789");
			
			dieu.Bannir("amalm");
			
			BD.afficher_Utilisateurs();
			
		}
		

}
