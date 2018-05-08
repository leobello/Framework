package serveur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;


public class Inscription extends UnicastRemoteObject implements _Inscritption, Serializable{
	private static final long serialVersionUID = 1L;	
	protected String _user;
	protected String _password;
	protected static int nbInscrit=0;
	protected final File inscrit=new File("Inscri.txt");
	protected ArrayList<Actor> lesInscits=new ArrayList<Actor>();


	public Inscription() throws RemoteException{}
	public void ajouter() throws RemoteException{


		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer un login : ");
		String login =sc.nextLine();
		System.out.println("Entrer un mot de passe : ");
		String mdp=sc.nextLine();
		System.out.println("Entrer encore une fois le mot de passe pour la vérification : ");
		String mdpv=sc.nextLine();
		while(!mdpv.equals(mdp)) {
			System.out.println("Rerentrer le mot de passe et sa vérification : ");
			System.out.println("Entrer un mot de passe : ");
			mdp=sc.nextLine();
			System.out.println("Entrer encors une fois le mot de passe pour la vérification : ");
			mdpv=sc.nextLine();
		}
		_user=login;
		_password=mdp;
		Inscription.nbInscrit++;
		lesInscits.add(new Actor(login, mdp));
		EnregistrerInscrit();
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


	protected void EnregistrerInscrit() {}

	public void EnregistrerInscrit(File f)  throws RemoteException{


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
	public ArrayList<Actor> chargerUsers()  throws RemoteException{
		
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(inscrit));
				@SuppressWarnings("unchecked")
				ArrayList<Actor> users=(ArrayList<Actor>) ois.readObject();
				ois.close();
				return users;
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			//System.out.println(ois.readObject().getClass().toString());			
			/*for(Utilisateur ut:users) {
				System.out.println(ut.user+" "+ut.pass);
			}*/
					
	}
}
