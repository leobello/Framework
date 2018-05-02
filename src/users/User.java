/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.ArrayList;

/**
 *
 * @author near
 */
public class User  extends Utilisateurs  {

    protected ArrayList<_Utilisateurs> friendrq;
    int age;


    

	private static final long serialVersionUID = 1L;
	
    public User(String pseudo, int age){
    	this.pseudo = pseudo;
    	this.age = age;
    }
    
    public User(String pseudo, String password, int age){
        super.pseudo = pseudo;
        super.password = password;
        this.age = age;
        super.admin = false;
    }
    // user ne peut demander un amis qu'un autre user
    public void friendReq(Utilisateurs user){
    	try{
    		User user2 = (User)user;
            this.friendrq.add(user2);
            System.out.println(user2.pseudo+" added : "+this.pseudo);
    		
    	} catch (ClassCastException e) {
    		 e.printStackTrace();
    	}
    	
    }
    
    public _Utilisateurs getFriendReq(int i){return friendrq.get(i);}
    
    
    
}
