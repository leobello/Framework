/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import contenu.Contenu;
import users._Utilisateurs;

//import contenu.*;

/**
 *
 * @author near
 */
public class Public extends Partage{
	_Utilisateurs owner;
	Contenu c;
	public Public(_Utilisateurs owner, Contenu c ) {
		// TODO Auto-generated method stub
		this.owner = owner;
		this.c = c;
	}
		
}
