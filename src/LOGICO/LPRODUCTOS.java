/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.PRODUCTOS;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LPRODUCTOS implements IProducto{
     public static ArrayList Lprod=new ArrayList(); 
     CallableStatement cc;
     conexion con=new conexion();
     
    @Override 
    public void insertarempleado(PRODUCTOS temp){
        try{
         cc=con.getCon().prepareCall("{call ins_producto(?,?,?,?)}");
            
            cc.setString(1,temp.getNombre());
            cc.setString(2,temp.getDescripcion());
            cc.setDouble(3,temp.getPrecio());
            cc.setInt(4,temp.getCategoria());
            int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Producto Registrado correctamente!!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                }
              
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"ERROR INGRESO EMPLEADO"+ e.getMessage());
        }
    } 

    @Override 
    public void actualizarProducto(PRODUCTOS temp){
        try {
            cc=con.getCon().prepareCall("{call upd_producto(?,?,?,?,?)}");
            cc.setString(1, temp.getCodigo());
            cc.setString(2,temp.getNombre());
            cc.setString(3,temp.getDescripcion());
            cc.setDouble(4,temp.getPrecio());
            cc.setInt(5,temp.getCategoria());
            int respuesta = cc.executeUpdate();
                if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Producto Modificado Correctamente", "Modificando", JOptionPane.INFORMATION_MESSAGE);
                }
        } catch (Exception e) {
             System.err.println("ERROR ACTUALIZAR EMPLEADO"+ e.getMessage());
        }
    }
    
    @Override
    public void eliminarproductos(PRODUCTOS temp){
        try {
            cc=con.getCon().prepareCall("{call DEL_Producto(?)}");
            cc.setString(1, temp.getCodigo());
            int respuesta = cc.executeUpdate();
                if(respuesta == 1){
                    JOptionPane.showMessageDialog(null, "PRODUCTO Eliminado", "Eliminacion", JOptionPane.INFORMATION_MESSAGE);
                }
        } catch (Exception e) {
            System.err.println("ERROR ELIMINAR EMPLEADO"+ e.getMessage());
        }
    }  
    
    @Override
    public void consultarPro(){
        try {
            con.consulta("select * from productos WHERE estado<>0");
            Lprod.clear();
            while (con.getRs().next()) {                                
                PRODUCTOS temp=new PRODUCTOS(
                con.getRs().getString(1),
                con.getRs().getString(2), 
                con.getRs().getString(3),
                Double.parseDouble(con.getRs().getString(4)),
                Integer.parseInt(con.getRs().getString(5)),
                Integer.parseInt(con.getRs().getString(6)),
                con.getRs().getString(7));
                Lprod.add(temp);   
            }
        } catch (Exception e) {
        }
    }
}
