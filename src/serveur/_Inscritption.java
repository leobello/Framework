package serveur;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface _Inscritption extends Remote{
	ArrayList<Actor> chargerUsers() throws RemoteException;
	void EnregistrerInscrit() throws RemoteException;
	void ajouter() throws RemoteException;
}
