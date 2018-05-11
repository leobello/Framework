
package bd;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import users.*;
import stockage.*;

public class Users extends UnicastRemoteObject implements _Users {

	static final long serialVersionUID = 1L;
	private final String FileName = "Database.txt";
	private final File dataFile;
	private ArrayList<_Utilisateurs> inscrits;
	public static int nbInscrit = 0;
	public static int nbConnected = 0;

	public Users() throws RemoteException {
		dataFile = new File(FileName);
		if (dataFile.length() > 0) {
			inscrits = lireBDFile();
			nbInscrit = inscrits.size();
		} else {
			inscrits = new ArrayList<_Utilisateurs>();
			nbInscrit = 0;
		}
	}

	public void suprimerBD(_Utilisateurs user) throws RemoteException {
		if (user.getClass().getName().equals("Admin")) {
			dataFile.delete();
			inscrits.clear();
			nbInscrit = 0;
			nbConnected = 0;
		}
	}
	
	
	public int getIndexOfUser(String login) {
		for (int i = 0; i < inscrits.size(); i++) {
			if (inscrits.get(i).equals(login)) {
				return i;
			}
		}
		return -1;
		
	}
		
	public void bannir(_Utilisateurs admin, String login) throws RemoteException {
		if (admin.getClass().getName().equals("Admin")) {
			this.inscrits.remove(getIndexOfUser(login)) ;
		}
	}

	public boolean UserNameAlreadyExist(String userName) throws RemoteException {
		for (_Utilisateurs user : inscrits) {
			if (user.getName().equals(userName)) {
				return true;
			}
		}
		return false;
	}

	public void inscrire(String login, String mdp, int typeUtilisateur, int age) throws RemoteException {
		
		switch (typeUtilisateur) {
		case 1:
			inscrits.add(new Diffuseur(login, mdp));
			break;
		case 2:
			inscrits.add(new Admin(login, mdp));
			break;
		default:
			inscrits.add(new User(login, mdp, age));
		}
		nbInscrit++;
		try {
			enregistrerBD();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<_Utilisateurs> getBD() throws NullPointerException, RemoteException {
		return inscrits;
	}

	public void afficher_Utilisateurs() throws RemoteException {

		try {
			ArrayList<_Utilisateurs> p = getBD();
			for (_Utilisateurs us : p) {
				System.out.println(us.getName());
			}
		} catch (NullPointerException e) {
			System.out.println("il n'y aucun utilisateur pour l'instant");
		}
	}

	public int getnbInscrit() {
		return nbInscrit;
	}

	public String getFileName() {
		return FileName;
	}

	public void enregistrerBD() throws FileNotFoundException, IOException, RemoteException {
		new Serialization(dataFile, this.inscrits);
	}

	public ArrayList<_Utilisateurs> lireBDFile() throws RemoteException {
		try {
			Deserialization dsz = new Deserialization(dataFile);
			return (ArrayList<_Utilisateurs>) dsz.ObjectLu();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Utilisateurs getUser(String pseudo) throws RemoteException {
		for (_Utilisateurs p : inscrits) {
			System.out.println(p.getName());
			if (p.getName().equals(pseudo)) {
				return (Utilisateurs) p;
			}
		}
		return null;
	}


	public boolean checkUser(String login, String mdp) throws RemoteException {
		lireBDFile();
		ArrayList<_Utilisateurs> list = getBD();
		for (_Utilisateurs user : list) {
			if (user.getName().equals(login) && user.getPassword().equals(mdp)) {
				System.out.println("connected");
				nbConnected++;
				System.out.println(nbConnected);
				System.out.println("Bienvenue " + login);
				return true;
			} else {
				System.out.println("Login or password not correct");
				return false;
			}
		}
		return false;
	}
}
