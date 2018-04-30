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
public class PartagerPublic implements _Partage{
	private _Utilisateurs owner;
	
	public PartagerPublic(_Utilisateurs owner) {
		// TODO Auto-generated method stub
		this.owner = owner;
		
	}
	@Override
	public void partager(_Utilisateurs owner, Contenu c) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void suprimer(_Utilisateurs owner, Contenu c) {
		// TODO Auto-generated method stub
		
	}
	
}
