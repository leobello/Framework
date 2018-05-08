
package bd;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Test {

	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
	Users basededonnes = new Users();
	
	System.out.println(basededonnes.getnbInscrit());
	
	
	basededonnes.afficher_Utilisateurs();
	
	System.out.println(basededonnes.UserNameAlreadyExist("amalm"));
		
	}
}

