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

public class Admin extends Utilisateurs {
    
	private static final long serialVersionUID = 1L;
	
	public Admin(String pseudo, String password){

        this.pseudo = pseudo;
        this.password = password;
        this.admin = true;
    }
    
    
}
