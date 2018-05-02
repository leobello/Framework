package serveur;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
public class Actor extends UnicastRemoteObject implements _Actor , Serializable{
	private static final long serialVersionUID = 1L;
	protected String user;
	protected String pass;
	public static int nbUtilisateur=0;
	protected static int nbconnected=0;
	protected Inscription insc=new Inscription(); 
	protected ArrayList<Actor> utilisateurs=new ArrayList<Actor>();
	public Actor(String user, String pass) throws RemoteException {
		this.user = user;
		this.pass = pass;
		Actor.nbUtilisateur++;
		utilisateurs.add(this);
	}
	public Actor() throws RemoteException{}
	public void connectUser() throws RemoteException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer votre login : ");
		String login =sc.nextLine();
		System.out.println("Entrer votre mdp");
		String mdp=sc.nextLine();
		while(!checkUser(login,mdp)) {
			System.out.println("Entrer votre login : ");
			login =sc.nextLine();
			System.out.println("Entrer votre mdp");
			mdp=sc.nextLine();
		}
	}
	public boolean checkUser(String login, String mdp) throws RemoteException{
		ArrayList<Actor> list;
		try {
			list = this.insc.chargerUsers();
			for(Actor user:list) {
				if(user.user.equals(login) && user.pass.equals(mdp)) {
					System.out.println("connected");
					Actor.nbconnected++;
					System.out.println(Actor.nbconnected);
					System.out.println("Bienvenue "+login);
					return true;
				}else {
					System.out.println("Login or password not correct");
					return false ;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
