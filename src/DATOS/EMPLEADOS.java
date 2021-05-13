
package DATOS;

public class EMPLEADOS {
    private String codigo;
    private String DNI;
    private String nombre;
    private String apellido;
    private String genero;
    private String nacimiento;
    private String telefono;
    private String correo;
    private String direccion;
    private String usuario;
    private String contraseña;
    private int idcargo;
    private String estado;

    public EMPLEADOS() {
        this.codigo = "";
        this.DNI = "";
        this.nombre = "";
        this.apellido = "";
        this.genero = "";
        this.nacimiento = "";
        this.telefono = "";
        this.correo = "";
        this.direccion = "";
        this.usuario = "";
        this.contraseña = "";
        this.idcargo = 00;
        this.estado = "";
    }

    public EMPLEADOS(String codigo, String DNI, String nombre, String apellido, String genero, String nacimiento, String telefono, String correo, String direccion, String usuario, String contraseña, int idcargo, String estado) {
        this.codigo = codigo;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.idcargo = idcargo;
        this.estado = estado;
       
    }

   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    

    @Override
    public String toString() {
        return "EMPLEADOS{" + "codigo=" + codigo + ", DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", nacimiento=" + nacimiento + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", idcargo=" + idcargo + ", estado=" + estado+ '}';
    }

    
   
    
  
    
    
}
