/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;


import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conexion {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pts;
    private CallableStatement cs;
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usu="GIAN";
    private String cont="1234";
    
     public conexion() {  
       try {
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection(url,usu,cont);
            st=con.createStatement();
           System.out.println("Exito conexion!");
        } catch (Exception e) {
            System.out.println("Fracaso conexion :c");
        }
       
    }
    
    public void consulta(String qry){
        try {
           rs=st.executeQuery(qry);
        } catch (SQLException ioe) {
            System.out.print("error consulta");
            ioe.printStackTrace();
        }
    }
    
//     public void procedimiento(String qry){
//       try {
//           //cs=con.prepareCall(qry2);
//          // pts=con.prepareCall(qry);
//           rs=pts.executeQuery(qry);
//        } catch (SQLException ioe) {
//            System.out.print("error procedimeinto");
//            ioe.printStackTrace();
//        }
//    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPts() {
        return pts;
    }

    public void setPts(PreparedStatement pts) {
        this.pts = pts;
    }

    public CallableStatement getCs() {
        return cs;
    }

    public void setCs(CallableStatement cs) {
        this.cs = cs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    
     
     
     
     
}
