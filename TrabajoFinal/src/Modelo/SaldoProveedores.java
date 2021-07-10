
package Modelo;

import java.util.Date;


public class SaldoProveedores {
    
    
    private int id;
    private int idProveedor;
    private double monto;
    private double resto;
    private String descripcion;
    private String forma_pago;
    private Date fecha;

    public SaldoProveedores() {
    }

    public SaldoProveedores(int id, int idProveedor, double monto, double resto, String descripcion, String forma_pago, Date fecha) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.monto = monto;
        this.resto = resto;
        this.descripcion = descripcion;
        this.forma_pago = forma_pago;
        this.fecha = fecha;
    }
    
    public SaldoProveedores(int idProveedor, double monto, double resto, String descripcion, String forma_pago, Date fecha) {
        this.idProveedor = idProveedor;
        this.monto = monto;
        this.resto = resto;
        this.descripcion = descripcion;
        this.forma_pago = forma_pago;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getResto() {
        return resto;
    }

    public void setResto(double resto) {
        this.resto = resto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
}
