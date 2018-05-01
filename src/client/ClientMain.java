package client;


import java.net.InetAddress;
import java.rmi.Naming;
import java.util.Scanner;

import serveur._Serveur;

public class ClientMain {
	public static void main(String[] args) {
		try{
			Client c=new Client("Zak");			
			_Serveur server=(_Serveur)Naming.lookup("rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Gnaouas");
			System.out.println("Listening.....");
			server.login(c);			
			Scanner s=new Scanner(System.in);			
			while(true){
				String line = s.nextLine();
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
