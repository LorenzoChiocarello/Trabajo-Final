
package Modelo;

import Gestor.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ProveedorDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion enlace = new Conexion();
    
    Proveedor p = new Proveedor();
    
    public Proveedor listarID(int id)
    {
        Proveedor p = new Proveedor();
        
        String sql="select * from proveedores WHERE id=?";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                p.setIdProveedor(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCp(rs.getInt(3));
                p.setDireccion(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setEmail(rs.getString(6));
            }
                    
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return p;
    }
    
    
}
