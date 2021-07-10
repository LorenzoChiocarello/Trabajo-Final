
package Modelo;

import Gestor.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SaldoProveedorDAO {
    
    Connection con;
    Conexion enlace = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    
    int r=0;
    
    
    public int GuardarSaldoAnticipo(SaldoProveedores sa)
    {
        Ventas ventas= new Ventas();
        String sql="INSERT INTO saldos_proveedor(id_proveedor,monto, resto, descripcion, forma_pago, fecha) VALUES(?,?, 0,?,?,?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, sa.getIdProveedor());
            ps.setDouble(2, sa.getMonto());
            ps.setString(3, sa.getDescripcion());
            ps.setString(4, sa.getForma_pago());
            ps.setDate(5, (Date) sa.getFecha());
            
            r=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return r;
    }
    
    public int GuardarSaldoDeuda(SaldoProveedores sd)
    {
        Ventas ventas= new Ventas();
        String sql="INSERT INTO saldos_proveedor(id_proveedor,monto, resto, descripcion, forma_pago, fecha) VALUES(?,0, ?,?,?,?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, sd.getIdProveedor());
            ps.setDouble(2, sd.getResto());
            ps.setString(3, sd.getDescripcion());
            ps.setString(4, sd.getForma_pago());
            ps.setDate(5, (Date) sd.getFecha());
            
            r=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return r;
    }
}
