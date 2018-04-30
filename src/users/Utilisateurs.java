/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;
import contenu.Contenu;
import java.util.ArrayList;
import services.*;

/**
 *
 * @author near
 */
public abstract class Utilisateurs implements _Utilisateurs{
    protected String pseudo;
    protected String password;
    protected ArrayList<_Reactions> reactions;
    protected ArrayList<_Partage> partagePub;
    protected ArrayList<_Partage> partagePriv;
    protected ArrayList<_Utilisateurs> friends;
    protected ArrayList<_Utilisateurs> followed;
    protected ArrayList<_Utilisateurs> followby;
    protected ArrayList<_Utilisateurs> friendrq;
    
    protected boolean admin;
    
    
    public String getName(){return this.pseudo;}
    
    public void setName(String name){
        this.pseudo = name;
    }
    public void friendReq(Utilisateurs user){
        user.friendrq.add(this);
    }
    public _Utilisateurs getFriendReq(int i){return friendrq.get(i);}
    
    public void publierPub(Contenu c){
    	PartagerPublic partage = new PartagerPublic(this, c);
    	
    }
    public void like(Contenu c){
        Like r = new Like(this,c);
        reactions.add(r);
    }
    
    
    
     
}
