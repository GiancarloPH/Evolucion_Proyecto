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
public class VentasFactory {
    
    IVentas ventas;

    public VentasFactory(IVentas ventas) {
        this.ventas = ventas;
    }
    
    public void insertarVentaNuevo(VENTAS temp){
        ventas.insertarventa(temp);
    }
    public void insertardetVentaNuevo(DETALLEVENTA det){
        ventas.insertardetVENTA(det);
    }
    public void consultaVentaNuevo(){
        ventas.consulta();
    }
    
}
