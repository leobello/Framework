package client;

import java.rmi.Naming;
import java.util.Scanner;

import bd._Users;
public class ClientMainAmin {
	
	public static void main(String[] args) {
		try{
			Client c=new Client("Zak");
			
			// obtenir une référence sur l'objet distant à partir de son nom
			//System.out.println("entrez le nom du serveur (hostname) : ");
			String url = "rmi://localhost/Gnaouas";
		    // on vérifie que l'objet retourné est bien une instance de cette interface.
			//_Serveur server=(_Serveur)Naming.lookup(url);
			_Users server=(_Users)Naming.lookup(url);
			//System.out.println("Client : "+ c.getName() + " est connecté ");
			//le client se connecte et serveur et il va recevoir le fichier 
			//server.login(c);
			/*Object[] inscrit= c.inscription();
			server.inscrire((String)inscrit[0], (String)inscrit[1], (int)inscrit[2] , (int)inscrit[3]);*/
			c.connectUser();
			//System.out.println(server.UserNameAlreadyExist((String)inscrit[0]));
			//server.inscrire(login, mdp, typeUtilisateur, age);
			//System.out.println("Bien Inscrit " + (String)inscrit[0]);
			//System.out.println(server.getnbInscrit());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
