/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

import DATOS.LOGIN;
import FORM.InicioSesion;
import FORM.MenuPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LLOGIN implements ILogin{
    conexion con=new conexion();
    LOGIN lc=new LOGIN();
     
    @Override
    public void login(String usu,String contra){
       try {
            MenuPrincipal s = new MenuPrincipal();
           InicioSesion ni= new InicioSesion();
           
          con.consulta("select * from loginempleado where usuario='"+usu+"' and CONTRASEÑA='"+contra+"' AND ESTADO=1");
          if(con.getRs().next()) {   
               lc.setCodigo(con.getRs().getString(1));
               lc.setDNI(con.getRs().getString(2));
               lc.setNombre(con.getRs().getString(3));
               lc.setApellido(con.getRs().getString(4));
               lc.setGenero(con.getRs().getString(5));
               lc.setNacimiento(con.getRs().getString(6));
               lc.setTelefono(con.getRs().getString(7));
               lc.setCorreo(con.getRs().getString(8));
               lc.setDireccion(con.getRs().getString(9));
               lc.setUsuario(con.getRs().getString(10));
               lc.setContraseña(con.getRs().getString(11));
               lc.setIdcargo(con.getRs().getInt(12));
               lc.setEstado(con.getRs().getString(13));
               lc.setCargo(con.getRs().getString(14));
                s.setVisible(true);
                System.out.println("INGRESO: "+lc.getNombre()+" "+lc.getApellido());
            }
            else{ 
                JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos...\nPor favor, Ingreselos correctamente.");
                 ni.setVisible(true);
          }
        } catch (Exception e) {
            Logger log = Logger.getLogger("MyLog");
            log.log(Level.INFO , "ERROR LOGGER: " + e.getMessage() + " : " + e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null,"ERROR AL INGRESO DE USUARIO"+ e.getMessage());
            }
    }

    
}
