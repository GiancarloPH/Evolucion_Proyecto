/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.CLIENTES;

/**
 *
 * @author Crist
 */
public class ClientesFactory {
    IClientes cliente;

    public ClientesFactory(IClientes cliente) {
        this.cliente = cliente;
    }
    
    public void insertarClienteNuevo(CLIENTES temp){
        cliente.insertarcli(temp);
    }
    public void eliminarClienteNuevo(CLIENTES temp){
        cliente.eliminarcliente(temp);
    }
    public void actualizarClienteNuevo(CLIENTES temp){
        cliente.actualizarcli(temp);
    }
    public void consultarClienteNuevo(){
        cliente.consultar();
    }
    
}
