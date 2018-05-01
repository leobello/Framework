package client;


import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements _Client {

	
	private static final long serialVersionUID = 1L;
	public String name;
	public  Client(String n) throws RemoteException {
		super();
		name=n;
	}
 
	public String getName() throws RemoteException{
		return name;
	}
    
	public boolean sendData(String filename, byte[] data, int len) throws RemoteException{
        try{
        	File f=new File("Client_"+filename);
        	f.createNewFile();
        	FileOutputStream out=new FileOutputStream(f,true);
        	out.write(data,0,len);
        	out.flush();
        	out.close();
        	System.out.println("Done writing data...");
        }catch(Exception e){
        	e.printStackTrace();
        }
		return true;
	}

}
