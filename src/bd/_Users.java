package bd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import contenu.Contenu;
import users.Admin;
import users.Utilisateurs;
import users._Utilisateurs;

public interface _Users extends Remote{
	
	public void suprimerBD(_Utilisateurs user) throws RemoteException;
	
	public boolean UserNameAlreadyExist(String userName) throws RemoteException;
	
	public boolean inscrire(String login,String mdp,int typeUtilisateur,int age) throws RemoteException,FileNotFoundException, IOException;
	
	public ArrayList<_Utilisateurs> getBD() throws RemoteException;
	
	public int getnbInscrit() throws RemoteException;
	
	public void enregistrerBD() throws FileNotFoundException, IOException , RemoteException;

	public ArrayList<_Utilisateurs> lireBDFile() throws RemoteException;
	
	public Utilisateurs getUser(String pseudo) throws RemoteException;
	
	public boolean checkUser(String login, String mdp) throws RemoteException ;
	
	public void bannir(Admin admin, String login)throws FileNotFoundException, IOException ;
	
	public void afficher_Utilisateurs() throws RemoteException;
	
	//public void connectUser() throws RemoteException;
	public void updateUser(_Utilisateurs usr) throws RemoteException;
	
	public ArrayList<Contenu> getPublication() throws RemoteException;
	
	public String getFIleNameOFArchivePublication() throws RemoteException ;
	
	public void ArchiverPublication() throws RemoteException ;
	
	public ArrayList<Contenu> lireArchiveFile() throws RemoteException;
	
	public void afficher_Publications() throws RemoteException;

	public void publier(Contenu T) throws RemoteException;
}
