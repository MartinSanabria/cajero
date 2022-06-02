
package Identidades;

public class Cliente {
    
    
    private String id_cliente;
    private String nombre;
    private String codigo_cuenta;

    public Cliente() {
        this.id_cliente = "";
        this.nombre = "";
        this.codigo_cuenta = "";
    }
    
    // Metodos getter

    public String getCodigo_cuenta() {
        return codigo_cuenta;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }
    
    // metodos setter

    public void setCodigo_cuenta(String codigo_cuenta) {
        this.codigo_cuenta = codigo_cuenta;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
