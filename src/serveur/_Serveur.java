package serveur;



import java.rmi.Remote;
import java.rmi.RemoteException;

import client._Client;

/*
 * L'interface qui contient les méthodes dont les serveurs doit fournir aux clients
 */
public interface _Serveur extends Remote {
	
	/**
	 * Pour que le client se connecte au serveur 
	 * @param c : le client qui va se connecter au serveur
	 */
	public boolean login(_Client c) throws RemoteException;
	
}
