
package Modelo;

import Gestor.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SaldoClienteDAO {
    Connection con;
    Conexion enlace = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    
    int r=0;
    
    public int GuardarSaldoAnticipo(SaldoClientes sc)
    {
        Ventas ventas= new Ventas();
        String sql="INSERT INTO saldos_cliente(id_cliente,monto, resto, descripcion, forma_pago,fecha) VALUES(?,?, 0,?,?,?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, sc.getIdCliente());
            ps.setDouble(2, sc.getMonto());
            ps.setString(3, sc.getDescripcion());
            ps.setString(4, sc.getForma_pago());
            ps.setDate(5, (Date) sc.getFecha());
            
            r=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return r;
    }
    
    public int GuardarSaldoDeuda(SaldoClientes sc)
    {
        Ventas ventas= new Ventas();
        String sql="INSERT INTO saldos_cliente(id_cliente,monto, resto, descripcion, forma_pago, fecha) VALUES(?,0, ?,?,?,?)";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, sc.getIdCliente());
            ps.setDouble(2, sc.getResto());
            ps.setString(3, sc.getDescripcion());
            ps.setString(4, sc.getForma_pago());
            ps.setDate(5, (Date) sc.getFecha());
            
            r=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return r;
    }
}
