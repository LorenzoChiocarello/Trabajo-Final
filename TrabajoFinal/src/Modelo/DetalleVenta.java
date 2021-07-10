
package Modelo;


public class DetalleVenta {
    
    private int id;
    private int idArticulo;
    private int idVenta;
    private double cantidad;
    private double importe;

    public DetalleVenta(int id, int idArticulo, int idVenta, double cantidad, double importe) {
        this.id = id;
        this.idArticulo = idArticulo;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.importe = importe;
    }
    
    public DetalleVenta( int idArticulo, int idVenta, double cantidad, double importe) {
        this.idArticulo = idArticulo;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
    
    
    
    
}
