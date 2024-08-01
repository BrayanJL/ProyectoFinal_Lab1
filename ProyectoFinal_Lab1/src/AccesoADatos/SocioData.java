package AccesoADatos;
import Entidades.Socio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import java.sql.*;

public class SocioData {
    private Connection con = null;

    public SocioData() {
        con = Conexion.GetConexion();
    }
    
    public void guardarSocio(Socio socio) {
        String sql = "INSERT INTO socio (dni, nombre, apellido, edad, correo, teléfono, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setBoolean(7, socio.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                socio.setIdSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agrego el socio exitosamente");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Socio "+e.getMessage());
        }
    }
    
    public Socio buscarSocioPorID (int id) {
        Socio socio = null;
        String sql = "SELECT * FROM socio WHERE ID_Socio = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                socio = new Socio();
                socio.setIdSocio(rs.getInt("ID_Socio"));
                socio.setDni(rs.getInt("DNI"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Teléfono"));
                socio.setEstado(rs.getBoolean("estado"));
            } else 
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Socio "+e.getMessage());
        }
        
        return socio;
    }
    
    public Socio buscarSocioPorDNI (int dni) {
        Socio socio = null;
        String sql = "SELECT * FROM socio WHERE DNI = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                socio = new Socio();
                socio.setIdSocio(rs.getInt("ID_Socio"));
                socio.setDni(rs.getInt("DNI"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Teléfono"));
                socio.setEstado(rs.getBoolean("estado"));
            } else 
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Socio "+e.getMessage());
        }
        
        return socio;
    }
    
    public List<Socio> listarSocios() {
        List<Socio> socios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Socio";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Socio socio = new Socio();
                socio.setIdSocio(rs.getInt("ID_Socio"));
                socio.setDni(rs.getInt("DNI"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Teléfono"));
                socio.setEstado(rs.getBoolean("estado"));
                socios.add(socio);
            } 
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Socio "+e.getMessage());
        }
        
        return socios;
    }
    
    public List<Socio> listarSociosActivos() {
        List<Socio> socios = listarSocios();
        socios.removeIf(socio -> socio.isActivo() == false);
        
        return socios;
    }
    
    public List<Socio> listarSociosNoActivos() {
        List<Socio> socios = listarSocios();
        socios.removeIf(socio -> socio.isActivo());
        
        return socios;
    }
    
    public void modificarSocio(Socio socio) {
        
        String sql = "UPDATE socio SET  nombre = ? , apellido = ? , edad = ? , correo = ? , teléfono = ?  , dni = ? WHERE ID_Socio = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, socio.getNombre());
            ps.setString(2, socio.getApellido());
            ps.setInt(3, socio.getEdad());
            ps.setString(4, socio.getCorreo());
            ps.setString(5, socio.getTelefono());
            ps.setInt(6, socio.getDni());
            ps.setInt(7, socio.getIdSocio());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El socio fue modificado exitosamente!");
            } else JOptionPane.showMessageDialog(null, "El socio no existe");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Socio "+e.getMessage());
        }
    }
    
    public void eliminarSocio(int dni) {
        try {
            String sql = "UPDATE socio SET estado = 0 WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila = ps.executeUpdate();
            
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "El socio fue eliminado exitosamente!");
            } else JOptionPane.showMessageDialog(null, "El socio no existe");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Socio "+e.getMessage());
        }
    }
    
    public void habilitarSocio(int dni) {
        try {
            String sql = "UPDATE socio SET estado = 1 WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila = ps.executeUpdate();
            
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "El socio fue habilitado exitosamente!");
            } else JOptionPane.showMessageDialog(null, "El socio no existe");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Socio "+e.getMessage());
        }
    }
}
