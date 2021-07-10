
package Modelo;

import Gestor.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ClienteDAO {
    
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion enlace = new Conexion();
    
    Cliente c = new Cliente();
    
    public Cliente listarID(int id)
    {
        Cliente c = new Cliente();
        
        String sql="select id, nombre, id_razon_social, cp, cuil, direccion, telefono  from clientes WHERE id=?";
        try 
        {
            con=enlace.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setIdrazonSocial(rs.getInt(3));
                c.setCp(rs.getInt(4));
                c.setCuil(rs.getInt(5));
                c.setDireccion(rs.getString(6));
                c.setTelefono(rs.getString(7));
               
                
            }
                    
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return c;
    }
}
