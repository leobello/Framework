package input;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



/**
 * Classe qui implemente l'interface _RMIInputStream
 * @author Zakaria
 *
 */
public class RMIInputStreamImpl implements _RMIInputStream {
	
	// flux d'entrer 
	private InputStream in;
	// bytes à lire
	private byte[] b;

	/**
	 * @param in le flux d'entrer 
	 * @throws IOException
	 */
	public RMIInputStreamImpl(InputStream in) throws IOException {
		this.in = in;
		// Exporter le flux
		UnicastRemoteObject.exportObject(this, 1099);
	}

	/* (non-Javadoc)
	 * @see input._RMIInputStream#read()
	 */
	public int read() throws IOException, RemoteException {
		return in.read();
	}

	/* (non-Javadoc)
	 * @see input._RMIInputStream#readBytes(int)
	 */
	public byte[] readBytes(int len) throws IOException, RemoteException {
		if (b == null || b.length != len)
			b = new byte[len];

		int len2 = in.read(b);
		if (len2 < 0)
			return null; // Fin de fichier 

		// Si un nombre d'octets inférieur à len est lu, le tableau renvoyé
	    // aura une nouvelle taille égale au nombre d'octets réellement lus
		if (len2 != len) {
			byte[] b2 = new byte[len2];
			System.arraycopy(b, 0, b2, 0, len2);
			return b2;
		} else
			return b;
	}
	/* (non-Javadoc)
	 * @see input._RMIInputStream#close()
	 */
	public void close() throws IOException, RemoteException {
		in.close();
	}

}