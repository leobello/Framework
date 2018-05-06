/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenu;

import java.util.ArrayList;

import services._Partage;
import users.*;


/**
 *
 * @author near
 * @param <T>
 */
public class Contenu<T extends Types>{
    protected T contenu;
    protected _Utilisateurs owner;
    protected ArrayList<_Utilisateurs> likes;
    protected ArrayList<_Utilisateurs> dislikes;
    protected ArrayList<Commentaire> commentaires;
    protected _Partage partage;
    
    public Contenu(T c) {
		this.contenu = c;
		this.likes = new ArrayList<_Utilisateurs>();
		this.dislikes = new ArrayList<_Utilisateurs>();
		this.commentaires = new ArrayList<Commentaire>();
		
	}

	public Contenu(T c, _Utilisateurs user) {
		this.contenu = c;
		this.owner = user;
		this.likes = new ArrayList<_Utilisateurs>();
		this.dislikes = new ArrayList<_Utilisateurs>();
		this.commentaires = new ArrayList<Commentaire>();
		
	}
	
	public void setUser(_Utilisateurs user) { this.owner = user; }
	public _Utilisateurs getUser() { return this.owner; }
    
	public Types getContenu() { return this.contenu; }
    public void setContenu(T type) { this.contenu = type; }
    

    
    @SuppressWarnings("unchecked")
	public void like(_Utilisateurs user){
    		Utilisateurs user2 = (Utilisateurs)user;
    		user2.liker((Contenu<Types>)this);
    		likes.add(user);    		
    }
    
 
	public void unLike(_Utilisateurs user){  	
    		likes.remove(user);
    }
    
    @SuppressWarnings("unchecked")
	public void dislike(_Utilisateurs user){
    		Utilisateurs user2 = (Utilisateurs)user;
		user2.disliker((Contenu<Types>)this);    	
        dislikes.add(user);
    }
    
    public void unDislike(_Utilisateurs user){
        dislikes.remove(user);        
    }
    
    public int nbLike(){
        return this.likes.size();
    }
    
    public int nbDislike(){
        return this.dislikes.size();
    }
    
    public int nbComment(){
        return this.commentaires.size();
    }
    
    public ArrayList<_Utilisateurs> getLike(){
        return this.likes;
    }
    
    public ArrayList<_Utilisateurs> getDislike(){
        return this.dislikes;
    }
    
    public ArrayList<Commentaire> getComment(){
        return this.commentaires;
    }
    
    
    public String getType() { return this.contenu.getType(); }
    
    public _Partage getPartage() { return this.partage;}
    public void setPartage(_Partage p) { this.partage = p; }
    
    public void whoLike() {
    		for(_Utilisateurs user : this.likes) {
    			System.out.println(user.getName());
    		}
    }
    
    public void whoDislike() {
		for(_Utilisateurs user : this.dislikes) {
			System.out.println(user.getName());
		}
    }
    
    public void addComment(Commentaire c) { this.commentaires.add(c); }
    public void removeComment(Commentaire c) { this.commentaires.remove(c); }
    
    public void printComment() {
    		for(Commentaire c : this.commentaires) {
    			System.out.println(c.getComment());
    		}
    }
    
    
    
    
}
