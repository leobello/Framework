package stockage;
import java.io.*;


public class Deserialization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public File f;
	public Object ReadedObject;
	
		public Deserialization(String fichier) throws FileNotFoundException, IOException, ClassNotFoundException{
			this.f= new File (fichier);
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
			this.ReadedObject = ois.readObject();
			ois.close();
		}
		
		public Object ObjectLu() {
			return this.ReadedObject;
		}
		
		public String FileName(){
			return f.getName();
		}
}
