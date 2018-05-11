/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import contenu.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.EmptyStackException;

import services.*;
import sun.invoke.empty.Empty;
import sun.text.normalizer.Trie;

import javax.naming.OperationNotSupportedException;

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
    
    public void commenter(Contenu c, String s) throws OperationNotSupportedException {
        // si le contenu est privée
        Utilisateurs owner;
        owner = (Utilisateurs)c.getUser();
        if(c.getPartage().getClass().toString().equals("services.Privee")){
            if(owner.isFriend(this)){
                Commentaire com = new Commentaire(this, c, s);
                c.addComment(com);
            }else{
                throw new OperationNotSupportedException();

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





    /* renvoi le plus vieux contenue d'une liste */
    static public Contenu getYouger(ArrayList<Contenu> list) {
	   Contenu older;
	   ArrayList<Contenu> timeline = new ArrayList();

        older = list.get(0);
        for(int i = 0 ; i < list.size(); i++) {
            if( older.getDate().compareTo(list.get(i).getDate()) < 0 ) {
			       older = list.get(i);
            }

        }
        return older;
    }

    public ArrayList<Contenu> cleanTimeLine(ArrayList<Contenu> list){
        ArrayList<Contenu> timeline = list;
        ArrayList<Contenu> timeline2 = new ArrayList();
        Contenu c;
        int taille=list.size();
        for (int i = 0; i < taille; i++){
            c = getYouger(list);
            timeline2.add(c);
            timeline.remove(c);
        }
        return timeline2;
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



    public void setPassword(String password) {
        this.password = password;
    }
    public void delContenu(Contenu contenu){
        this.partages.remove(contenu);
    }

}
