/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class CATEGORIA {
    
    private int codigo;
    private String nombre;
    private String estado;

    public CATEGORIA() {
        this.codigo = 0;
        this.nombre = "";
        this.estado = "";
    }

    
    public CATEGORIA(int codigo, String nombre, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CATEGORIA{" + "codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
    
    
}
