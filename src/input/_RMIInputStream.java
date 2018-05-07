package input;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * l'interface qui etends la class Remote
 * @author Zakaria
 *
 */
public interface _RMIInputStream extends Remote {
    
	 /**
     * @return renvoie le caractère lu ou -1 si la fin du flux est atteinte.
     * @throws IOException
     * @throws RemoteException
     */
    public int read() throws IOException, RemoteException;
    /**
     * Lit un nombre d'octets dans un InputStream
     * Si un nombre d'octets inférieur à len est lu, le tableau renvoyé
     * aura une nouvelle taille égale au nombre d'octets réellement lus
     * @param len Le nombre d'octets à lire
     * @return les données lues, null si la fin est atteinte
     * @throws IOException
     * @throws RemoteException 
     */
    public byte[] readBytes(int len) throws IOException, RemoteException;
    /**
     * ferme le flux et libère les ressources qui lui étaient associées
     * @throws IOException
     * @throws RemoteException
     */
    public void close() throws IOException, RemoteException;
    

}