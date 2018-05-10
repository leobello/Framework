package bd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import contenu.*;
import stockage.*;

public class Publications implements Serializable {

	private ArrayList<Contenu> contenuPublique;
	private int nbArchiveFiles;
	private  String FileName = "Archive"+nbArchiveFiles;
	private  File ArchiveFile;

	
	
	public Publications() {
		contenuPublique = new ArrayList<Contenu>();
		nbArchiveFiles = 1;
		definirNewFichier();
	}
	
	public void definirNewFichier() {
		ArchiveFile = new File(FileName);
	}

	public void Archiver() {
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

	public void publier() {
		
	}
	
	
	public ArrayList<Contenu> getContenuPublique() {
		return contenuPublique;
	}



	
	
}
