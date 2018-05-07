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
    		super();
    		this.pseudo = pseudo;
    		this.age = age;
    		this.friendrq = new ArrayList<_Utilisateurs>(); 
    }
    
    public User(String pseudo, String password, int age){
        super.pseudo = pseudo;
        super.password = password;
        this.age = age;
        super.admin = false;
    }
    // user ne peut demander un amis qu'un autre user
    public void friendReq(User user){
    		if(user.getClass().getName() == this.getClass().getName()) {
    			this.friendrq.add(user);
    			System.out.println(this.getName()+" send friend request to "+user.getName());
    		}   		
    }
    
    public _Utilisateurs getFriendReq(int i){return friendrq.get(i);}
    
    
    
}
