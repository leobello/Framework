/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenu;

import users.*;
/**
 *
 * @author near
 */
public class Commentaire extends Types {
    
	private Contenu contenu;
	private String comment;
	private _Utilisateurs user;
    
    
	public Commentaire() { super.name = this.getClass().getName(); }
	

    
    public Commentaire(_Utilisateurs user, String comment){
        this();
        this.comment = comment;
        this.user = user;
    }
    
    public Commentaire(_Utilisateurs user, Contenu c, String comment){
        super.name = this.getClass().getName();
        this.comment = comment;
        this.user = user;
        this.contenu = c;
    }
   
    public _Utilisateurs getUser(){ return this.user; }
    public void setUser(_Utilisateurs user) { this.user = user; }
    
    public String getComment(){ return this.comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Contenu getContenu(){ return this.contenu; }
    public void setContenu(Contenu c) { this.contenu = c; }
}
