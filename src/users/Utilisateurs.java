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
    protected Photo photoDeProfile;
    protected ArrayList<_Reactions> reactions;
    protected ArrayList<Contenu> partages;
    protected ArrayList<_Utilisateurs> friends;
    protected ArrayList<_Utilisateurs> followed;
    protected ArrayList<_Utilisateurs> follow;
    protected boolean admin;
    
    
    public Utilisateurs() {
    		this.reactions = new ArrayList<_Reactions>();
    		this.partages = new ArrayList<Contenu>();
    		this.friends = new ArrayList<_Utilisateurs>();
    		this.followed = new ArrayList<_Utilisateurs>();
    		this.follow= new ArrayList<_Utilisateurs>();
    }
    
    
    
        
    public String getName(){return this.pseudo;}
    public String getPassword(){return this.password;}
    public void setPhotoDeProfile(Photo photoDeProfile){this.photoDeProfile = photoDeProfile;}
    public Photo getPhotoDeProfile(){return this.photoDeProfile;}

    
    public void setName(String name){
        this.pseudo = name;
    }
    
    public ArrayList<Contenu> getPartages(){ return this.partages; }
    

    public void publier(Contenu c){
    		this.partages.add(c);    	
    }
    public void suprimer(Contenu contenu) {this.reactions.remove(contenu);}
    
   
    public void liker(Contenu c){
        Like r = new Like(this,c);
        reactions.add(r);
    }
    
    public void disliker(Contenu c){
        Dislike r = new Dislike(this,c);
        reactions.add(r);
    }
    
    public void commenter(Contenu c, String s) {
        // si le contenu est privée
        Utilisateurs owner;
        owner = (Utilisateurs)c.getUser();
        if(c.getPartage().getClass().toString().equals("services.Privee")){
            if(owner.isFriend(this)){
                Commentaire com = new Commentaire(this, c, s);
                c.addComment(com);
            }else{
                System.out.println("vous n'etes pas ami avec le propiétaire");
            }
        }else{
            Commentaire com = new Commentaire(this, c, s);
            c.addComment(com);
        }
    }
    
    public void beFriend(_Utilisateurs u) {
    		this.friends.add(u);
    }
    
    public void printFriend() {
    		for(_Utilisateurs u : this.friends) {
    			System.out.println(u.getName());
    		}
    }

    public boolean isFriend(_Utilisateurs friend){
        return this.friends.contains(friend);
    }

    public void follow(_Utilisateurs user){
        this.follow.add(user);
        Utilisateurs u2 = (Utilisateurs)user;
        u2.followed(this);
    }


    public void unFollow(_Utilisateurs user){
        this.follow.remove(user);
        Utilisateurs u2 = (Utilisateurs)user;
        u2.unfollowed(this);
    }

    public void followed(_Utilisateurs user){
        this.followed(user);
    }

    public void unfollowed(_Utilisateurs user){
        followed.remove(user);
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

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void delContenu(Contenu contenu){
        this.partages.remove(contenu);
    }



}
