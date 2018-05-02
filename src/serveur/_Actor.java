package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Actor extends Remote{
	boolean checkUser(String login, String mdp) throws RemoteException;
	void connectUser() throws RemoteException;
}
