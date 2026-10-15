
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bruno
 */
public class bitacora {
    static String todos = "SELECT * FROM bitacora ORDER BY folio DESC";
    
    String folio, tiempo, tipo, observaciones, bitacora, infantes, responsable, educador;

    public bitacora() {
    }

    public bitacora(String folio, String tiempo, String tipo, String observaciones, String bitacora, String infantes, String responsable, String educador) {
        this.folio = folio;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.bitacora = bitacora;
        this.infantes = infantes;
        this.responsable = responsable;
        this.educador = educador;
    }
    
    public int insetar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "INSERT INTO educadores VALUES(?, ?, ?, ?, ?, ?, ? ,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, tiempo);
            ps.setString(3, tipo);
            ps.setString(4, observaciones);
            ps.setString(5, bitacora);
            ps.setString(6, infantes);
            ps.setString(7, responsable);
            ps.setString(8, educador);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "DELETE FROM bitacora WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "UPDATE educadores SET tiempo = ?, tipo = ?, observaciones = ?, bitacoracol = ?, infantes_curp = ?, responsables_curpr = ?, educadores_curpe = ? WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, tiempo);
            ps.setString(2, tipo);
            ps.setString(3, observaciones);
            ps.setString(4, bitacora);
            ps.setString(5, infantes);
            ps.setString(6, responsable);
            ps.setString(7, educador);
            ps.setString(8, folio);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }

    }
}//fin de la clase
