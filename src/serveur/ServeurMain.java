package serveur;


/**
 * @author Zakaria
 *
 */
public class ServeurMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			// Définir RMI Security Manager
			if (System.getSecurityManager() == null) {
				//System.setSecurityManager(new RMISecurityManager());
			}
			// Créer le serveur
			Serveur serveur= new Serveur();
			// Démarrer le serveur
			serveur.start();
			Thread.sleep(1000*60*30);// le serveur tourne pendant 30 min
			// Arrêter le serveur
			serveur.stop();
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
;