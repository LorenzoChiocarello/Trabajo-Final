
package Modelo;


public class DetalleCompras {
   
    int id;
    int idCompra;
    int idArticulo;
    int cantidad;
    double importe;

    public DetalleCompras() {
    }

    public DetalleCompras(int id, int idCompra, int idArticulo, int cantidad, double importe) {
        this.id = id;
        this.idCompra = idCompra;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.importe = importe;
    }
    
    public DetalleCompras(int idCompra, int idArticulo, int cantidad, double importe) {
        this.idCompra = idCompra;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
    
    
    
}
