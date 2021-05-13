
package LOGICO;

import DATOS.EMPLEADOS;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LEMPLEADO implements IE{
    private CallableStatement cc;
    public static ArrayList LEmp=new ArrayList(); 
    public static ArrayList bbue=new ArrayList(); 
    conexion con=new conexion();
    
    @Override 
      public void insertarempleado(EMPLEADOS temp){
        try{
         cc=con.getCon().prepareCall("{call ins_empleados(?,?,?,?,?,?,?,?,?,?,?)}");
            cc.setString(1,temp.getDNI());
            cc.setString(2,temp.getNombre());
            cc.setString(3,temp.getApellido());
            cc.setString(4,temp.getGenero());
            cc.setString(5,temp.getNacimiento());
            cc.setString(6,temp.getTelefono());
            cc.setString(7,temp.getCorreo());
            cc.setString(8,temp.getDireccion());
            cc.setString(9,temp.getUsuario());
            cc.setString(10,temp.getContraseña());
            cc.setInt(11,temp.getIdcargo());
             int respuesta = cc.executeUpdate();
            if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Empleado Registrado correctamente!!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                }
              
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"ERROR INGRESO EMPLEADO"+ e.getMessage());
        }
    } 
      
    @Override 
    public void eliminarempleados(EMPLEADOS temp){
        try {
            cc=con.getCon().prepareCall("{call DEL_EMPLEADO(?,?)}");
            cc.setString(1, temp.getCodigo());
            cc.setString(2, temp.getUsuario());
            int respuesta = cc.executeUpdate();
                if(respuesta == 1){
                    JOptionPane.showMessageDialog(null, "Empleado Eliminado", "Eliminacion", JOptionPane.INFORMATION_MESSAGE);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR ELIMINAR EMPLEADO"+ e.getMessage());
        }
    }
   /* public void buscarE(String L){
        try {con.consulta(" SELECT * FROM BUSCAREMPLEADO WHERE E='ACTIVO' AND (REGEXP_LIKE( UPPER(N),'48+') "
                + "OR REGEXP_LIKE( UPPER(A),'48+')\n" +
                  "OR REGEXP_LIKE( UPPER(D),'48+') "
                + "OR REGEXP_LIKE( UPPER(U),'48+') OR\n" +
                  "REGEXP_LIKE( UPPER(G),'48+') "
                + "OR REGEXP_LIKE( UPPER(CA),'48+'));");
            bbue.clear();
            while (con.getRs().next()) {   
                EMPLEADOS temp=new EMPLEADOS(
                Integer.parseInt(con.getRs().getString(1)),
                con.getRs().getString(2),
                con.getRs().getString(3), 
                con.getRs().getString(4),
                con.getRs().getString(5), 
                con.getRs().getString(6),
                con.getRs().getString(7), 
                con.getRs().getString(8),
                con.getRs().getString(9),
                con.getRs().getString(10),
                con.getRs().getString(11),
                Integer.parseInt(con.getRs().getString(12)),
                con.getRs().getString(13));
                 bbue.add(temp);   
            }
        } catch (Exception e) {
        }
      
    }*/
    
    @Override
    public void actualizarEmpleado(EMPLEADOS temp){
        try {
            cc=con.getCon().prepareCall("{call upd_EMPLEADO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cc.setString(1, temp.getCodigo());
            cc.setString(2,temp.getDNI());
            cc.setString(3,temp.getNombre());
            cc.setString(4,temp.getApellido());
            cc.setString(5,temp.getGenero());
            cc.setString(6,temp.getNacimiento());
            cc.setString(7,temp.getTelefono());
            cc.setString(8,temp.getCorreo());
            cc.setString(9,temp.getDireccion());
            cc.setString(10,temp.getUsuario());
            cc.setString(11,temp.getContraseña());
            cc.setInt(12,temp.getIdcargo());
            int respuesta = cc.executeUpdate();
                if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Empleado Modificado Correctamente", "Modificando", JOptionPane.INFORMATION_MESSAGE);
                }
            
        } catch (Exception e) {
             System.err.println("ERROR ACTUALIZAR EMPLEADO"+ e.getMessage());
        }
    }
    
    @Override
    public void consultar(){
        try {
            con.consulta("select * from empleados WHERE estado<>0");
            LEmp.clear();
            while (con.getRs().next()) {                                
                EMPLEADOS temp=new EMPLEADOS(
               con.getRs().getString(1),
                con.getRs().getString(2),
                con.getRs().getString(3), 
                con.getRs().getString(4),
                con.getRs().getString(5), 
                con.getRs().getString(6),
                con.getRs().getString(7), 
                con.getRs().getString(8),
                con.getRs().getString(9), 
                con.getRs().getString(10),
                con.getRs().getString(11),
                Integer.parseInt(con.getRs().getString(12)),
                con.getRs().getString(13));
                LEmp.add(temp);   
              //  System.err.println(temp.getNacimiento());
            }
        } catch (Exception e) {
        }
    }
    
}


