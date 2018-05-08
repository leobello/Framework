package bd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import users.Utilisateurs;
import users._Utilisateurs;

public interface _Users extends Remote {

	public void inscrire() throws RemoteException;
	
	public ArrayList<_Utilisateurs> getBD() throws RemoteException;
	
	public int getnbInscrit() throws RemoteException;
	
	public void enregistrerBD() throws FileNotFoundException, IOException , RemoteException;

	public ArrayList<_Utilisateurs> lireBDFile() throws RemoteException;
	
	public Utilisateurs getUser(String pseudo) throws RemoteException;
	
	public boolean checkUser(String login, String mdp) throws RemoteException ;
	
	public void connectUser() throws RemoteException;
}
