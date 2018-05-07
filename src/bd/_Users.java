package bd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import users.Utilisateurs;
import users._Utilisateurs;

public interface _Users {

	public void inscrire();
	
	public ArrayList<_Utilisateurs> getBD();
	
	public int getnbInscrit();
	
	public void enregistrerBD() throws FileNotFoundException, IOException;

	public ArrayList<_Utilisateurs> lireBDFile();
	
	public Utilisateurs getUser(String pseudo);
	
	
}
