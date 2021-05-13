/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class PROVEEDORES {
    private String idproveedor;
    private String RUC;
    private String nomEmpr;
    private String nomCont;
    private String apeCont;
    private String telCont;
    private String dirEmp;
    private String estado;

    public PROVEEDORES() {
        this.idproveedor = "";
        this.RUC = "";
        this.nomEmpr = "";
        this.nomCont = "";
        this.apeCont = "";
        this.telCont = "";
        this.dirEmp = "";
        this.estado = "";
    }

    
    public PROVEEDORES(String idproveedor, String RUC, String nomEmpr, String nomCont, String apeCont, String telCont, String dirEmp, String estado) {
        this.idproveedor = idproveedor;
        this.RUC = RUC;
        this.nomEmpr = nomEmpr;
        this.nomCont = nomCont;
        this.apeCont = apeCont;
        this.telCont = telCont;
        this.dirEmp = dirEmp;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNomEmpr() {
        return nomEmpr;
    }

    public void setNomEmpr(String nomEmpr) {
        this.nomEmpr = nomEmpr;
    }

    public String getNomCont() {
        return nomCont;
    }

    public void setNomCont(String nomCont) {
        this.nomCont = nomCont;
    }

    public String getApeCont() {
        return apeCont;
    }

    public void setApeCont(String apeCont) {
        this.apeCont = apeCont;
    }

    public String getTelCont() {
        return telCont;
    }

    public void setTelCont(String telCont) {
        this.telCont = telCont;
    }

    public String getDirEmp() {
        return dirEmp;
    }

    public void setDirEmp(String dirEmp) {
        this.dirEmp = dirEmp;
    }

    @Override
    public String toString() {
        return "PROVEEDORES{" + "idproveedor=" + idproveedor + ", RUC=" + RUC + ", nomEmpr=" + nomEmpr + ", nomCont=" + nomCont + ", apeCont=" + apeCont + ", telCont=" + telCont + ", dirEmp=" + dirEmp + ", estado=" + estado + '}';
    }
    
    
    
}
