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
        String sql = "INSERT INTO entrenador (DNI, Nombre, Apellido, Especialidad, estado) "
                + "VALUES ( ? , ? , ? , ? , ? )";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            
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
    
    public List<Entrenador> listarEntrenadoresInactivos() {
        List<Entrenador> entrenadores = listarEntrenadores();
        entrenadores.removeIf(entrenador -> entrenador.isEstado());
        
        return entrenadores;
    }
    
    public void modificarEntrenador(Entrenador entrenador) {
        
        if (dniRepetido(entrenador)) {
            return;
        }
        
        String sql = "UPDATE entrenador SET DNI = ? , Nombre = ? , Apellido = ? , Especialidad = ? "
                + "WHERE ID_Entrenador = ? ";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setInt(5, entrenador.getIdEntrenador());
            
            
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
    
    public void deshabilitarEntrenador(int dni) {
        try {
            String sql = "UPDATE entrenador SET estado = 0 WHERE DNI = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "El entrenador ha sido deshabilitado");
            } else {
                JOptionPane.showMessageDialog(null, "El entrenador no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador " + e.getMessage());
        }
    }
    
    public void habilitarEntrenador(int dni) {
        try {
            String sql = "UPDATE entrenador SET estado = 1 WHERE DNI = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "El entrenador ha sido habilitado");
            } else {
                JOptionPane.showMessageDialog(null, "El entrenador no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador " + e.getMessage());
        }
    }
    
    private boolean dniRepetido(Entrenador entrenador) {
        
        String sql = "SELECT * FROM entrenador WHERE ID_Entrenador != ? and DNI = ?";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, entrenador.getIdEntrenador());
            ps.setInt(2, entrenador.getDni());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Ya existe un entrenador con este DNI");
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Entrenador "+e.getMessage());
        }
        return false;
    }
}
