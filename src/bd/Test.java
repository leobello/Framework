
package bd;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Test {

	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		LocateRegistry.createRegistry(10977);
        Users dg=new Users();
        dg.afficher_Utilisateurs();
        String url="rmi://localhost/Gnaouas";
        System.out.println("enregistrer dans : "+url);
        Naming.rebind(url,dg);
		System.out.println("Bind Fait");
	}
}

