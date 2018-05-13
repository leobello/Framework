package bd;


import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import contenu.Contenu;
import stockage.*;
import users.*;

public class Users extends UnicastRemoteObject implements _Users {

	static final long serialVersionUID = 1L;
	private final String FileName = "Database.txt";
	private final File UserArchive;
	public ArrayList<_Utilisateurs> inscrits;
	public static int nbInscrit = 0;
	public static int nbConnected = 0;
	private ArrayList<Contenu> contenuPublique;
	private String ArchivesFilesName = "ArchivePublications";
	private  File FilePublications;
	
	// Constructeur

	public Users() throws RemoteException {
		UserArchive = new File(FileName);
		FilePublications = new File(ArchivesFilesName);
		
		if (UserArchive.length() > 0 ) {
			inscrits = lireBDFile();
			nbInscrit = inscrits.size();

		} else {
			inscrits = new ArrayList<_Utilisateurs>();
			nbInscrit = 0;
		}
		
		if (FilePublications.length() > 0 ) {
			contenuPublique=lireArchiveFile();
		}
		else contenuPublique = new ArrayList<Contenu>();
		
	}
	
	//getteur et setteur de la partie stockage des users 
	
	public int getnbInscrit()  {
		return nbInscrit;
	}

	public String getFileName()throws RemoteException {
		return FileName;
	}
	
	public ArrayList<_Utilisateurs> getBD() throws NullPointerException, RemoteException {
		return inscrits;
	}
	
	public Utilisateurs getUser(String pseudo) throws RemoteException {
		for (_Utilisateurs p : inscrits) {
			System.out.println(p.getName());
			if (p.getName().equals(pseudo)) {
				System.out.println(((Utilisateurs) p).getName());
				return (Utilisateurs) p;
			}
		}
		return null;
	}

	// m�thodes utiles pour le stockage des users
	
	public int getIndexOfUser(String login) throws RemoteException {
		for (int i = 0; i < inscrits.size(); i++) {
			try {
				if (inscrits.get(i).getName().equals(login)) {
					return i;
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
		
	}
	
	
	public boolean UserNameAlreadyExist(String userName) throws RemoteException {
		for (_Utilisateurs user : inscrits) {
			if (user.getName().equals(userName)) {
				return true;
			}
		}
		return false;
	}

	public void afficher_Utilisateurs() throws RemoteException {

		try {
			ArrayList<_Utilisateurs> p = getBD();
			for (_Utilisateurs us : p) {
				System.out.println(us.getName() +" "+ us.getPassword());
			}
		} catch (NullPointerException e) {
			System.out.println("il n'y aucun utilisateur pour l'instant");
		}
	}
	
	public void enregistrerBD() throws FileNotFoundException, IOException, RemoteException {
		new Serialization(UserArchive, this.inscrits);
	}
	
	public void updateUser(_Utilisateurs usr) throws RemoteException{
		int UserIndex = getIndexOfUser(usr.getName());
		inscrits.add(UserIndex, usr);
		try {
			enregistrerBD();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<_Utilisateurs> lireBDFile() throws RemoteException {
		try {
			Deserialization dsz = new Deserialization(UserArchive);
			return (ArrayList<_Utilisateurs>) dsz.ObjectLu();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// m�thodes utile sur la BD des utilisateurs
	
	public boolean checkUser(String login, String mdp) throws RemoteException {
		lireBDFile();
		ArrayList<_Utilisateurs> list = getBD();
		System.out.println(list.size());
		for (_Utilisateurs user : list) {
			//System.out.println("Compare celui l� : "+user.getName() +" "+user.getPassword()+" avec : "+login+" "+mdp);
			if (user.getName().equals(login) && user.getPassword().equals(mdp)) {
				System.out.println("connected");
				nbConnected++;
				System.out.println(nbConnected);
				System.out.println("Bienvenue " + login);
				return true;
			} else {
				System.out.println("Login or password not correct");
			}
		}
		return false;
	}
	


	
	public void bannir(Admin admin, String login) throws FileNotFoundException, IOException {
		//this.inscrits.remove(getIndexOfUser(login)) ;
		inscrits.remove(getUser(login));
		nbInscrit--;
		enregistrerBD();
	
}
	public void suprimerBD(_Utilisateurs user) throws RemoteException {
		if (user.getClass().getName().equals("Admin")) {
			UserArchive.delete();
			inscrits.clear();
			nbInscrit = 0;
			nbConnected = 0;
		}
	}
	
	public boolean inscrire(String login, String mdp, int typeUtilisateur, int age) throws RemoteException, IOException {
		
		switch (typeUtilisateur) {
		case 1:
			inscrits.add(new Diffuseur(login, mdp));
			nbInscrit++;
			enregistrerBD();
			System.out.println("Bien Inscrit");
			return true;
		case 2:
			inscrits.add(new Admin(login, mdp));
			nbInscrit++;
			enregistrerBD();
			System.out.println("Bien Inscrit");
			return true;
		default:
			inscrits.add(new User(login, mdp, age));
			nbInscrit++;
			enregistrerBD();
			System.out.println("Bien Inscrit");
			return true;
		}
		
	}
////////////////////////////////////////////////////Stockage de publications\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	// getteur et setteurs 
	
	public ArrayList<Contenu> getPublication() throws RemoteException{
		return contenuPublique;
	}
	public String getFIleNameOFArchivePublication() throws RemoteException {
		return ArchivesFilesName;
	}
	
	
	// stoclahe de publication : 
	public void ArchiverPublication() throws RemoteException {
		try {
			new Serialization(FilePublications,contenuPublique);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@SuppressWarnings("unchecked")
	public ArrayList<Contenu> lireArchiveFile() throws RemoteException {
		try {
			Deserialization dsz = new Deserialization(this.FilePublications);
			return (ArrayList<Contenu>) dsz.ObjectLu();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// m�thode utile sur la BD des publications
	
	public void afficher_Publications() throws RemoteException {
		for (Contenu x : contenuPublique) {
			System.out.println(x.getContenu());
		}	
	}

	public void publier(Contenu T) throws RemoteException {
		contenuPublique.add(T);
		ArchiverPublication();
	}
	
	
	
}