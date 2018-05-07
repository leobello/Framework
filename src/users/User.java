/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    public void setFriendRqst(User u) {
    		this.friendrq.add(u);
    }
    
    // user ne peut demander un amis qu'un autre user
    public void friendReq(User user){
    		if(user.getClass().getName() == this.getClass().getName()) {
    			user.setFriendRqst(this);
    			
    			System.out.println(this.getName()+" send friend request to "+user.getName());
    		}   		
    }
    
    public void getFriendReqst() {
    		int i;
    		String c;
    		@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
    		if(!friendrq.isEmpty()) {
    			i = this.friendrq.size() - 1;
    			do {
    				System.out.println("Demande d'ami de "+this.friendrq.get(i).getName());
    				System.out.println("accepter: yes/no"); 
    				c = sc.nextLine();
    			}while(!c.equals("yes") && !c.equals("no"));
    			if(c.equals("yes")) {
    				Utilisateurs u2;
    				u2 = (Utilisateurs)this.friendrq.get(i);
    				this.beFriend(this.friendrq.get(i));
    				u2.beFriend(this);
    			}
    			this.friendrq.remove(i);
    		}
    		else {
    			System.out.println("Aucune demande d'ami");
    		}
 
    }
    
    public void getAllFriendRqst() {
    		while(!this.friendrq.isEmpty()) {
    			this.getFriendReqst();
    		}
    }  
       
}
