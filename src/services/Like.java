/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import contenu.*;
import users._Utilisateurs;
/**
 *
 * @author near
 */
public class Like extends Reactions implements _Reactions {
    
	
    public Like(_Utilisateurs user,Contenu c){
        this.c = c;
        this.user = user;
        
    }
    
    
}
