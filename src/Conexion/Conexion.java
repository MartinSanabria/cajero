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
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-UILKNB3V.mshome.net:1521/orcl.mshome.net","project","123456");;
          
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage() + " No conecta" );
        } 
    }

    public Connection getConexion() {
        return this.conexion;
    }
       
      public int agregar(String consulta) throws SQLException{
        Statement add =this.conexion.createStatement();
        return add.executeUpdate(consulta);
    }
    
       public int actualizar(String consulta) throws SQLException{
        Statement act =this.conexion.createStatement();
        return act.executeUpdate(consulta);
    }
    
     public ResultSet consultar(String sql) throws SQLException{
         Statement cons=this.conexion.createStatement();
         return cons.executeQuery(sql);
     }
    
    
    void cerrarConexion() throws SQLException{
        this.conexion.close();
    }   
}
