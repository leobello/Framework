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
    protected ArrayList<_Utilisateurs> dislikes;
    protected ArrayList<Commentaire> commentaires;

    
    
    
	public Contenu(T c){
        this.contenu = c;
    }
    
    public void like(_Utilisateurs user){
        likes.add(user);        
    }
    public void unLike(_Utilisateurs user){
        likes.remove(user);
    }
    
    public void dislike(_Utilisateurs user){
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
    
    public Types getContenu() { return this.contenu; }
    
    public String getType() { return this.contenu.getType(); }
    
    
}
