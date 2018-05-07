package input;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


/**
 * Pour avoir le flux InputStream standard 
 * @author Zakaria
 *
 */
public class RMIInputStream extends InputStream implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_RMIInputStream in;
	
	/**
     * Instacier le flux d'entrée avec _RMIOutputStream 
     * @param out
     */
	public RMIInputStream(_RMIInputStream in) {
		this.in = in;
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#read()
	 */
	public int read() throws IOException {
		return in.read();
	}

	
	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[], int, int)
	 */
	public int read(byte[] b, int off, int len) throws IOException {
		byte[] b2 = in.readBytes(len);
		if (b2 == null)
			return -1;
		int i = b2.length;
		System.arraycopy(b2, 0, b, off, i);
		return i;
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#close()
	 */
	public void close() throws IOException {
		super.close();
	}

}