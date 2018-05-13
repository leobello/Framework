package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import bd._Users;
import serveur.Serveur;
import serveur._Serveur;
import users.Utilisateurs;

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
	 * @param n
	 *            le nm du client
	 * @throws RemoteException
	 */
	public Client() throws RemoteException {
	}

	public Client(String n) throws RemoteException {
		super();
		name = n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see client._Client#getName()
	 */
	public String getName() throws RemoteException {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
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
    public void telecharger(_Serveur  serveur, File src, File dest) throws IOException {
    	System.out.println("Téléchargement en cours");
        copier (serveur.getInputStream(src), new FileOutputStream(dest));
    }
    
	/**
	 * @param pseudo
	 * @param password
	 * @param passwordv
	 * @param type
	 * @param age
	 * @throws NotBoundException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void inscription(String pseudo, String password, String passwordv, int type, int age)
			throws NotBoundException, FileNotFoundException, IOException {
		String url = "rmi://"+Serveur.listen+"/Gnaouas";
		_Users server = (_Users) Naming.lookup(url);
		if (server.UserNameAlreadyExist(pseudo) == true) {
			System.out.println("Entrer un nouveau login car le dernier existe déja  ");
		}else {
			if(server.inscrire(pseudo, password, type, age)) {
				System.out.println("Bien Inscrit "+pseudo);
			}else {
				System.out.println("PAS INSCRIT");
			}
		}
    }
 
	/**
	 * @param login
	 * @param password
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public Utilisateurs connectUser(String login,String password) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://"+Serveur.listen+"/Gnaouas";
		_Users server = (_Users) Naming.lookup(url);
		try {
			if (!server.checkUser(login, password)) {
				System.out.println("Login or password not correct");
				System.out.println("Entrer votre login et le mot de passe: ");
			}else {
				System.out.println("Bienvenue" + login);
				return server.getUser(login);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
