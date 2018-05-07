package output;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.server.UnicastRemoteObject;
/**
 * Classe qui implemente l'interface _RMIOutputStream
 * @author Zakaria
 *
 */

public class RMIOutputStreamImpl implements _RMIOutputStream {

    private OutputStream out;

    /**
     * Constructeur 
     * @param out : le flux d'octets à exporter 
     * @throws IOException
     */
    public RMIOutputStreamImpl(OutputStream out) throws IOException {
        this.out = out;
        // Exporter le flux d'octets
        UnicastRemoteObject.exportObject(this, 1099);
    }
   
    /* (non-Javadoc)
     * @see output._RMIOutputStream#write(int)
     */
    public void write(int b) throws IOException {
        out.write(b);
    }
    
    /* (non-Javadoc)
     * @see output._RMIOutputStream#write(byte[], int, int)
     */
    public void write(byte[] b, int off, int len) throws  IOException {
        out.write(b, off, len);
    }

    /* (non-Javadoc)
     * @see output._RMIOutputStream#close()
     */
    public void close() throws IOException {
        out.close();
    }

}