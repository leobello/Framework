package bd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import users.*;
import java.util.Scanner;
import stockage.*;


public class Users implements _Users {

	private final String FileName = "Database.txt";
	private final File dataFile;
	private ArrayList<_Utilisateurs> inscrits;
	public static int nbInscrit = 0;
	
	public Users(){
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

	/*public void suprimer(_Utilisateurs user){
		if(user.getClass().getName() == "Admin"){
			
		}
	}*/
		
	
	
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
		
		sc.close();
		nbInscrit++;
		try {
			enregistrerBD();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<_Utilisateurs> getBD() throws NullPointerException{
		return inscrits;
	}
	
	
	
	public void afficher_Utilisateurs(){
		
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
	public void enregistrerBD() throws FileNotFoundException, IOException{
		 new Serialization(dataFile,this.inscrits);
	}
	
	public ArrayList<_Utilisateurs> lireBDFile(){		
		try {
			Deserialization dsz = new Deserialization(dataFile);
			 return  (ArrayList<_Utilisateurs>) dsz.ObjectLu();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
	

}
