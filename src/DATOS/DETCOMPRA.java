
package DATOS;

public class DETCOMPRA {
    private String idcompra;
    private String idproducto;
    private int cantidad;
    private float precioU;
    private float importe;

    public DETCOMPRA() {
         this.idcompra = "";
        this.idproducto = "";
        this.cantidad = 0;
        this.precioU = 0;
        this.importe = 0;
    }

    public DETCOMPRA(String idcompra, String idproducto, int cantidad, float precioU, float importe) {
        this.idcompra = idcompra;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precioU = precioU;
        this.importe = importe;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }

    @Override
    public String toString() {
        return "DETCOMPRA{" + "idcompra=" + idcompra + ", idproducto=" + idproducto + ", cantidad=" + cantidad + ", precioU=" + precioU + ", importe=" + importe + '}';
    }
    
    
}
