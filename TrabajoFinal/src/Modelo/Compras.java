
package Modelo;

import java.util.Date;


public class Compras {
    
    private int id;
    private int idProveedor;
    private int id_formapago;
    private double monto;
    private String numeroSerie;
    private String comprobante;
    private Date fecha;

    public Compras() {
    }

    public Compras(int id, int idProveedor, int id_formapago, double monto, String numeroSerie, String comprobante, Date fecha) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.id_formapago = id_formapago;
        this.monto = monto;
        this.numeroSerie = numeroSerie;
        this.comprobante = comprobante;
        this.fecha = fecha;
    }
    
    public Compras(int idProveedor, int id_formapago, double monto, String numeroSerie, String comprobante, Date fecha) {
        this.idProveedor = idProveedor;
        this.id_formapago = id_formapago;
        this.monto = monto;
        this.numeroSerie = numeroSerie;
        this.comprobante = comprobante;
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

    public int getId_formapago() {
        return id_formapago;
    }

    public void setId_formapago(int id_formapago) {
        this.id_formapago = id_formapago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
    

    
    
    
    
    
}
