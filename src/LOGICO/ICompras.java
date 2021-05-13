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
public interface ICompras {
    public void insertarcompra(COMPRA temp);
    public void insertardetcompra(DETCOMPRA det);
    public void consulta();
    
}
