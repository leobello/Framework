package serveur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Inscription implements Serializable{
	private static final long serialVersionUID = 1L;	
	protected String _user;
	protected String _password;
	protected static int nbInscrit=0;
	protected final File inscrit=new File("Inscri.txt");
	protected ArrayList<Actor> lesInscits=new ArrayList<Actor>();
	public Inscription() {}
	public void ajouter() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer un login : ");
		String login =sc.nextLine();
		System.out.println("Entrer un mot de passe : ");
		String mdp=sc.nextLine();
		System.out.println("Entrer encors une fois le mot de passe pour la vérification : ");
		String mdpv=sc.nextLine();
		while(!mdpv.equals(mdp)) {
			System.out.println("Réentrer le mot de passe et sa vérification : ");
			System.out.println("Entrer un mot de passe : ");
			mdp=sc.nextLine();
			System.out.println("Entrer encors une fois le mot de passe pour la vérification : ");
			mdpv=sc.nextLine();
		}
		_user=login;
		_password=mdp;
		Inscription.nbInscrit++;
		lesInscits.add(new Actor(login, mdp));
		EnregistrerInscrit(inscrit);
		System.out.println("Bien Inscrit "+login);
	}
	public String get_user() {
		return _user;
	}
	public void set_user(String _user) {
		this._user = _user;
	}
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
	protected void EnregistrerInscrit(File f) {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inscrit));
			oos.writeObject(lesInscits);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected ArrayList<Actor> chargerUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
		
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(inscrit)) ;
			//System.out.println(ois.readObject().getClass().toString());
			ArrayList<Actor> users=(ArrayList<Actor>) ois.readObject();
			ois.close();
			/*for(Utilisateur ut:users) {
				System.out.println(ut.user+" "+ut.pass);
			}*/
			return users;		
	}
}
