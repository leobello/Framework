package client;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import serveur._Serveur;
import users.Utilisateurs;

public interface _Client extends Remote {
	
	/**
	 * retourner le nom du client 
	 * @return name : nom du client
	 */
	/**
	 * @return le nom du client
	 * @throws RemoteException
	 */
	public String getName() throws RemoteException;
	
	/**
	 * depuis input vers output
	 * @param in le flux d'entrer 
	 * @param out le flux d'entrer
	 * @throws IOException
	 */
	public void copier(InputStream in, OutputStream out)  throws IOException;
	
	/**
	 * depuis le client vers le serveur
	 * @param serveur pour utiliser les fonctionnalité du serveur 
	 * @param src le fichier qui existe dans le client ( à uploader )
	 * @param dest le ficher qui sera uploader dans le serveurs
	 * @throws IOException
	 */
	public void uploader(_Serveur serveur, File src, File dest) throws IOException;
	
	/**
	 * depuis le serveur vers le client
	 * @param serveur serveur pour utiliser les fonctionnalité du serveur (à telecharger )
	 * @param src le fichier qui existe dans le serveur
	 * @param dest le ficher qui sera telecharger dans le client
	 * @throws IOException
	 */
	public void telecharger(_Serveur  serveur, File src, File dest) throws IOException;
	
	public Utilisateurs connectUser(String login,String password) throws MalformedURLException, RemoteException, NotBoundException;
	
	public void inscription(String pseudo, String password, String passwordv, int type, int age)
			throws NotBoundException, FileNotFoundException, IOException,RemoteException;
}
