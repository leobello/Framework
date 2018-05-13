package users;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bd.Users;
import contenu.Contenu;
import contenu.Photo;
import serveur.Serveur;
import services.Public;

public class testmouataz {

	
		
		public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{		

			User pers = new User("mouataz", 22);
			
			String url = "rmi://"+Serveur.listen+"/Gnaouas";
			
			Users  OpenSpace = (Users)Naming.lookup(url);
	
			Contenu C = new Contenu(new Photo("MouatazPhotoTest.jpg"), pers, new Public());
			
			
			pers.publier(C);
			
			OpenSpace.afficher_Publications();			

		}
		

}
