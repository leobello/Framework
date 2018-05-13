/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenu;

import java.io.Serializable;

/**
 *
 * @author near
 */
public class Photo extends Types implements Serializable{
    
    public Photo(String path){
        this.name = this.getClass().toString();
        this.path = path;
    }
    
    public String getPath(){return path;}
    
}
