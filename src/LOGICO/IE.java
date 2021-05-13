/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.EMPLEADOS;

/**
 *
 * @author Crist
 */
public interface IE {
    
    public void insertarempleado(EMPLEADOS temp);
    public void eliminarempleados(EMPLEADOS temp);
    public void actualizarEmpleado(EMPLEADOS temp);
    public void consultar();
    
}
