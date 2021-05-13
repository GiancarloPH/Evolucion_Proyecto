/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.CARGO;
import java.util.ArrayList;

public class LCARGO implements ICargo{
    public static ArrayList Lcarg=new ArrayList(); 
    conexion con=new conexion();
    
    @Override
    public void consultarcargo(){
        try {
            con.consulta("select * from cargos");
            Lcarg.clear();
            while (con.getRs().next()) {                                
                CARGO C=new CARGO(
                con.getRs().getInt(1), 
                con.getRs().getString(2));
                Lcarg.add(C);   
                //System.out.println("cargos: "+C.getNombre()+" "+C.getCodigo());
            }
        } catch (Exception e) {
        }
    }
     
     
}
