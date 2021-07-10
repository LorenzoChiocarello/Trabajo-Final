
package Gestor;

import Modelo.RazonSocial;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Conexion {
    
    Connection enlazar = null;
    
    
    public Connection conectar()
    {
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            enlazar = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QO3CRMK:1433;databaseName=TrabajoFinal","sa","123456789");
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return enlazar;
    }
    
    
    
    
    
    
}
