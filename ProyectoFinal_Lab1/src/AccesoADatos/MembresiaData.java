package AccesoADatos;

import Entidades.Membresia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MembresiaData {
    private Connection con = null;
    private SocioData socData;

    public MembresiaData() {
        con = Conexion.GetConexion();
        socData = new SocioData();
    }
    
    public void guardarMembresia(Membresia membresia) {
        boolean ok1 = membresia.getSocio().isActivo();
        boolean ok2 = membresia.isActivo();
        if(ok1 && ok2) {
            String sql = "INSERT INTO Membresía (ID_Socio, Tipo, Fecha_Inicio, Fecha_Fin, estado, costo)"
                    + "VALUES (? , ? , ? , ? , ? , ? )";
            
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, membresia.getIdSocio());
                ps.setString(2, membresia.getTipo());
                ps.setDate(3, Date.valueOf(membresia.getFechaInicio()));
                ps.setDate(4, Date.valueOf(membresia.getFechaFin()));
                ps.setBoolean(5, membresia.isActivo());
                ps.setDouble(6, membresia.getCosto());
                
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    membresia.setIdMembresia(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Se agrego la membresia exitosamente");
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Membresia " + e.getMessage());
            }
        } else {
            if(ok1 == false) {
                JOptionPane.showMessageDialog(null, "No se puede inscribir un Socio no activo");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede inscribir una Membresia inactivo");
            }
            
        }
    }
    
    public List<Membresia> obtenerMembresiasPorTipo(Membresia membresia) {
        
        List<Membresia> membresias = new ArrayList<>();
        
        String sql = "SELECT * FROM Membresía WHERE Tipo = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, membresia.getTipo());
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Membresia memb = new Membresia();
                memb.setIdMembresia(rs.getInt("ID_Membresía"));
                memb.setSocio(socData.buscarSocio(rs.getInt("ID_Socio")));
                memb.setTipo(rs.getString("Tipo"));
                memb.setCosto(rs.getDouble("Costo"));
                memb.setFechaInicio(rs.getDate("Fecha_Inicio").toLocalDate());
                memb.setFechaFin(rs.getDate("Fecha_Fin").toLocalDate());
                memb.setEstado(rs.getBoolean("estado"));
                membresias.add(memb);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Membresia " + e.getMessage());
        }
        return membresias;
    }
    
    public List<Membresia> obtenerMembresias() {
        
        List<Membresia> membresias = new ArrayList<>();
        
        String sql = "SELECT * FROM Membresía";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Membresia memb = new Membresia();
                memb.setIdMembresia(rs.getInt("ID_Membresía"));
                memb.setSocio(socData.buscarSocio(rs.getInt("ID_Socio")));
                memb.setTipo(rs.getString("Tipo"));
                memb.setCosto(rs.getDouble("Costo"));
                memb.setFechaInicio(rs.getDate("Fecha_Inicio").toLocalDate());
                memb.setFechaFin(rs.getDate("Fecha_Fin").toLocalDate());
                memb.setEstado(rs.getBoolean("estado"));
                membresias.add(memb);
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Membresía " + e.getMessage());
        }
        return membresias;
    }
    
    public void modificarCosto(int idMembresia, double costo) {
        String sql = "UPDATE Membresía SET Costo = ? WHERE ID_Membresía = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, costo);
            ps.setInt(2, idMembresia);
            
            int exito = ps.executeUpdate();
            
            if(exito == 1) {
                JOptionPane.showMessageDialog(null, "Se modifico la membresía exitosamente");
            } else JOptionPane.showMessageDialog(null, "No existe esa membresia");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Membresia " + e.getMessage());
        }
    }
    
    public void renovarMembresia(Membresia membresia) {
        String sql = "UPDATE Membresía SET Tipo = ? , Fecha_Inicio = ? , Fecha_Fin = ? WHERE ID_Membresía = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, membresia.getTipo());
            ps.setDate(2, Date.valueOf(membresia.getFechaInicio()));
            ps.setDate(3, Date.valueOf(membresia.getFechaFin()));
            ps.setInt(4, membresia.getIdMembresia());
            
            int exito = ps.executeUpdate();
            
            if(exito == 1) {
                JOptionPane.showMessageDialog(null, "Se modifico la membresia exitosamente");
            } else JOptionPane.showMessageDialog(null, "No existe esa membresia");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Membresia " + e.getMessage());
        }
        
    }
    
    public void eliminarMembresia(int idMembresia) {
        String sql = "UPDATE Membresía SET estado = 0 WHERE ID_Membresía = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMembresia);
            int exito = ps.executeUpdate();
            
            if(exito == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la membresia exitosamente");
            } else JOptionPane.showMessageDialog(null, "No existe esa membresia");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Membresia " + e.getMessage());
        }
    }
    
    public void habilitarMembresia(int idMembresia) {
        String sql = "UPDATE Membresía SET estado = 1 WHERE ID_Membresía = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMembresia);
            int exito = ps.executeUpdate();
            
            if(exito == 1) {
                JOptionPane.showMessageDialog(null, "Se habilito la membresia exitosamente");
            } else JOptionPane.showMessageDialog(null, "No existe esa membresia");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Membresia " + e.getMessage());
        }
    }
    
}
