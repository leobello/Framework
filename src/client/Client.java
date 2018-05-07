package client;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    public void telecharger(_Serveur  serveur, File src, File dest) throws IOException {
    	System.out.println("Téléchargement en cours");
        copier (serveur.getInputStream(src), new FileOutputStream(dest));
    }
}
