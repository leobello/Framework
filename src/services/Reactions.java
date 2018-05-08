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
public abstract class Reactions implements _Reactions {
    protected String name;
    protected Contenu c;
    protected _Utilisateurs user;
    
    public void who() { System.out.println(this.name); }
    public Contenu what() { return this.c; }
    public String getName() { return this.name; }
    
}
