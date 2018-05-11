package serveur;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

import client._Client;

/**
 * l'interface qui etends la class Remote et qui contient les méthodes qui vont être utilisées par le client
 * @author dzpanda
 *
 */public interface _Serveur extends Remote {

	
	/**
	 * @param f fichier dont on va écrire les données 
	 * @return le flux de sortie à exporter (RMI)
	 * @throws IOException
	 */
	public OutputStream getOutputStream(File f) throws IOException ;
    
	/**
	 * @param f fichier dont on va lire les données 
	 * @return le flux d'entrer à exporter (RMI)
	 * @throws IOException
	 */
	public InputStream getInputStream(File f) throws IOException ;
	
	/**
	 * @param login
	 * @param mdp
	 * @return true
	 * @throws RemoteException
	 */
	//public boolean checkUser(String login, String mdp) throws RemoteException;
}
