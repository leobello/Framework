/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author near
 */
public class Diffuseur extends Utilisateurs {


	private static final long serialVersionUID = 1L;

	public Diffuseur(String pseudo){
		
	}

    public Diffuseur(String pseudo, String password){

        super.pseudo = pseudo;
        super.password= password;
        super.admin = false;
    }
    
}
