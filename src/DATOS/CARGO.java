/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class CARGO {
    private int codigo;
    private String nombre;

    public CARGO() {
        this.codigo = 00;
        this.nombre = "";
    }

    public CARGO(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "CARGO{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
    
}
