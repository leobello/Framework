package bd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import users.*;
import java.util.Scanner;

import serveur.Actor;
import serveur.Inscription;
import stockage.*;


public class Users {
	
	private ArrayList<_Utilisateurs> inscrits;
	public static int nbInscrit = 0;
	public static int nbConnected=0;
	public Users(){
		inscrits= new ArrayList<_Utilisateurs>() ;
	}
	
	
	public void inscrire() {
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
				
		try {
			enregistrerBD();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<_Utilisateurs> getBD(){
		return inscrits;
	}
	
	public void enregistrerBD() throws FileNotFoundException, IOException{
		Serialization sz = new Serialization("DataBase",this.inscrits);
	}
	
	public void lireBDFile(){
		
		try {
			Deserialization dsz = new Deserialization("DataBase");
			inscrits = (ArrayList<_Utilisateurs>) dsz.ObjectLu();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public Utilisateurs getUser(String pseudo){
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
