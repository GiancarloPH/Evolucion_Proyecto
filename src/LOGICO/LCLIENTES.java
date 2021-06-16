/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.CLIENTES;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LCLIENTES implements IClientes{
    public static  ArrayList LCLI=new ArrayList(); 
    conexion con=new conexion();
    private CallableStatement cc;
    @Override
    //insertar clientes
    public void insertarcli(CLIENTES temp){
        try{
          cc=con.getCon().prepareCall("{call ins_cliente(?,?,?,?)}");
             cc.setString(1,temp.getNOMBRE());
             cc.setString(2,temp.getAPELLIDO());
             cc.setString(3,temp.getNACIMIENTO());
             cc.setString(4,temp.getDNI());
             int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
                   JOptionPane.showMessageDialog(null, "cliente ha sio registrado correctamente!!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                } 
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"ERROR INGRESO cliente"+ e.getMessage());
        }
   }
    @Override
    //elimiar cliente
     public void eliminarcliente(CLIENTES temp){
         try {
            cc =con.getCon().prepareCall("{call DEL_Cliente(?)}");
             cc.setString(1, temp.getIDCLIENTE());
             int respuesta= cc.executeUpdate();
                 if (respuesta == 1){
                     JOptionPane.showMessageDialog(null, "cliente eliminado", "Eliminacion", JOptionPane.INFORMATION_MESSAGE);
                 }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR Eliminar cliente"+ e.getMessage());
         }
    }
    @Override
    //actualizar cliente
    public void actualizarcli(CLIENTES temp){
         try {
             cc=con.getCon().prepareCall("{call upd_cliente(?,?,?,?,?)}");
             cc.setString(1, temp.getIDCLIENTE());
             cc.setString(2,temp.getNOMBRE());
             cc.setString(3,temp.getAPELLIDO());
             cc.setString(4,temp.getNACIMIENTO());
             cc.setString(5,temp.getDNI());
              int respuesta = cc.executeUpdate();
                 if (respuesta == 1) {
                 JOptionPane.showMessageDialog(null, "CLIENTE ha sido modificado Correctamente", "Modificando", JOptionPane.INFORMATION_MESSAGE);
                 } 
         } catch (Exception e) {
             System.err.println("ERROR AL ACTUALIZAR CLIENTE"+ e.getMessage());
        } 
    }
    @Override
    //consultar clientes 
    public void consultar(){
        try {
            con.consulta( "select * from listarcliente");
            LCLI.clear();
            while(con.getRs().next()) {                                
                CLIENTES temp=new CLIENTES(con.getRs().getString(1),con.getRs().getString(2), 
                con.getRs().getString(3), con.getRs().getString(4),con.getRs().getString(5));
                LCLI.add(temp);   
            }
        } catch(Exception e) {
        }
    }
}
