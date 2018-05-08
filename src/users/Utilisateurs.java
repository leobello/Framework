/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import contenu.*;


import java.io.Serializable;
import java.util.ArrayList;
import services.*;

/**
 *
 * @author near
 */
public abstract class Utilisateurs implements _Utilisateurs, Serializable {
   
	private static final long serialVersionUID = 1L;
	protected String pseudo;
    protected String password;
    protected ArrayList<_Reactions> reactions;
    protected ArrayList<Contenu> partages;
    protected ArrayList<_Utilisateurs> friends;
    protected ArrayList<_Utilisateurs> followed;
    protected ArrayList<_Utilisateurs> followby;  
    protected boolean admin;
    
    
    public Utilisateurs() {
    		this.reactions = new ArrayList<_Reactions>();
    		this.partages = new ArrayList<Contenu>();
    		this.friends = new ArrayList<_Utilisateurs>();
    		this.followed = new ArrayList<_Utilisateurs>();
    		this.followby= new ArrayList<_Utilisateurs>();  		
    }
    
    
    
        
    public String getName(){return this.pseudo;}
    public String getPassword(){return this.password;}
   
    
    public void setName(String name){
        this.pseudo = name;
    }
    
    public ArrayList<Contenu> getPartages(){ return this.partages; }
    

    public void publier(Contenu c){
    		this.partages.add(c);    	
    }
    
   
    public void liker(Contenu c){
        Like r = new Like(this,c);
        reactions.add(r);
    }
    
    public void disliker(Contenu c){
        Dislike r = new Dislike(this,c);
        reactions.add(r);
    }
    
    public void commenter(Contenu c, String s) {
    		Commentaire com = new Commentaire(this,c,s);
    		c.addComment(com);
    }
    
    public void beFriend(_Utilisateurs u) {
    		this.friends.add(u);
    }
    
    public void printFriend() {
    		for(_Utilisateurs u : this.friends) {
    			System.out.println(u.getName());
    		}
    }
    
   /* fonction tri date et stat à faire  */
    
   public void triTimeline(ArrayList<Contenu> list) {
	   Contenu older;
	   ArrayList<Contenu> timeline = new ArrayList<Contenu>();
	   int i = 0;
	   if(!list.isEmpty()) {
		   older = list.get(i);
		   for(i = 1 ; i < list.size(); i++) {
			   if( older.getDate().compareTo(list.get(i).getDate()) < 0 ) {
				   timeline.add(older);
				   list.remove(older);
			   }
			   
		   }
	   }
   }
    
    public ArrayList<Contenu> getTimeline(){
    		ArrayList<Contenu> timeline = new ArrayList<Contenu>();
    		Utilisateurs u2 = null;
    		for(_Utilisateurs u : this.friends) {
    			u2 = (Utilisateurs)u;
    			for(Contenu c : u2.getPartages()) {
    				timeline.add(c);
    			}
    		}	
    		return timeline;
    }
    
    
    
    
    
    
    
    
         
}
