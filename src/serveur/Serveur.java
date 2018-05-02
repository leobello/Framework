package serveur;


import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client._Client;


public class Serveur extends UnicastRemoteObject implements _Serveur {

	
	private static final long serialVersionUID = 1L;
	// file : le nom du fichier
	private String file="";
	
	protected Serveur() throws RemoteException {
		super();
		
	}

	/**
	 * Affecter le nom du ficher
	 * @param f : nom du fichier 
	 */
	public void setFile(String f){
		file=f;
	}
	
	/**
	 * Pour que le client se connecte au serveur 
	 * @param c : le client qui va se connecter au serveur
	 */
	public boolean login(_Client c) throws RemoteException{
	
		 try{
			 
			 File f1=new File(file);			 
			 
			 FileInputStream in=new FileInputStream(f1);			 				 
			 byte [] data=new byte[1024*1024];					
			 int len=in.read(data);
			// envoyer le fichier au client
			 while(len>0){
				 c.sendData(f1.getName(), data, len);	 
				 len=in.read(data);				 
			 }
			 
		 }catch(Exception e){
			 e.printStackTrace();
			 
		 }
		return true;
		
	}


}
