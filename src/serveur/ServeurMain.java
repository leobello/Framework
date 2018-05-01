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
	
			// 
			Naming.rebind("rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Gnaouas", fs);
			System.out.println("File Server is Ready");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
