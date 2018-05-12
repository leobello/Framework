package bd;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import contenu.Contenu;

public interface _Publications extends Remote{

	public void definirNewFichier();
	
	public void Archiver() throws RemoteException;
	
	public void publier(Contenu T) throws RemoteException;
	
	public ArrayList<Contenu> getContenuPublique() throws RemoteException;
	
	public void afficher_Publications();
	
}
