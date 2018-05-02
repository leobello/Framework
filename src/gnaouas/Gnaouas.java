/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnaouas;

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

        Admin leo = new Admin("leo","toto");
        User mouataz = new User("mouataz",22);
        User amine = new User("amine",22);
        amine.friendReq(leo);
        mouataz.friendReq(leo);
        
      
        
    } 
    
}
