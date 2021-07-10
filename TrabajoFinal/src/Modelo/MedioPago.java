
package Modelo;


public class MedioPago {
    int id;
    String medioPago;

    public MedioPago() {
    }

    public MedioPago(int id, String medioPago) {
        this.id = id;
        this.medioPago = medioPago;
    }
    
    public MedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    
    
    
}
