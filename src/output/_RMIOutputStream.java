package output;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface qui etends la class Remote 
 * @author dzpanda
 *
 */
public interface _RMIOutputStream extends Remote {
    
	 /**
     * écrit l'octet en paramètre dans le flux
     * @param b : octet à écrire
     */
	public void write(int b) throws IOException, RemoteException;
    
	/**
	 * Ecrire plusieurs octets
	 * @param b tableau d'octets à écrire
	 * @param off l'indice du premier élément du tableau à écrire
	 * @param len le nombre d'octets à écrire
	 * @throws IOException
	 * @throws RemoteException
	 */
	public void write(byte[] b, int off, int len) throws IOException, RemoteException;
    
	/**
	 * ferme le flux et libère les ressources qui lui étaient associées
	 * @throws IOException
	 * @throws RemoteException
	 */
	public void close() throws IOException, RemoteException;

}
