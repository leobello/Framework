/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnaouas;

import users.*;
import contenu.*;
import services.Privee;

import java.util.ArrayList;
import java.util.Scanner;


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
        //User pablo = new User("pablo",21);
        
        mouataz.friendReq(leo);
        amine.friendReq(leo);
        //pablo.friendReq(leo);
        //leo.friendReq(amine);
        //amine.friendReq(mouataz);

        
        // test des friend request
        System.out.println("______________________________");
        leo.getAllFriendRqst();
        System.out.println("amis de léo: ");
        leo.printFriend();
        System.out.println("amis de mouataz: ");
        mouataz.printFriend();
        
        
        // test sur le partage de contenu
        Contenu c = new Contenu(new Photo("/usr/bin/a"), amine, new Privee());
        amine.publier(c);
        System.out.println("nb publication amine: "+amine.getPartages().size());
        Contenu c2 = new Contenu(new Photo("/usr/bin/b"), mouataz, new Privee());
        Contenu c3 = new Contenu(new Photo("/usr/bin/b"), mouataz, new Privee());


        mouataz.publier(c2);
        System.out.println(leo.getTimeline().size()+" contenu dans la timeline");
        System.out.println("publié par: "+leo.getTimeline().get(0).getUser().getName());
        //leo.commenter(c2,"hahaha trop moche ta photo");
        c2.printComment();
        System.out.println(c2.getPartage().getClass().getName());

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        ArrayList<Contenu> list = new ArrayList<>();
        while(i<3){
            list.add(new Contenu(new Photo(""),leo,new Privee()));
            i = sc.nextInt();
        }
        list.add(c);
        list.add(c3);
        for(Contenu d : list){
            System.out.println(d.getDate().toString());
        }
        ArrayList<Contenu> list2 = leo.cleanTimeLine(list);
        System.out.println("------------------------------");
        for(Contenu d : list2){
            System.out.println(d.getDate().toString());
        }
                
    } 
    
}
