/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import contenu.Commentaire;
import contenu.Contenu;
import contenu.Types;

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
    protected ArrayList<Contenu<Types>> partages;
    protected ArrayList<_Utilisateurs> friends;
    protected ArrayList<_Utilisateurs> followed;
    protected ArrayList<_Utilisateurs> followby;  
    protected boolean admin;
    
    
    public Utilisateurs() {
    		this.reactions = new ArrayList<_Reactions>();
    		this.partages = new ArrayList<Contenu<Types>>();
    		this.friends = new ArrayList<_Utilisateurs>();
    		this.followed = new ArrayList<_Utilisateurs>();
    		this.followby= new ArrayList<_Utilisateurs>();  		
    }
    
    
    
        
    public String getName(){return this.pseudo;}
    public String getPassword(){return this.password;}
    
    public void setName(String name){
        this.pseudo = name;
    }
    
    public ArrayList<Contenu<Types>> getPartages(){ return this.partages; }
    

    public void publier(Contenu<Types> c){
    		this.partages.add(c);    	
    }
    
   
    public void liker(Contenu<Types> c){
        Like r = new Like(this,c);
        reactions.add(r);
    }
    
    public void disliker(Contenu<Types> c){
        Dislike r = new Dislike(this,c);
        reactions.add(r);
    }
    
    public void commenter(Contenu<Types> c, String s) {
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
         
}
