package bd;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Test {

	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		try {
			LocateRegistry.createRegistry(1145);
		   /* if (System.getSecurityManager() == null) { 
		      System.setSecurityManager(new RMISecurityManager());
		    }*/
		    Users serv=new Users();
		    String url = "rmi://localhost/Gnaouas";
		    System.out.println("Enregistrement de l'objet avec l'url : " + url);
		    Naming.rebind(url, serv);
		    System.out.println("Bind réaliser ");
		  } catch (Exception e) {
		     e.printStackTrace();  
		  } 
		
		
	}
}
