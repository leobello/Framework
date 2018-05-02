/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


/**
 *
 * @author near
 */
public class CtrlUser implements _Administration {
    private String password;
    
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
       return this.password;
    }

	
    
}
