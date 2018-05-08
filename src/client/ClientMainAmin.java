package client;

import java.rmi.Naming;
import java.util.Scanner;

import bd._Users;
public class ClientMainAmin {
	
	public static void main(String[] args) {
		try{
			Client c=new Client("Zak");
			
			// obtenir une référence sur l'objet distant à partir de son nom
			System.out.println("entrez le nom du serveur (hostname) : ");
			String hostname = new Scanner(System.in).nextLine();
			String url = "rmi://"+hostname+"/Gnaouas";
		    // on vérifie que l'objet retourné est bien une instance de cette interface.
			//_Serveur server=(_Serveur)Naming.lookup(url);
			_Users server=(_Users)Naming.lookup(url);
			//System.out.println("Client : "+ c.getName() + " est connecté ");
			//le client se connecte et serveur et il va recevoir le fichier 
			//server.login(c);			
			server.connectUser();
			System.out.println(server.getnbInscrit());
			System.out.println("Fin du client");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
