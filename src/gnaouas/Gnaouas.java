/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnaouas;
import contenu.*;
import users.*;



/**
 *
 * @author near
 */
public class Gnaouas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Admin leo = new Admin("leo");
        User mouataz = new User("mouataz",22);
        User amine = new User("amine",22);
        mouataz.friendReq(leo);
        
        
        /*
        Contenu<Photo> photo = new Contenu<Photo>(new Photo("/home/test.jpg"),leo);
        photo.dislike(mouataz);
        */
        
    } 
    
}
