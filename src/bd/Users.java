
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
	public static int nbConnected=0;
	public Users() throws RemoteException{
		dataFile = new File(FileName);
		if (dataFile.length()>0) {
			inscrits = lireBDFile();
			nbInscrit=inscrits.size();
		}
		else{
			inscrits= new ArrayList<_Utilisateurs>();
			nbInscrit=0;
		}
	}

	public void suprimerBD(_Utilisateurs user){
		if(user.getClass().getName() == "Admin"){
			dataFile.delete();
			inscrits.clear();
			nbInscrit=0;
			nbConnected=0;
		}
	}
		
	
	public boolean UserNameAlreadyExist(String userName) {
		for (_Utilisateurs user : inscrits) {
			if ( userName == user.getName()) {
				 return true;
			}
		}
		return false;
	}
	
	
	
	
	public void inscrire() throws RemoteException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer un login : ");
		String login =sc.nextLine();
		while ( UserNameAlreadyExist(login)) {
			System.out.println("Le login que vous venez de rentrez existe d�ja, veillez en entrez un autre");
			login =sc.nextLine();
		}
		System.out.println("Entrer un mot de passe : ");
		String mdp=sc.nextLine();
		System.out.println("Entrer encore une fois le mot de passe pour la vérification : ");
		String mdpv=sc.nextLine();
		
		while(!mdpv.equals(mdp)) {
			System.out.println("Rerentrer le mot de passe et sa vérification : ");
			System.out.println("Entrer un mot de passe : ");
			mdp=sc.nextLine();
			System.out.println("Entrer encore une fois le mot de passe pour la vérification : ");
			mdpv=sc.nextLine();
		}
		
		System.out.println("Vous étes diffuseur de contenu, admin ou simplement un utilisateur ? répondre par 1,2,3 ");
		int typeUtilisateur=sc.nextInt();
		
		while(typeUtilisateur > 3 || typeUtilisateur < 1 ){
			System.out.println("le chiffre que vous rentrez ne fais pas partie des réponse possible, entre 1,2,3 (diffiseur de contenu, admin ou utilisateur");
			typeUtilisateur=sc.nextInt();
		}
		
		switch(typeUtilisateur){
		
		case 1 :
				inscrits.add(new Diffuseur(login,mdp));
				break;
		case 2 :
				inscrits.add(new Admin(login,mdp));
				break;
		default :
				System.out.println("entrez votre age");
				int age = sc.nextInt();
				inscrits.add(new User(login,mdp,age));
				
		}
		
		sc.close();
		nbInscrit++;
		try {
			enregistrerBD();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<_Utilisateurs> getBD() throws NullPointerException ,RemoteException{
		return inscrits;
	}
	
	
	
	public void afficher_Utilisateurs() throws RemoteException{
		
		try{
			ArrayList<_Utilisateurs> p = getBD();
			for (_Utilisateurs us : p) {
				System.out.println(us.getName());
			}
		} catch (NullPointerException e){
			System.out.println("il n'y aucun utilisateur pour l'instant");
		}
	}
	
	
	public int getnbInscrit(){
		return nbInscrit;
	}
	
	public String getFileName(){
		return FileName;
	}
	public void enregistrerBD() throws FileNotFoundException, IOException,RemoteException{
		 new Serialization(dataFile,this.inscrits);
	}
	
	public ArrayList<_Utilisateurs> lireBDFile() throws RemoteException{		
		try {
			Deserialization dsz = new Deserialization(dataFile);
			 return  (ArrayList<_Utilisateurs>) dsz.ObjectLu();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public Utilisateurs getUser(String pseudo) throws RemoteException{
		for (_Utilisateurs p : inscrits) {
			System.out.println(p.getName());
			if (p.getName().equals(pseudo)) {
				System.out.println("done");
				return (Utilisateurs) p;
			}
		}
		return null;	
	}
	public void connectUser() throws RemoteException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer votre login : ");
		String login =sc.nextLine();
		System.out.println("Entrer votre mdp");
		String mdp=sc.nextLine();
		try {
			while(!checkUser(login,mdp)) {
				System.out.println("Entrer votre login : ");
				login =sc.nextLine();
				System.out.println("Entrer votre mdp");
				mdp=sc.nextLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean checkUser(String login, String mdp) throws RemoteException {
		lireBDFile();
		ArrayList<_Utilisateurs> list=getBD();
		for(_Utilisateurs user:list) {
			if(user.getName().equals(login) && user.getPassword().equals(mdp)) {
				System.out.println("connected");
				nbConnected++;
				System.out.println(nbConnected);
				System.out.println("Bienvenue "+login);
				return true;
			}else {
				System.out.println("Login or password not correct");
				return false ;
			}
		}
		return false;
	}
}

