/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import contenu.Contenu;
import contenu.Types;
import users._Utilisateurs;

/**
 *
 * @author near
 */
public class Dislike extends Reactions implements _Reactions{

	public Dislike(_Utilisateurs user, Contenu<Types> c){
        this.c = c;
        this.user = user;
        
    }
	
	
}
