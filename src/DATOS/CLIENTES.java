/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class CLIENTES {
       private String IDCLIENTE ;
       private String NOMBRE ;
       private String APELLIDO ;
       private String NACIMIENTO ;
       private String DNI ;

    public CLIENTES() {
        this.IDCLIENTE = "";
        this.NOMBRE = "";
        this.APELLIDO = "";
        this.NACIMIENTO = "";
        this.DNI = "";
    }

    public CLIENTES(String IDCLIENTE, String NOMBRE, String APELLIDO, String NACIMIENTO, String DNI) {
        this.IDCLIENTE = IDCLIENTE;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.NACIMIENTO = NACIMIENTO;
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getIDCLIENTE() {
        return IDCLIENTE;
    }

    public void setIDCLIENTE(String IDCLIENTE) {
        this.IDCLIENTE = IDCLIENTE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getNACIMIENTO() {
        return NACIMIENTO;
    }

    public void setNACIMIENTO(String NACIMIENTO) {
        this.NACIMIENTO = NACIMIENTO;
    }

    @Override
    public String toString() {
        return "CLIENTES{" + "IDCLIENTE=" + IDCLIENTE + ", NOMBRE=" + NOMBRE + ", APELLIDO=" + APELLIDO + ", NACIMIENTO=" + NACIMIENTO + ", DNI=" + DNI + '}';
    }
       
       
       
       
}
