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
public class Photo extends Types{
    protected String path;
    
    public Photo(String path){
        super.name = this.getClass().toString();
        this.path = path;
    }
    
    String getPath(){return this.path;}
    void setPath(String path){this.path = path;}
    
}
