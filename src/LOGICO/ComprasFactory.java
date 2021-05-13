/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.COMPRA;
import DATOS.DETCOMPRA;

/**
 *
 * @author Crist
 */
public class ComprasFactory {
    
    ICompras compras;

    public ComprasFactory(ICompras compras) {
        this.compras = compras;
    }
    
    public void insertarCompraNuevo(COMPRA temp){
        compras.insertarcompra(temp);
    }
    public void insertarDetCompraNuevo(DETCOMPRA det){
        compras.insertardetcompra(det);
    }
    public void consultaComprasNuevo(){
        compras.consulta();
    }
    
}
