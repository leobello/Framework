package client;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Client extends Remote {
	
	 /**
     * Création du fichier qui va être reçu dans le coté client
     * @param filname : nom du fichier 
     * @param data : les données à recevoir
     * @param len : taille des données
     * @return boolean : retourner vrai si l'opperation a fonctionnée  
     */
	public boolean sendData(String filename, byte[] data, int len) throws RemoteException;
	
	/**
	 * retourner le nom du client 
	 * @return name : nom du client
	 */
	public String getName() throws RemoteException;
	
	
}
