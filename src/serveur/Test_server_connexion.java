package serveur;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
public class Test_server_connexion {
	public static void main(String[] args) throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException {
		try {
			LocateRegistry.createRegistry(1145);
		   /* if (System.getSecurityManager() == null) { 
		      System.setSecurityManager(new RMISecurityManager());
		    }*/
		    Actor serv=new Actor();
		    String url = "rmi://localhost/Gnaouas";
		    System.out.println("Enregistrement de l'objet avec l'url : " + url);
		    Naming.rebind(url, serv);
		    System.out.println("Bind réaliser ");
		  } catch (Exception e) {
		     e.printStackTrace();  
		  } 
		/*Inscription isc=new Inscription();
		isc.ajouter();
		UtilisateurServ usr=new UtilisateurServ();
		usr.connectUser();*/
	}
}
