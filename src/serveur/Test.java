package serveur;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Inscription isc=new Inscription();
		isc.ajouter();
		Actor usr=new Actor();
		usr.connectUser();
	}
}
