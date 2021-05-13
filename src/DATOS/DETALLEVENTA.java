/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class DETALLEVENTA {
    
    private String idVenta;
    private String idProducto; 
    private int Cantidad;
    private float precio;
    private float Importe;

    public DETALLEVENTA() {
          this.idVenta = "";
        this.idProducto = "";
        this.Cantidad = 0;
        this.precio = 0;
        this.Importe = 0;
    }

    
    
    public DETALLEVENTA(String idVenta, String idProducto, int Cantidad, float precio, float Importe) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.precio = precio;
        this.Importe = Importe;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float Importe) {
        this.Importe = Importe;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DETALLEVENTA{" + "idVenta=" + idVenta + ", idProducto=" + idProducto + ", Cantidad=" + Cantidad + ", precio=" + precio + ", Importe=" + Importe + '}';
    }
    
    
    
}
