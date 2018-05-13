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
public abstract class Types implements _Types{
    protected String name;
    protected String path;

    @Override
    public String getType() {
        return this.name;
    }
    public String getPath() { return this.path; }
    
    
    
}
