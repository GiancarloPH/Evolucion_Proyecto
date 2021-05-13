/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class COMPRA {
    private String idcompra;
    private String idproveedor;
    private String fecha;
    private float importTotal;

    public COMPRA() {
        this.idcompra = "";
        this.idproveedor = "";
        this.fecha = "";
        this.importTotal = 0;
    }
    

    public COMPRA(String idcompra, String idproveedor, String fecha, float importTotal) {
        this.idcompra = idcompra;
        this.idproveedor = idproveedor;
        this.fecha = fecha;
        this.importTotal = importTotal;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getImportTotal() {
        return importTotal;
    }

    public void setImportTotal(float importTotal) {
        this.importTotal = importTotal;
    }

    @Override
    public String toString() {
        return "COMPRA{" + "idcompra=" + idcompra + ", idproveedor=" + idproveedor + ", fecha=" + fecha + ", importTotal=" + importTotal + '}';
    }

   
    
}
