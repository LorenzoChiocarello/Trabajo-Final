
package Modelo;

import java.util.Date;


public class SaldoClientes {
    private int id;
    private int idCliente;
    private double monto;
    private double resto;
    private String descripcion;
    private String forma_pago;
    private Date fecha;

    public SaldoClientes() {
    }

    public SaldoClientes(int id, int idCliente, double monto, double resto, String descripcion, String forma_pago, Date fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.monto = monto;
        this.resto = resto;
        this.descripcion = descripcion;
        this.forma_pago = forma_pago;
        this.fecha = fecha;
    }
    
    public SaldoClientes(int idCliente, double monto, double resto, String descripcion, String forma_pago, Date fecha) {
        this.idCliente = idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
