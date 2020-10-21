/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

/**
 *
 * @author FEDERICO
 */
public class ControladorCliente {
       private Cliente cliente[];
    int cont;
    
    
    ControladorCliente(int n){
        cliente=new Cliente[n];
        cont=0;
    }
    public void registrarCliente(String nombre,String nom, String direccion, int telefono, String sexo, int edad){
     cliente[cont]=new Cliente(nombre,direccion,  telefono, sexo,  edad);
     cont++;
    }
    public Cliente[]getCliente(){
        return cliente;
        
    }
    public int getCont(){
        return cont;
    }
 
}
