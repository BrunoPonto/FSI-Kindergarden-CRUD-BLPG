
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bruno
 */
public class responsable {
    static String todos = "SELECT * FROM responsables ORDER BY nombrer DESC";
    static String curps = "SELECT curpr FROM responsables ORDER BY curpr";
    
    String curp, nombre, sexo, telefono, parentesco, estado;

    public responsable() {
    }

    public responsable(String curp, String nombre, String sexo, String telefono, String parentesco, String estado) {
        this.curp = curp;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.parentesco = parentesco;
        this.estado = estado;
    }
    
    public int insetar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "INSERT INTO responsables VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            ps.setString(2, nombre);
            ps.setString(3, sexo);
            ps.setString(4, telefono);
            ps.setString(5, parentesco);
            ps.setString(6, estado);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "DELETE FROM responsables WHERE curpr = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "UPDATE responsables SET nombrer = ?, sexor = ?, telefono = ?, parentesco = ?, estador = ? WHERE curpr = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sexo);
            ps.setString(3, telefono);
            ps.setString(4, parentesco);
            ps.setString(5, estado);
            ps.setString(6, curp);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
}//fin de la clase responsable
