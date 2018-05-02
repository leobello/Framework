package serveur;


import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class ServeurMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			// Définir RMI Security Manager
			if (System.getSecurityManager() == null) {
				//System.setSecurityManager(new RMISecurityManager());
			}
			// Définir RMI Registre avec le port 1099
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			
			//Créer le serveur
			Serveur fs =new Serveur();
			
			// Définir le nom du fichier à envoyer
			fs.setFile("night.mp4");
	
			// Enregistrer l'objet créé dans le registre de noms en lui affectant un nom
			String url = "rmi://130.190.76.110/Gnaouas";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url , fs);
			System.out.println("Serveur est prêt");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
;