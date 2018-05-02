package client;


import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements _Client {

	
	private static final long serialVersionUID = 1L;
	// le nom du client 
	public String name;
	public  Client(String n) throws RemoteException {
		super();
		name=n;
	}
	
	/**
	 * retourner le nom du client 
	 * @return name : nom du client
	 */
	public String getName() throws RemoteException{
		return name;
	}
    /**
     * Création du fichier qui va être reçu dans le coté client
     * @param filname : nom du fichier 
     * @param data : les données à recevoir
     * @param len : taille des données
     * @return boolean : retourner vrai si l'opperation a fonctionnée  
     */
	public boolean sendData(String filename, byte[] data, int len) throws RemoteException{
        try{
        	// Création du nouveau fichier 
        	File f=new File("Client_"+filename);
        	f.createNewFile();
        	FileOutputStream out=new FileOutputStream(f,true);
        	// copier le ficher depuis le serveur vers le client
        	out.write(data,0,len);
        	out.flush();
        	// Fermer le fichier
        	out.close();
        	System.out.println("ecriture de données");
        }catch(Exception e){
        	e.printStackTrace();
        }
		return true;
	}

}
