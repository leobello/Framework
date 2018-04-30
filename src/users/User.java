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
public class User extends Utilisateurs {
    int age;
    
    public User(String pseudo, int age){
        super.pseudo = pseudo;
        this.age = age;
        super.admin = false;
    }
    
    
}
