package users;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bd._Publications;
import serveur.Serveur;

public class testmouataz {

	
		
		public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{		
			// test recherche d'utilisateur
			User pers = new User("mouataz", 22);
			
			String url = "rmi://"+Serveur.listen+"/Gnaouas";
			
			_Publications  OpenSpace = (_Publications)Naming.lookup(url);
			// j'arrive pas r�usssi � cr�er le contenu parce que je bloque sur le troisi�me argument public, est ce que tu peux g�rer ca stp
			// sinon tout est bon il va falloir juste tester cette fonctionnalit�.

			//Contenu C = new Contenu(new Photo(""), pers, new Public(pers, C));
			
			//pers.publier(c);
			
			OpenSpace.afficher_Publications();
			
			
		}
		

}
