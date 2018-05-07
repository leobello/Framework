/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnaouas;

import users.*;
import contenu.*;
import services.Privee;


/**
 *
 * @author near
 */	
public class Gnaouas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        User mouataz = new User("mouataz",22);
        User amine = new User("amine",22);
        User leo = new User("leo", 27);
        User pablo = new User("pablo",21);
        
        mouataz.friendReq(leo);
        pablo.friendReq(leo);
        leo.friendReq(amine);
        amine.friendReq(mouataz);
        amine.friendReq(leo);
        
        // test des friend request
        System.out.println("______________________________");
        leo.getAllFriendRqst();
        leo.printFriend();
        
        
        
        // test sur le partage de contenu
        Contenu<Photo> c = new Contenu<Photo>(new Photo("/usr/bin/a"), leo, new Privee());
        Contenu<Photo> c2 = new Contenu<Photo>(new Photo("/usr/bin/b"), amine, new Privee());
        
                
    } 
    
}
