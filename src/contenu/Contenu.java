/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenu;

import java.util.ArrayList;
import users._Utilisateurs;

/**
 *
 * @author near
 * @param <T>
 */
public class Contenu<T extends Types>{
    protected T contenu;
    protected _Utilisateurs owner;
    protected ArrayList<_Utilisateurs> likes;
    protected ArrayList<_Utilisateurs> dislikes=new ArrayList<_Utilisateurs>();
    protected ArrayList<Commentaire> commentaires;

    
    
    public Contenu(T contenu ,_Utilisateurs usr ){
        this.contenu = contenu;
        this.owner=usr;
    }
    
    public void like(_Utilisateurs user){
        likes.add(user);        
    }
    public void unLike(_Utilisateurs user){
        likes.remove(user);
    }
    
    public void dislike(_Utilisateurs user){
        dislikes.add(user);
        System.out.println("la "+this.contenu.name.toString()+" de "+this.owner.getName()+" been disliked by :"+user.getName());
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
    
    
}
