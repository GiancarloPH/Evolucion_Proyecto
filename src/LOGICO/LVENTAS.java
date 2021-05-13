/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.DETALLEVENTA;
import DATOS.VENTAS;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LVENTAS implements IVentas{
    
    public static  ArrayList Lventa=new ArrayList(); 
    conexion con=new conexion();
    private CallableStatement cc;
    
    @Override
    public void insertarventa(VENTAS temp){
        try{
            cc=con.getCon().prepareCall("{call ins_venta(?,?,?)}");
            cc.setString(1,temp.getIdEmpleado());
            cc.setFloat(2,temp.getImportTotal());
            cc.setString(3,temp.getIdCliente());
            int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
                 //   JOptionPane.showMessageDialog(null, "compra RegistradA correctamente!!");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR INGRESO VENTA"+ e.getMessage());
        }
    } 
    
    @Override
    public void insertardetVENTA(DETALLEVENTA det){
        try{
            cc=con.getCon().prepareCall("{call ins_detventa(?,?,?,?)}");
            cc.setString(1,det.getIdVenta());
            cc.setString(2,det.getIdProducto());
            cc.setInt(3,det.getCantidad());
            cc.setFloat(4,det.getPrecio());
            int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
              //  JOptionPane.showMessageDialog(null, "detcompra RegistradA correctamente!!");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR INGRESO detVENTA"+ e.getMessage());
        }
    } 
    
    @Override
    public void consulta(){
        try {
            con.consulta("select * from VENTAS");
            Lventa.clear();
            while (con.getRs().next()) {                                
                VENTAS v=new VENTAS(
                con.getRs().getString(1),
                con.getRs().getString(2),
                con.getRs().getString(3),
                con.getRs().getFloat(4),
                con.getRs().getString(5));
                 Lventa.add(v);   
               // System.out.println("CATEGORIAS: "+C.getIdcompra()+" "+C.getIdproveedor());
            }
        } catch (Exception e) {
        }
    }
    
    
    
}
