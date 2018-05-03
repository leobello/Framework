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
public class Dislike extends Reactions implements _Reactions {
	protected Contenu<Types> c;
	protected _Utilisateurs user;

	public Dislike(_Utilisateurs user, Contenu<Types> c) {
		this.c = c;
		this.c.like(user);
		this.user = user;
		super.name = this.getClass().toString();

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.name;
	}

}
