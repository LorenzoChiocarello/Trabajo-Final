
package Modelo;


public class RazonSocial {
    private int id;
    private String razonSocial;

    public RazonSocial(int id, String razonSocial) {
        this.id = id;
        this.razonSocial = razonSocial;
    }
    
    public RazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString() {
        return razonSocial ;
    }
    
    
    
    
}
