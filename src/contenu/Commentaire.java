/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenu;

/**
 *
 * @author near
 */
public class Commentaire extends Types {
    private String comment;
    
    public Commentaire(String comment){
        super.name = this.getClass().getName();
        this.comment = comment;
    }
    public String getComment(){return this.comment;}
}
