package AccesoADatos;


import Entidades.Clase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClaseData {
    private Connection con = null;
    private EntrenadorData entData;

    public ClaseData() {
        con = Conexion.GetConexion();
        entData = new EntrenadorData();
    }
    
    public void guardarClase(Clase clase) {
        boolean ok1 = clase.getEntrenador().isEstado();
        boolean ok2 = clase.isEstado();
        
        
        if (ok1 && ok2) {
            String sql = "INSERT INTO clase (ID_Entrenador, Horario, Nombre, Capacidad, estado) "
                + "VALUES ( ? , ? , ? , ? , ?)";

            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, clase.getIdEntrenador());
                ps.setTime(2, Time.valueOf(clase.getHorario()));
                ps.setString(3, clase.getNombre());
                ps.setInt(4, clase.getCapacidad());
                ps.setBoolean(5, clase.isEstado());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    clase.setIdClase(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Se agrego la clase exitosamente");
                }
                ps.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase "+e.getMessage());
            }
        }
        else {
            if(ok1 == false) {
                JOptionPane.showMessageDialog(null, "No se puede agregar una clase con un entrenador inactivo");
            }
            else {
                JOptionPane.showMessageDialog(null, "Esta clase está inactiva");
            }
        }
        
    }
    
    public Clase buscarClase(int idClase) {
        Clase clase = null;
        String sql = "SELECT * FROM clase WHERE ID_Clase = ? ";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                clase = new Clase();
                clase.setIdClase(rs.getInt("ID_Clase"));
                clase.setEntrenador(entData.buscarEntrenador(rs.getInt("ID_Entrenador")));
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setNombre(rs.getString("Nombre"));
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                
            } //else JOptionPane.showMessageDialog(null, "No existe la clase con el ID que solicito");
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase "+e.getMessage());
        }
        
        return clase;
    }
    
    public List<Clase> listarClases() {
        List<Clase> clases = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM clase";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("ID_Clase"));
                clase.setEntrenador(entData.buscarEntrenador(rs.getInt("ID_Entrenador")));
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setNombre(rs.getString("Nombre"));
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
            }
            ps.close();
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase "+e.getMessage());
        }
        
        return clases;
    }
    
    public List<Clase> listarClasesValidas() {
        List<Clase> clases = listarClases();
        clases.removeIf(clase -> clase.isEstado() == false);
        clases.removeIf(clase -> clase.getEntrenador().isEstado() == false);
        
        return clases;
    }
    
    public List<Clase> listarClasesPorEntrenador(int idEntrenador) {
        List<Clase> clases = new ArrayList<>();
        
        try {
            String sql = "SELECT clase.ID_Clase, clase.ID_Entrenador, clase.Horario, clase.Nombre, clase.Capacidad, clase.estado "
                + "FROM clase INNER JOIN entrenador "
                + "ON clase.ID_Entrenador = entrenador.ID_Entrenador "
                + "WHERE clase.ID_Entrenador = ? ";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEntrenador);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("ID_Clase"));
                clase.setEntrenador(entData.buscarEntrenador(rs.getInt("ID_Entrenador")));
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setNombre(rs.getString("Nombre"));
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
            }
            ps.close();
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase "+e.getMessage());
        }
        
        return clases;
    }
    
    public void modificarClase(Clase clase) {
        
        String sql = "UPDATE clase SET ID_Entrenador = ? , Horario = ? , Nombre = ? , Capacidad = ? "
                + "WHERE ID_Clase = ? ";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, clase.getIdEntrenador());
            ps.setTime(2, Time.valueOf(clase.getHorario()));
            ps.setString(3, clase.getNombre());
            ps.setInt(4, clase.getCapacidad());
            ps.setInt(5, clase.getIdClase());
            
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La clase fue modificado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "La clase no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase " + e.getMessage());
        }
    }
    
    public void habilitarClase(int idClase) {
        try {
            String sql = "UPDATE clase SET estado = 1 WHERE ID_Clase = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la clase");
            } else {
                JOptionPane.showMessageDialog(null, "La clase no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase " + e.getMessage());
        }
    }
    
    public void eliminarClase(int idClase) {
        try {
            String sql = "UPDATE clase SET estado = 0 WHERE ID_Clase = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la clase");
            } else {
                JOptionPane.showMessageDialog(null, "La clase no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase " + e.getMessage());
        }
    }
}
