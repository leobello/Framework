/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author near
 */
public interface _Utilisateurs extends Remote{
    public String getName() throws RemoteException;
    public String getPassword()throws RemoteException ;
    public void setName(String name) throws RemoteException;
    //public void liker();
    //public void disliker();
    //public void commenter();
    //public void getContenu();
    //public void publier();
    
}
