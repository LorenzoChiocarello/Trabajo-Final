
package Modelo;


public class Proveedor {
    
    private int idProveedor;
    private String nombre;
    private int cp;
    private String direccion;
    private String telefono;
    private String email;
    private int estado;

    public Proveedor(int idProveedor, String nombre, int cp, String direccion, String telefono, String email, int estado) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.cp = cp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }
    
    public Proveedor(String nombre, int cp, String direccion, String telefono, String email, int estado) {
        this.nombre = nombre;
        this.cp = cp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }

    public Proveedor() {
    }
    
    

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
}
