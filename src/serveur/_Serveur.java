package serveur;



import java.rmi.Remote;
import java.rmi.RemoteException;

import client._Client;


public interface _Serveur extends Remote {
	
	public boolean login(_Client c) throws RemoteException;
}
