package serveur;


import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client._Client;


public class Serveur extends UnicastRemoteObject implements _Serveur {

	
	private static final long serialVersionUID = 1L;
	private String file="";
	
	protected Serveur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public void setFile(String f){
		file=f;
	}
	
	public boolean login(_Client c) throws RemoteException{
		/*
		 *
		 * Sending The File...
		 * 
		 */
		 try{
			 File f1=new File(file);			 
			 FileInputStream in=new FileInputStream(f1);			 				 
			 byte [] mydata=new byte[1024*1024];						
			 int mylen=in.read(mydata);
			 while(mylen>0){
				 c.sendData(f1.getName(), mydata, mylen);	 
				 mylen=in.read(mydata);				 
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 
		 }
		return true;
		
	}


}
