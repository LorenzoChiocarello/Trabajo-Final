
package Modelo;


public class Cliente {
    
    private int idCliente;
    private String nombre;
    private int idrazonSocial;
    private int cp;
    private double cuil;
    private String direccion;
    private String telefono;
    private int estado;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, int idrazonSocial, int cp, double cuil,String direccion, String telefono, int estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.idrazonSocial = idrazonSocial;
        this.cp = cp;
        this.cuil = cuil;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }
    
    public Cliente(String nombre, int idrazonSocial, int cp, double cuil, String direccion, String telefono, int estado) {
        this.nombre = nombre;
        this.idrazonSocial = idrazonSocial;
        this.cp = cp;
        this.cuil = cuil;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdrazonSocial() {
        return idrazonSocial;
    }

    public void setIdrazonSocial(int idrazonSocial) {
        this.idrazonSocial = idrazonSocial;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public double getCuil() {
        return cuil;
    }

    public void setCuil(double cuil) {
        this.cuil = cuil;
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
