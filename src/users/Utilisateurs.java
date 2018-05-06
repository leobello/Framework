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
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String pseudo;
    protected String password;
    protected ArrayList<_Reactions> reactions;
    protected ArrayList<_Partage> partagePub;
    protected ArrayList<_Partage> partagePriv;
    protected ArrayList<_Utilisateurs> friends;
    protected ArrayList<_Utilisateurs> followed;
    protected ArrayList<_Utilisateurs> followby;  
    protected boolean admin;
    
    
    public Utilisateurs() {
    		this.reactions = new ArrayList<_Reactions>();
    		this.partagePub = new ArrayList<_Partage>();
    		this.friends = new ArrayList<_Utilisateurs>();
    		this.followed = new ArrayList<_Utilisateurs>();
    		this.followby= new ArrayList<_Utilisateurs>();  		
    }
        
    public String getName(){return this.pseudo;}
    public String getPassword(){return this.password;}
    
    public void setName(String name){
        this.pseudo = name;
    }
    

    public void publierPub(Contenu<Types> c){
    		Public partage = new Public(this);
    		partagePub.add(partage);    	
    }
    
    public void publierPriv(Contenu<Types> c){
		Privee partage = new Privee(this);
		partagePriv.add(partage);    	
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
    
         
}
