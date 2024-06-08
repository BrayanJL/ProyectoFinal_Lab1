package AccesoADatos;

import Entidades.Entrenador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EntrenadorData {
    private Connection con = null;

    public EntrenadorData() {
        con = Conexion.GetConexion();
    }
    
    public void guardarEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO entrenador (DNI, Nombre, Apellido, Especialidad, Disponibilidad, estado) "
                + "VALUES ( ? , ? , ? , ? , ? , ? )";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setString(5, entrenador.getDisponibilidad());
            ps.setBoolean(6, entrenador.isEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                entrenador.setIdEntrenador(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agrego el entrenador exitosamente");
            }
            ps.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador "+e.getMessage());
        }
    }
    
    public Entrenador buscarEntrenador(int idEntrenador) {
        Entrenador entrenador = null;
        String sql = "SELECT * FROM entrenador WHERE ID_Entrenador = ? ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEntrenador);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("ID_Entrenador"));
                entrenador.setDni(rs.getInt("DNI"));
                entrenador.setNombre(rs.getString("Nombre"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setDisponibilidad(rs.getString("Disponibilidad"));
                entrenador.setEstado(rs.getBoolean("estado"));
                
            } //else JOptionPane.showMessageDialog(null, "No existe el entrenador con el ID que solicito");
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador "+e.getMessage());
        }
        
        return entrenador;
    }
    
    public Entrenador buscarEntrenadorPorDni(int dni) {
        Entrenador entrenador = null;
        String sql = "SELECT * FROM entrenador WHERE DNI = ? ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("ID_Entrenador"));
                entrenador.setDni(rs.getInt("DNI"));
                entrenador.setNombre(rs.getString("Nombre"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setDisponibilidad(rs.getString("Disponibilidad"));
                entrenador.setEstado(rs.getBoolean("estado"));
                
            } //else JOptionPane.showMessageDialog(null, "No existe el entrenador con el DNI que solicito");
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador "+e.getMessage());
        }
        
        return entrenador;
    } 
    
    public List<Entrenador> listarEntrenadores() {
        List<Entrenador> entrenadores = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM entrenador";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Entrenador entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("ID_Entrenador"));
                entrenador.setDni(rs.getInt("DNI"));
                entrenador.setNombre(rs.getString("Nombre"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setDisponibilidad(rs.getString("Disponibilidad"));
                entrenador.setEstado(rs.getBoolean("estado"));
                entrenadores.add(entrenador);
            }
            ps.close();
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador "+e.getMessage());
        }
        
        return entrenadores;
    }
    
    public List<Entrenador> listarEntrenadoresActivos() {
        List<Entrenador> entrenadores = listarEntrenadores();
        entrenadores.removeIf(entrenador -> entrenador.isEstado() == false);
        
        return entrenadores;
    }
    
    public void modificarEntrenador(Entrenador entrenador) {
        
        String sql = "UPDATE entrenador SET DNI = ? , Nombre = ? , Apellido = ? , Especialidad = ? , Disponibilidad = ? , Estado = ? "
                + "WHERE ID_Entrenador = ? ";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setString(5, entrenador.getDisponibilidad());
            ps.setBoolean(6, entrenador.isEstado());
            ps.setInt(7, entrenador.getIdEntrenador());
            
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El entrenador fue modificado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "El entrenador no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador " + e.getMessage());
        }
    }
    
    public void eliminarEntrenador(int dni) {
        try {
            String sql = "UPDATE entrenador SET estado = 0 WHERE DNI = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el entrenador");
            } else {
                JOptionPane.showMessageDialog(null, "El entrenador no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador " + e.getMessage());
        }

    }
}
