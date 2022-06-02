
package Identidades;

import java.sql.Connection;
import java.sql.Statement;
import Conexion.*;
import java.sql.ResultSet;


public class Cliente {
    
    private Conexion ObjConexion;

    public Cliente() {
        ObjConexion = new Conexion();
    }
 
    public void listarCliente(){
        String sql = "SELECT * FROM cliente";
        
        try {
            Connection conexion = this.ObjConexion.getConexion();
            Statement stm = conexion.createStatement();
            ResultSet resultados = stm.executeQuery(sql);
            
            while(resultados.next()){
                System.out.println(resultados.getString(2));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
