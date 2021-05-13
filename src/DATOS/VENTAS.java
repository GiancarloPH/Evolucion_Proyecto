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

    @Override
    public String toString() {
        return "VENTAS{" + "idVenta=" + idVenta + ", Fecha=" + Fecha + ", IdEmpleado=" + IdEmpleado + ", ImportTotal=" + ImportTotal + ", idCliente=" + idCliente + '}';
    }
    
    
    
}
