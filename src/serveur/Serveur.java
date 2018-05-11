package serveur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import input.RMIInputStream;
import input.RMIInputStreamImpl;
import output.RMIOutputStream;
import output.RMIOutputStreamImpl;

/**
 * class qui implements l'interface _Serveur
 * @author Zakaria
 *
 */
public class Serveur extends UnicastRemoteObject implements _Serveur {
	public static final String listen="localhost";
	private static final long serialVersionUID = 1L;
	private Registry rmiRegistry;

	protected Serveur() throws RemoteException {
		super();

	}

	/**
	 * Démarrer le serveur
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		// Créer le registr avec le port 1099
		rmiRegistry = LocateRegistry.createRegistry(1099);
		// Enregistrer l'objet créé dans le registre de noms en lui affectant un nom
		String url = "rmi://152.77.82.60/Gnaouas";
		Naming.rebind(url, this);
		System.out.println("Serveur est prêt");
	}

	/**
	 * Arrêter le serveur
	 * 
	 * @throws Exception
	 */

	public void stop() throws Exception {
		// Détacher l'objet créé en utilisant le nom
		rmiRegistry.unbind("Gnaouas");
		// Enlever l'objet créé (Serveur)
		unexportObject(this, true);
		// Enlever le Registre
		unexportObject(rmiRegistry, true);
		System.out.println("Fin du serveur");
	}

	
	/* (non-Javadoc)
	 * @see serveur._Serveur#getOutputStream(java.io.File)
	 */
	public OutputStream getOutputStream(File f) throws IOException {
		return new RMIOutputStream(new RMIOutputStreamImpl(new FileOutputStream(f)));
	}

	/* (non-Javadoc)
	 * @see serveur._Serveur#getInputStream(java.io.File)
	 */
	public InputStream getInputStream(File f) throws IOException {
		return new RMIInputStream(new RMIInputStreamImpl(new FileInputStream(f)));
	}

}
