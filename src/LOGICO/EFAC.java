/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.EMPLEADOS;


public class EFAC {
    
    IE ie;

    public EFAC(IE ie) {
        this.ie = ie;
    }
    
    public void giancarlo(EMPLEADOS temp){
        ie.actualizarEmpleado(temp);
    }
    
}
