
package Modelo;

import Gestor.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComprasDAO {
    
    Connection con;
    Conexion enlace = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    
    int r=0;
    
    public String NroSerieCompra()
    {
        String serie="";
        String sql="SELECT MAX(numeroSerie) FROM compras";
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
    
    public String IdCompras() throws SQLException
    {
        String idc="";
        String sql="select max(id) from compras";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        
            while(rs.next())
            {
                idc=rs.getString(1);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return idc;
    }
    
    public int GuardarCompras(Compras c)
    {
        Compras compras= new Compras();
        String sql="INSERT INTO compras(id_proveedor, id_forma_pago, monto, numeroSerie,comprobante, fecha) VALUES(?,?,?,?,?,?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getIdProveedor());
            ps.setInt(2, c.getId_formapago());
            ps.setDouble(3, c.getMonto());
            ps.setString(4, c.getNumeroSerie());
            ps.setString(5, c.getComprobante());
            ps.setDate(6, (Date) c.getFecha());
            
            r=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return r;
    }
    
    public int GuardarDetalleCompras(DetalleCompras dc)
    {
        DetalleCompras detalle = new DetalleCompras();
        String sql="INSERT INTO detalles_compra(id_compra, id_articulo, cantidad, importe) VALUES (?,?,?,?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, dc.getIdCompra());
            ps.setInt(2, dc.getIdArticulo());
            ps.setInt(3, dc.getCantidad());
            ps.setDouble(4, dc.getImporte());
            
            r = ps.executeUpdate();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return r;
    }
}
