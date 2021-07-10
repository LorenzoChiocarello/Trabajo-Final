
package Gestor;

import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.MedioPago;
import Modelo.RazonSocial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestorDB {
    
    private String CONN = "jdbc:sqlserver://DESKTOP-QO3CRMK:1433;databaseName=TrabajoFinal";
    private String USER = "sa";
    private String PASS = "123456789";
    
    public void agregarCliente(Cliente cliente)
    {
        try
        {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO clientes VALUES (?,?,?, ?, ?, ?, 1)");
            
            pstmt.setString(1, cliente.getNombre());
            pstmt.setInt(2, cliente.getIdrazonSocial());
            pstmt.setInt(3, cliente.getCp());
            pstmt.setDouble(4, cliente.getCuil());
            pstmt.setString(5, cliente.getDireccion());
            pstmt.setString(6, cliente.getTelefono());
            pstmt.setInt(7, cliente.getEstado());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();   
        }
        
    }
    
    public ArrayList<RazonSocial> obtenerRazonSocial()
    {
        ArrayList<RazonSocial> resultado = new ArrayList<>();
        
        try
        {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM razonsocial");
            
            while (rs.next()){
            
                int id = rs.getInt(1);
                String razon_social = rs.getString(2);
                
                RazonSocial r = new RazonSocial(id, razon_social);
                
                resultado.add(r);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();   
        }
        
        return resultado;
    }
    
    public Articulo buscarArticuloPorId(int codigo)
    {
        Articulo a = null;
        try 
        {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            String sql = "select * from articulos WHERE codigo=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, codigo); 
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                double precioCompra = rs.getFloat("precioCompra");
		double precioVenta = rs.getFloat("precioVenta");
                int stock = rs.getInt("stock");
                int stockMinimo=rs.getInt("stockMinimo");
                int estado = rs.getInt("estado");
                
                a = new Articulo(codigo, nombre, precioCompra, precioVenta, stock, stockMinimo, estado);
            }
            rs.close();
        } 
        catch (Exception e)
        {
            
            e.printStackTrace();
        }
        return a;
        
        
    }
    
    public ArrayList<MedioPago> obtenerMedioPago()
    {
        ArrayList<MedioPago> resultado = new ArrayList<>();
        
        try
        {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM formaspago");
            
            while (rs.next()){
            
                int id = rs.getInt(1);
                String forma_pago = rs.getString(2);
                
                MedioPago m = new MedioPago(id, forma_pago);
                
                resultado.add(m);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();   
        }
        
        return resultado;
    }
    
}
