/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnaouas;
import contenu.*;

import users.User;


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
        User leo = new User("leo","123456789",27);
        User mouataz = new User("mouataz","12456789",22);
        // 
        leo.friendReq(mouataz);
        Contenu<Photo> photo = new Contenu<Photo>(new Photo("/home/test.jpg"));
        photo.dislike(mouataz);
        
    } 
    
}
