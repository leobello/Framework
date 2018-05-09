package client;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import bd._Users;
import serveur._Serveur;

/**
 * @author Zakaria
 *
 */
public class Client extends UnicastRemoteObject implements _Client {

	
	private static final long serialVersionUID = 1L;
	// le nom du client 
	private String name;
	
	final public static int BUF_SIZE = 1024 * 64;
	
	/**
	 * @param n le nm du client
	 * @throws RemoteException
	 */
	public Client() throws RemoteException{}
	public  Client(String n) throws RemoteException {
		super();
		name=n;
	}
	
	
	/* (non-Javadoc)
	 * @see client._Client#getName()
	 */
	public String getName() throws RemoteException{
		return name;
	}
	
	
	/* (non-Javadoc)
	 * @see client._Client#copier(java.io.InputStream, java.io.OutputStream)
	 */
	public void copier(InputStream in, OutputStream out)  throws IOException {
        byte[] b = new byte[BUF_SIZE];
        int len;
        while ((len = in.read(b)) >= 0) {
            out.write(b, 0, len);
        }
        in.close();
        out.close();
    }

    /* (non-Javadoc)
     * @see client._Client#uploader(serveur._Serveur, java.io.File, java.io.File)
     */
    public void uploader(_Serveur serveur, File src, File dest) throws IOException {
        System.out.println("Upload en cours");
    	copier (new FileInputStream(src), serveur.getOutputStream(dest));
    }

    /* (non-Javadoc)
     * @see client._Client#telecharger(serveur._Serveur, java.io.File, java.io.File)
     */
    public void telechar﻿​_ger(_Serveur  serveur, File src, File dest) throws IOException {
    	System.out.println("Téléchargement en cours");
        copier (serveur.getInputStream(src), new FileOutputStream(dest));
    }
    
    public Object[] inscription() throws MalformedURLException, RemoteException, NotBoundException{
    	Object[] user=new Object[4];
    	String url = "rmi://localhost/Gnaouas";
		_Users server=(_Users)Naming.lookup(url);
    	Scanner sc=new Scanner(System.in);
		System.out.println("Entrer un login : ");
		String login =sc.nextLine();
		while(server.UserNameAlreadyExist(login)==true){
			System.out.println("Entrer un nouveau login car le dernier existe déja : ");
			login =sc.nextLine();
		}
		user[0]=login;
		System.out.println("Entrer un mot de passe : ");
		String mdp=sc.nextLine();
		user[1]=mdp;
		System.out.println("Entrer encore une fois le mot de passe pour la vérification : ");
		String mdpv=sc.nextLine();
		
		while(!mdpv.equals(mdp)) {
			System.out.println("Rerentrer le mot de passe et sa vérification : ");
			System.out.println("Entrer un mot de passe : ");
			mdp=sc.nextLine();
			user[1]=mdp;
			System.out.println("Entrer encore une fois le mot de passe pour la vérification : ");
			mdpv=sc.nextLine();
		}
		System.out.println("entrez votre age");
		int age = sc.nextInt();
		user[2]=age;
		System.out.println("Vous étes diffuseur de contenu, admin ou simplement un utilisateur ? répondre par 1,2,3 ");
		int typeUtilisateur=sc.nextInt();
		user[3]=typeUtilisateur;
		while(typeUtilisateur > 3 || typeUtilisateur < 1 ){
			System.out.println("le chiffre que vous rentrez ne fais pas partie des réponse possible, entre 1,2,3 (diffiseur de contenu, admin ou utilisateur");
			typeUtilisateur=sc.nextInt();
			user[3]=typeUtilisateur;
		}		
		return user;
    }
    public void connectUser() throws MalformedURLException, RemoteException, NotBoundException{
    	String url = "rmi://localhost/Gnaouas";
		_Users server=(_Users)Naming.lookup(url);
    	Scanner sc = new Scanner(System.in);
		System.out.println("Entrer votre login : ");
		String login = sc.nextLine();
		System.out.println("Entrer votre mdp");
		String mdp = sc.nextLine();
		try {
			while (!server.checkUser(login, mdp)) {
				System.out.println("Login or password not correct");
				System.out.println("Entrer votre login : ");
				login = sc.nextLine();
				System.out.println("Entrer votre mdp");
				mdp = sc.nextLine();
			}
		System.out.println("Bienvenue " + login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
	public void telecharger(_Serveur serveur, File src, File dest) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
