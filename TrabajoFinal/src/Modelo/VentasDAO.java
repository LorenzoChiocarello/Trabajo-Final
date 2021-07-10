
package Modelo;

import Gestor.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VentasDAO {
    
    Connection con;
    Conexion enlace = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    
    int r=0;
    
    
    
    public String NroSerieVenta()
    {
        String serie="";
        String sql="SELECT MAX(numeroSerie) FROM ventas";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            
            while(rs.next())
            {
                serie=rs.getString(1);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return serie;
    }
    
    public String IdVentas() throws SQLException
    {
        String idv="";
        String sql="select max(id) from ventas";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        
            while(rs.next())
            {
                idv=rs.getString(1);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return idv;
    } 
    
    public int GuardarVentas(Ventas v)
    {
        Ventas ventas= new Ventas();
        String sql="INSERT INTO ventas(id_cliente, id_vendedor,id_forma_pago, monto, numeroSerie, comprobante, fecha) VALUES(?,?,?,?,?,?, ?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setInt(3, v.getId_formapago());
            ps.setDouble(4, v.getMonto());
            ps.setString(5, v.getNumeroSerie());
            ps.setString(6, v.getComprobante());
            ps.setDate(7, (Date) v.getFecha());
            
            r=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return r;
    }
    
    public int GuardarDetalleVentas(DetalleVentas dv)
    {
        DetalleVentas detalle = new DetalleVentas();
        String sql="INSERT INTO detalles_venta(id_articulo, id_venta, cantidad, importe) VALUES (?,?,?,?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, dv.getIdArticulo());
            ps.setInt(2, dv.getIdVenta());
            ps.setDouble(3, dv.getCantidad());
            ps.setDouble(4, dv.getImporte());
            
            r = ps.executeUpdate();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return r;
    }
    
    
}
