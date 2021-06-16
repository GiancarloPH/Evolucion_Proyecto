/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.CATEGORIA;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LCATEGORIA implements ICategoria{
    private CallableStatement cc;
     public static ArrayList LCT =new ArrayList(); 
     conexion con = new conexion();
     
    @Override   
    //insertar categoria
    public void insertarcate(CATEGORIA temp){
        try{
         cc=con.getCon().prepareCall("{call ins_categoria(?)}" );
            
            cc.setString(1,temp.getNombre());
            int respuesta= cc.executeUpdate();
            if(respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Categoria Registrada correctamente!!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                }  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR INGRESO CATEGORIA" + e.getMessage());
        }
    } 
    @Override
    //eliminar una categoria
    public void eliminarCATEGORIA(CATEGORIA temp){
        try {
            cc=con.getCon().prepareCall("{call DEL_CateProductos(?)}" );
            cc.setString(1, temp.getNombre());
            int respuesta  = cc.executeUpdate();
                if (respuesta == 1){
                    JOptionPane.showMessageDialog(null, "CATEGORIA Eliminada");
                }
        } catch(Exception e){
           JOptionPane.showMessageDialog (null, "ERROR ELIMINAR CATEGORIA"+ e.getMessage());
        }   }
    @Override
    //consulta de categoria
    public void consultarcategoria(){
        try {
            con.consulta( "select * from categorias where estado<>0");
            LCT.clear();
            while(con.getRs().next()){                                
                CATEGORIA C= new CATEGORIA(con.getRs().getInt(1),con.getRs().getString(2),con.getRs().getString(3));
                LCT.add(C);   
           }
        } catch(Exception e) {
        }
    }
    
}
