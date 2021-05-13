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
public class EmpleadoFactory {
    IE empleado;

    public EmpleadoFactory(IE empleado) {
        this.empleado = empleado;
    }
    
    public void insertarEmpleadoNuevo(EMPLEADOS temp){
        empleado.insertarempleado(temp);
    }
    public void actualizarEmpleadoNuevo(EMPLEADOS temp){
        empleado.actualizarEmpleado(temp);
    }
    public void eliminarEmpleadoNuevo(EMPLEADOS temp){
        empleado.eliminarempleados(temp);
    }
    public void consultarEmpleadoNuevo(){
        empleado.consultar();
    }
    
}
