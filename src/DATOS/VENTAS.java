/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class VENTAS {
    private String idVenta ;
    private String Fecha;
    private String IdEmpleado; 
    private float ImportTotal; 
    private String idCliente ;
    private String Serie;
    private String Numeracion;

    public VENTAS() {
         this.idVenta = "";
        this.Fecha = "";
        this.IdEmpleado = "";
        this.ImportTotal = 0;
        this.idCliente = "";
    }

    public VENTAS(String idVenta, String Fecha, String IdEmpleado, float ImportTotal, String idCliente) {
        this.idVenta = idVenta;
        this.Fecha = Fecha;
        this.IdEmpleado = IdEmpleado;
        this.ImportTotal = ImportTotal;
        this.idCliente = idCliente;
    }

    public VENTAS(String idVenta, String Fecha, String IdEmpleado, float ImportTotal, String idCliente, String Serie, String Numeracion) {
        this.idVenta = idVenta;
        this.Fecha = Fecha;
        this.IdEmpleado = IdEmpleado;
        this.ImportTotal = ImportTotal;
        this.idCliente = idCliente;
        this.Serie = Serie;
        this.Numeracion = Numeracion;
    }
    
    

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public float getImportTotal() {
        return ImportTotal;
    }

    public void setImportTotal(float ImportTotal) {
        this.ImportTotal = ImportTotal;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getNumeracion() {
        return Numeracion;
    }

    public void setNumeracion(String Numeracion) {
        this.Numeracion = Numeracion;
    }
    
    

    @Override
    public String toString() {
        return "VENTAS{" + "idVenta=" + idVenta + ", Fecha=" + Fecha + ", IdEmpleado=" + IdEmpleado + ", ImportTotal=" + ImportTotal + ", idCliente=" + idCliente + '}';
    }
    
    
    
}
