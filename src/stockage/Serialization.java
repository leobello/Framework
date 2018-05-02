package stockage;

import java.io.*;

public class Serialization implements Serializable {

	public File f;
	
	public Serialization(String fichier, Object o) throws FileNotFoundException, IOException{
		this.f= new File (fichier);
		ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
		oos.writeObject(o);
		oos.close();
		
	}
	
	public String FileName(){
		return f.getName();
	}
}
