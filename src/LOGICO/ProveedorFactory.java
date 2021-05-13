/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.PROVEEDORES;

/**
 *
 * @author Crist
 */
public class ProveedorFactory {
    
    IProveedores proveedores;

    public ProveedorFactory(IProveedores proveedores) {
        this.proveedores = proveedores;
    }
    
    public void eliminarProveedorNuevo(PROVEEDORES temp){
        proveedores.eliminarproveedor(temp);
    }
    public void insertarProveedorNew(PROVEEDORES temp){
        proveedores.ionsertarproveedor(temp);
    }
    public void actualizarProveedorNew(PROVEEDORES temp){
        proveedores.actualizarproveedor(temp);
    }
    public void consultarProveedorNew(){
        proveedores.consultar();
    }
    
}
