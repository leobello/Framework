/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import contenu.*;
import users.Utilisateurs;
import users._Utilisateurs;

/**
 *
 * @author near
 */
public class Privee implements _Partage{
	private _Utilisateurs owner;
	
	public Privee(_Utilisateurs owner) {
		// TODO Auto-generated constructor stub
		this.owner = owner;
	}

	@Override
	public void partager(_Utilisateurs owner, Contenu<Types> c) {
		Utilisateurs user = (Utilisateurs)this.owner;
		c.setPartage(this);
		user.publierPriv(c);
	}

	@Override
	public void suprimer(_Utilisateurs owner, Contenu<Types> c) {
		
		
	}

	

	
	
    
}
