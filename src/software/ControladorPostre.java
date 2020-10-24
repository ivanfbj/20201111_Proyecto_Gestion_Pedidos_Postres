/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import java.util.ArrayList;
public class ControladorPostre {
    ArrayList<Postre>postre;
    
    ControladorPostre(){
        postre=new ArrayList();
    }
    public void setPostres(Postre postres){
        this.postre.add(postres);
    }

    @Override
    public String toString() {
        String cad="la cantidad de postres son\n";
        for (int i = 0; i < postre.size(); i++) 
            cad+=postre.get(i);
            
        return cad;
        
    }
    
}
