/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;

/**
 *
 * @author near
 */
public class User  extends Utilisateurs  {
	int age;
    
    public User(String pseudo, String password, int age){
        super.pseudo = pseudo;
        super.password = password;
        this.age = age;
        super.admin = false;
    }
    
    
}
