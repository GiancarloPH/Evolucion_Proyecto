/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.PROVEEDORES;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LPROVEEDORES implements IProveedores{
    public static  ArrayList Lprovee=new ArrayList(); 
    conexion con=new conexion();
    private CallableStatement cc;
    
    @Override
    public void eliminarproveedor(PROVEEDORES temp){
        try {
            cc=con.getCon().prepareCall("{call DEL_Proveedor(?)}");
            cc.setString(1, temp.getIdproveedor());
            int respuesta = cc.executeUpdate();
                if(respuesta == 1){
                    JOptionPane.showMessageDialog(null, "Empleado Eliminado", "Eliminacion", JOptionPane.INFORMATION_MESSAGE);
                }
        } catch (Exception e) {
            System.err.println("ERROR ELIMINAR EMPLEADO"+ e.getMessage());
        }
    }
    
    @Override
    public void ionsertarproveedor(PROVEEDORES temp){
        try{
         cc=con.getCon().prepareCall("{call ins_proveedores(?,?,?,?,?,?)}");
            cc.setString(1,temp.getRUC());
            cc.setString(2,temp.getNomEmpr());
            cc.setString(3,temp.getNomCont());
            cc.setString(4,temp.getApeCont());
            cc.setString(5,temp.getTelCont());
            cc.setString(6,temp.getDirEmp());
            
             int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "proveedor Registrado correctamente!!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                }
              
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"ERROR INGRESO EMPLEADO"+ e.getMessage());
        }
    } 
    
    @Override
    public void actualizarproveedor(PROVEEDORES temp){
        try {
            cc=con.getCon().prepareCall("{call upd_proveedor(?,?,?,?,?,?,?)}");
            cc.setString(1, temp.getIdproveedor());
            cc.setString(2,temp.getRUC());
            cc.setString(3,temp.getNomEmpr());
            cc.setString(4,temp.getNomCont());
            cc.setString(5,temp.getApeCont());
            cc.setString(6,temp.getTelCont());
            cc.setString(7,temp.getDirEmp());
                int respuesta = cc.executeUpdate();
                if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "proveedor Modificado Correctamente", "Modificando", JOptionPane.INFORMATION_MESSAGE);
                }
            
        } catch (Exception e) {
             System.err.println("ERROR ACTUALIZAR EMPLEADO"+ e.getMessage());
        }
    }
    
    @Override
    public void consultar(){
        try {
            con.consulta("select * from PROVEEDORES WHERE estado<>0");
            Lprovee.clear();
            while (con.getRs().next()) {                                
                PROVEEDORES temp=new PROVEEDORES(
                con.getRs().getString(1),
                con.getRs().getString(2), 
                con.getRs().getString(3),
                con.getRs().getString(4), 
                con.getRs().getString(5),
                con.getRs().getString(6), 
                con.getRs().getString(7),
                con.getRs().getString(8));
                Lprovee.add(temp);   
              
            }
        } catch (Exception e) {
        }
    }
    
}
