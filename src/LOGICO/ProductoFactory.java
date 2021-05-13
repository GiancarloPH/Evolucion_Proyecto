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
public class ProductoFactory {
    
    IProducto producto;

    public ProductoFactory(IProducto producto) {
        this.producto = producto;
    }
    
    public void insertarProductoNuevo(PRODUCTOS temp){
        producto.insertarempleado(temp);
    }
    public void actualizarProductoNuevo(PRODUCTOS temp){
        producto.actualizarProducto(temp);
    }
    public void eliminarProductosNuevo(PRODUCTOS temp){
        producto.eliminarproductos(temp);
    }
    public void consultarProductoNuevo(){
        producto.consultarPro();
    }
    
}
