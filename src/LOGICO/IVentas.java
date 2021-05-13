/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.DETALLEVENTA;
import DATOS.VENTAS;

/**
 *
 * @author Crist
 */
public interface IVentas {
    
    public void insertarventa(VENTAS temp);
    public void insertardetVENTA(DETALLEVENTA det);
    public void consulta();
    
}
