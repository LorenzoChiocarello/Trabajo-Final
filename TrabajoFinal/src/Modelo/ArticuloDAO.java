
package Modelo;
import Gestor.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class ArticuloDAO {
    
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion enlace = new Conexion();
    Articulo ar = new Articulo();
    
    public Articulo listarID(int codigo)
    {
        Articulo a = new Articulo();
        
        String sql="select * from articulos WHERE codigo=?";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs=ps.executeQuery();
            while(rs.next())
            {
                a.setCodigo(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setPrecioCompra(rs.getDouble(3));
                a.setPrecioVenta(rs.getDouble(4));
                a.setStock(rs.getInt(5));
                a.setStockMinimo(rs.getInt(6));
                
            }
                    
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return a;
    }
    
    public int actualizarStock(int cantidad, int idp)
    {
        String sql="UPDATE articulos SET stock=? where codigo=?";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1,cantidad);
            ps.setInt(2, idp);
            ps.executeUpdate();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return r;
    }
    
}
