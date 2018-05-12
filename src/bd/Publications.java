package bd;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import contenu.*;
import stockage.*;

public class Publications extends UnicastRemoteObject  implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Contenu> contenuPublique;
	private int nbArchiveFiles;
	private  String FileName = "Archive"+nbArchiveFiles;
	private  File ArchiveFile;

	
	
	public Publications() throws RemoteException{
		contenuPublique = new ArrayList<Contenu>();
		nbArchiveFiles = 1;
		definirNewFichier();
	}
	
	public void definirNewFichier() {
		ArchiveFile = new File(FileName);
	}

	public void Archiver() throws RemoteException {
		try {
			new Serialization(ArchiveFile,contenuPublique);
			nbArchiveFiles++;
			definirNewFichier();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void afficher_Publications() {
		for (Contenu x : contenuPublique) {
			System.out.println(x.getContenu());
		}
		
	}
	
	public void publier(Contenu T) throws RemoteException {
		contenuPublique.add(T);
		if (contenuPublique.size() >=100) {
			Archiver();
		}
	}

	
	
	public ArrayList<Contenu> getContenuPublique() throws RemoteException {
		return contenuPublique;
	}	
}
