/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bd._Users;
import serveur.Serveur;

/**
 *
 * @author near
 */

public class Admin extends Utilisateurs {
    
	private static final long serialVersionUID = 1L;
	
	public Admin(String pseudo, String password){

        this.pseudo = pseudo;
        this.password = password;
        this.admin = true;
    }
    
    public void Bannir(String login) throws MalformedURLException, RemoteException, NotBoundException {
    	String url="rmi://"+Serveur.listen+"/Gnaouas";
    	_Users serv=(_Users)Naming.lookup(url);
    	try {
			serv.bannir(this, login);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void SupprimerBD(String login) throws MalformedURLException, RemoteException, NotBoundException {
    	String url="rmi://"+Serveur.listen+"/Gnaouas";
    	_Users serv=(_Users)Naming.lookup(url);
    	serv.suprimerBD(this);
    }
}
