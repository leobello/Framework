package output;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Pour avoir le flux OutputStream standard 
 * @author dzpanda
 *
 */
public class RMIOutputStream extends OutputStream implements 
        Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private _RMIOutputStream out;
    
	
    /**
     * Instacier le flux de sortie avec _RMIOutputStream 
     * @param out
     */
    public RMIOutputStream(_RMIOutputStream out) {
        this.out = out;
    }
    
    /* (non-Javadoc)
     * @see java.io.OutputStream#write(int)
     */
    public void write(int b) throws IOException {
        out.write(b);
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#write(byte[], int, int)
     */
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
    }
    
    
    /* (non-Javadoc)
     * @see java.io.OutputStream#close()
     */
    public void close() throws IOException {
        out.close();
    }   
}