package bd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import users.Utilisateurs;
import users._Utilisateurs;

public interface _Users extends Remote{
	
	public void suprimerBD(_Utilisateurs user) throws RemoteException;
	
	public boolean UserNameAlreadyExist(String userName) throws RemoteException;
	
	public void inscrire(String login,String mdp,int typeUtilisateur,int age) throws RemoteException;
	
	public ArrayList<_Utilisateurs> getBD() throws RemoteException;
	
	public int getnbInscrit() throws RemoteException;
	
	public void enregistrerBD() throws FileNotFoundException, IOException , RemoteException;

	public ArrayList<_Utilisateurs> lireBDFile() throws RemoteException;
	
	public Utilisateurs getUser(String pseudo) throws RemoteException;
	
	public boolean checkUser(String login, String mdp) throws RemoteException ;
	
	public void bannir(_Utilisateurs admin, String login);
	
	//public void connectUser() throws RemoteException;
	
}
