package Conexion;

import java.sql.*;
import oracle.jdbc.pool.*;

public final class Conexion {

    Connection conexion;
   
    public Conexion() {
        this.setConexion();
    }

    @SuppressWarnings("empty-statement")
    public void setConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
          conexion = DriverManager.getConnection("jdbc:oracle:thin:@//127.0.0.1:1521/orcl","project","123456");;
          
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage() + "No conecta" );
        } 
    }

    public Connection getConexion() {
        return this.conexion;
    }
       
}
