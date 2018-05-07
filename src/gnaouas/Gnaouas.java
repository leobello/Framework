/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnaouas;

import users.*;
import contenu.*;


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

        User mouataz = new User("mouataz",22);
        User amine = new User("amine",22);
        amine.friendReq(mouataz);
        Contenu<Photo> c = new Contenu<Photo>(new Photo("usr/bin"), mouataz);
        c.like(amine);
        System.out.println("---- "+amine.getFriendReq(0).getName());
        c.whoLike();
              
      
        
    } 
    
}
