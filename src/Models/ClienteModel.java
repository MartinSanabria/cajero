package Models;

import java.sql.Connection;
import java.sql.Statement;
import Conexion.*;
import Identidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClienteModel {
    
    private Conexion ObjConexion;

    public ClienteModel() {
        ObjConexion = new Conexion();
    }
 
    public Cliente obtenerCliente(String codigo){
        Cliente cliente_obtenido = new Cliente();
    
        try {
            String sql = "SELECT " +
                         "cli.id_cliente, "+
                        "cli.primer_nombre || ' ' || cli.segundo_nombre || ' ' || cli.primer_apellido || ' ' || cli.segundo_apellido AS nombre," +
                        "cli.telefono," +
                        "cli.ciudad || ','||cli.departamento AS localidad , " +
                        "cue.codigo_cuenta"+
                        "FROM cliente cli JOIN cuenta cue ON cli.id_cliente = cue.id_cliente" +
                        " WHERE cue.codigo_cuenta = ?;";
            
            Connection conexion = this.ObjConexion.getConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet resultados = pstm.executeQuery();
            
            
            while(resultados.next()){
                cliente_obtenido.setId_cliente(Integer.toString(resultados.getInt("id_cliente")));
                cliente_obtenido.setNombre(resultados.getString("nombre"));
                cliente_obtenido.setCodigo_cuenta(resultados.getString("codigo_cuenta"));
            }
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return cliente_obtenido;
    }
    
    public boolean existeCliente(String codigo){
        boolean existe = false;
        
        try{
            String funtion = "create or replace function existeCliente\n" +
                                " (codigo in varchar) \n" +
                                " return number \n" +
                                " is \n" +
                                " cant number; \n" +
                                " begin\n" +
                                " SELECT COUNT(*) into cant FROM cuenta WHERE codigo_cuenta=codigo; \n" +
                                " return cant; \n" +
                                " end existeCliente; ";
            
            Connection conexion = this.ObjConexion.getConexion();
            PreparedStatement pstm = conexion.prepareStatement(funtion);
            ResultSet resultados = pstm.executeQuery();
            
        }catch(SQLException e){
            
        }
        
        try {
            String sql = "select existeCliente('?') as cantidad from dual";
            
            Connection conexion = this.ObjConexion.getConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setString(0, codigo);
            ResultSet resultados = pstm.executeQuery();
            while(resultados.next()){
                int cantidad = resultados.getInt(0);
                System.out.println(resultados.getInt(0));
                existe = (cantidad > 0);
            }
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    
        return existe;
    };
    
}
