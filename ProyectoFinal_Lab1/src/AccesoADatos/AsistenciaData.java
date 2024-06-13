package AccesoADatos;

import Entidades.Asistencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AsistenciaData {
    private Connection con = null;
    private SocioData socioData;
    private ClaseData claseData;
    private MembresiaData membresiaData;
    
    

    public AsistenciaData() {
        con = Conexion.GetConexion();
        socioData = new SocioData();
        claseData = new ClaseData();
    }
    
    public void guardarAsistencia(Asistencia asistencia){
        Membresia = membresiaData.
        
        boolean ok1 = asistencia.getClase().isEstado();
        boolean ok2 = asistencia.getClase().getEntrenador().isEstado();
        boolean ok3 = asistencia.getSocio().isActivo();
        boolean ok4 = 
        
        if (!ok1 || !ok2 || !ok3 || ok4){
            if(!ok1) {
                JOptionPane.showMessageDialog(null, "No se puede agregar asistencia a una clase con un entrenador inactivo");
            }else if(!ok2) {
                JOptionPane.showMessageDialog(null, "No se puede agregar asistencia a una clase con inactiva");
            }else if (!ok3){
                JOptionPane.showMessageDialog(null, "Un socio inactivo no puede asistir a una clase");
            }
        }
        
        else{
            String sql = "INSERT INTO Asistencia (ID_Socio, ID_Clase, Fecha_Asistencia) "
                        + "VALUES ( ? , ? , ?)";

            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, asistencia.getSocio().getIdSocio());
                ps.setInt(2, asistencia.getClase().getIdClase());
                ps.setDate(3, Date.valueOf(asistencia.getFechaAsistencia()));


                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    asistencia.setIdAsistencia(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Se agrego la asistencia exitosamente");
                }
                ps.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Asistencia "+e.getMessage());
            }
        }
    }
    
    public Asistencia buscarAsistencia(int idAsistencia){
        Asistencia asistencia = null;
        String sql = "SELECT * FROM Asistencia WHERE ID_Asistencia = ?";
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement (sql);
            ps.setInt(1, idAsistencia);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                asistencia = new Asistencia();
                asistencia.setIdAsistencia(rs.getInt("ID_Asistencia"));
                asistencia.setClase(claseData.buscarClase(rs.getInt("ID_Clase")));
                asistencia.setSocio(socioData.buscarSocio(rs.getInt("ID_Socio")));
                asistencia.setFechaAsistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Asistencia "+e.getMessage());
        }
        
        return asistencia;
    }
    /*
    public List<Asistencia> listarAsistencia(){
        List<Asistencia> asistencias = new ArrayList<>();
        return asistencias;
    }
    
    public List<Asistencia> listarAsistenciaPorClase(){
        List<Asistencia> asistencias = new ArrayList<>();
        return asistencias;
    }
    
    public List<Asistencia> listarAsistenciaPorSocio(){
        List<Asistencia> asistencias = new ArrayList<>();
        return asistencias;
    }
    
    public List<Asistencia> listarAsistenciaPorFecha(){
        List<Asistencia> asistencias = new ArrayList<>();
        return asistencias;
    }
    */
    public void modificarAsistencia(Asistencia asistencia){
        String sql = "UPDATE Asistencia SET ID_Socio = ?, ID_Clase = ?, Fecha_Asistencia = ?) "
            + "WHERE ID_Asistencia = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, asistencia.getSocio().getIdSocio());
            ps.setInt(2, asistencia.getClase().getIdClase());
            ps.setDate(3, Date.valueOf(asistencia.getFechaAsistencia()));
            ps.setInt(4, asistencia.getIdAsistencia());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La Asistencia fue modificada exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "La asistencia no existe");
            }
            
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Asistencia "+e.getMessage());
        }
    }
    
    /*
    public void eliminarAsistencia(int idAsistencia){
    
    }*/
    
}
