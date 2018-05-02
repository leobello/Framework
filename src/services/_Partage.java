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
public interface _Partage {
    public void partager(_Utilisateurs owner, Contenu<Types> c);
    public void suprimer(_Utilisateurs owner, Contenu<Types> c);

}
