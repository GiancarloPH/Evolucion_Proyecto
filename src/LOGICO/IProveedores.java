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
public interface IProveedores {
    public void eliminarproveedor(PROVEEDORES temp);
    public void ionsertarproveedor(PROVEEDORES temp);
    public void actualizarproveedor(PROVEEDORES temp);
    public void consultar();
    
}
