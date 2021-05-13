/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.COMPRA;
import DATOS.DETCOMPRA;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LCOMPRAS implements ICompras{
    public static ArrayList Lcompra = new ArrayList();
    conexion con = new conexion();
    private CallableStatement cc;
    

    @Override
    public void insertarcompra(COMPRA temp){
        try{
            cc=con.getCon().prepareCall("{call ins_compra(?,?)}");
            cc.setString(1,temp.getIdproveedor());
            cc.setFloat(2,temp.getImportTotal());
            int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
                 //   JOptionPane.showMessageDialog(null, "compra RegistradA correctamente!!");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR INGRESO COMPRA"+ e.getMessage());
        }
    }
    
    @Override
    public void insertardetcompra(DETCOMPRA det){
        try{
            cc=con.getCon().prepareCall("{call ins_detcompra(?,?,?,?)}");
            cc.setString(1,det.getIdcompra());
            cc.setString(2,det.getIdproducto());
            cc.setFloat(3,det.getCantidad());
            cc.setFloat(4,det.getPrecioU());
            int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
              //  JOptionPane.showMessageDialog(null, "detcompra RegistradA correctamente!!");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR INGRESO detCOMPRA"+ e.getMessage());
        }
    }
    
    @Override
    public void consulta(){
        try {
            con.consulta("select * from COMPRAS");
            Lcompra.clear();
            while (con.getRs().next()) {                                
                COMPRA C=new COMPRA(
                con.getRs().getString(1),
                con.getRs().getString(2),
                con.getRs().getString(3),
                con.getRs().getFloat(4));
                Lcompra.add(C);   
               // System.out.println("CATEGORIAS: "+C.getIdcompra()+" "+C.getIdproveedor());
            }
        } catch (Exception e) {
        }
    }
    
    
}
