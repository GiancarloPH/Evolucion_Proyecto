/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.PRODUCTOS;

/**
 *
 * @author Crist
 */
public interface IProducto {
    public void insertarempleado(PRODUCTOS temp);
    public void actualizarProducto(PRODUCTOS temp);
    public void eliminarproductos(PRODUCTOS temp);
    public void consultarPro();
    
}
