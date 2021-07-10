
package Modelo;


public class Usuario {
    
    private int id;
    private String usuario;
    private String pass;
    private int estado;

    public Usuario(int id, String usuario, String pass, int estado) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.estado = estado;
    }
    
     public Usuario(String usuario, String pass, int estado) {
        
        this.usuario = usuario;
        this.pass = pass;
        this.estado = estado;
        
        this.id = -1;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
