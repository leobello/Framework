/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import contenu.Contenu;
import users._Utilisateurs;
/**
 *
 * @author near
 */
public class Like extends Reactions implements _Reactions {
    protected Contenu c;
    protected _Utilisateurs user;
    
    public Like(_Utilisateurs user,Contenu c){
        this.c = c;
        this.c.like(user);
        this.user = user;
        super.name = this.getClass().toString();
        
    }

    @Override
    public String getName() {
        return super.name;
        
    }
    
}
