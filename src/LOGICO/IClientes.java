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
public interface IClientes {
    public void insertarcli(CLIENTES temp);
    public void eliminarcliente(CLIENTES temp);
    public void actualizarcli(CLIENTES temp);
    public void consultar();
    
}
