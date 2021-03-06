package client;

import java.io.File;
import java.net.InetAddress;
import java.rmi.Naming;
import java.util.Scanner;

import serveur._Serveur;

/**
 * @author Zakaria
 *
 */
public class ClientMain {
	
	public static void main(String[] args) throws Exception {

		System.out.println("Entrez l'adresse ip du serveur");
		String hostname = new Scanner(System.in).nextLine();
		
		String url = "rmi://"+ hostname +"/Gnaouas";

		_Serveur Gnaouas = (_Serveur) Naming.lookup(url);

		Client c = new Client("Zak");

		File testFile = new File("ressources/night.mp4");

		c.telecharger(Gnaouas, testFile, new File("ressources/download.mp4"));
		System.out.println("Fin téléchargement !");
		
		c.uploader(Gnaouas, new File("ressources/download.mp4"), new File("ressources/upload.mp4"));
		System.out.println("Fin du upload !");
	}
}
