package Conexion;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class Conexion {

    Connection conexion;
    OracleDataSource ds;
    CallableStatement cs;
   
    public Conexion() {
        this.getConexion();
    }

    public void setConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
          ds= new OracleDataSource();
          ds.setURL("jdbc:oracle:thin:@//127.0.0.1:1521/orcl");
          conexion = ds.getConnection("project","123456");
          
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "No conecta" );
        } 
    }

    public Connection getConexion() {
        return this.conexion;
    }
       
}
