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
public class ControladorPedido {
    private Pedido pedido[];
    int cont;
    
    ControladorPedido(int n){
        pedido=new Pedido[n];
        cont=0;
    }
    
    public void registrarPedido(String codigoPedido, String fechaPedido, String fechaEntregaPedido,
            Cliente cliente, String lugarDeEntrega, double valorTotal,int p){
        pedido[cont]=new Pedido(codigoPedido, fechaPedido, fechaEntregaPedido,cliente,lugarDeEntrega,valorTotal,p);
        cont++;
        
    }
    public Pedido[] getPedido(){
        return pedido;
    }
    public int getCont(){
        return cont;
    }
}
