
package Modelo;


public class Vendedor {
    
    private int idVendedor;
    private String nombre;
    private int cp;
    private String direccion;
    private String telefono;
    private int estado;

    public Vendedor() {
    }
    
    

    public Vendedor(int idVendedor, String nombre) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
    }
    
    
    public Vendedor(String nombre, int cp, String direccion, String telefono, int estado) {
        this.nombre = nombre;
        this.cp = cp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
