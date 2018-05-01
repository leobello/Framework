/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import contenu.Contenu;
import contenu.Types;
import users.*;

/**
 *
 * @author near
 */
public class Public implements _Partage{
	private _Utilisateurs owner;
	

	public Public(_Utilisateurs owner) {
		// TODO Auto-generated method stub
		this.owner = owner;
	}
	
	@Override
	public void partager(_Utilisateurs owner, Contenu<Types> c) {
		// TODO Auto-generated method stub
		Utilisateurs user = (Utilisateurs)this.owner;
		c.setPartage(this);
		user.publierPub(c);
	}

	@Override
	public void suprimer(_Utilisateurs owner, Contenu<Types> c) {
		// TODO Auto-generated method stub
		
	}
	
	
}
