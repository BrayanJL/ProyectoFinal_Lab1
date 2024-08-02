package AccesoADatos;

import AccesoADatos.ClaseData;
import AccesoADatos.MembresiaData;
import AccesoADatos.SocioData;
import Entidades.Asistencia;
import Entidades.Clase;
import Entidades.Membresia;
import Entidades.Socio;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
        membresiaData = new MembresiaData();
    }
    
    public void guardarAsistencia(Asistencia asistencia){

        Clase clase = asistencia.getClase();
        Socio socio = asistencia.getSocio();
        Membresia membresia = membresiaData.recibirUltimaMembresia(socio.getIdSocio());

        boolean ok1 = clase.isEstado();
        boolean ok2 = clase.getEntrenador().isEstado();
        boolean ok3 = socio.isActivo();
        boolean ok4 = membresia.isActivo()
                   && membresia.getCantidadPases()>0;
        boolean ok5 = !usuarioAsistioHoy(clase,socio);
        boolean ok6 = contarCuposLibres(clase)>0;

        if (!ok1 || !ok2 || !ok3 || !ok4 || !ok5 || !ok6){
            if(!ok1) {
                JOptionPane.showMessageDialog(null, "No se puede agregar asistencia a una clase inactiva");
            }else if(!ok2) {
                JOptionPane.showMessageDialog(null, "No se puede agregar asistencia a una clase con un entrenador inactivo");
            }else if (!ok3){
                JOptionPane.showMessageDialog(null, "Un socio inactivo no puede asistir a una clase");
            }else if (!ok4){
                JOptionPane.showMessageDialog(null, "Necesita tener una membresia activa con pases");
            }else if (!ok5){
                JOptionPane.showMessageDialog(null, "El socio ya asistio a esta clase hoy");
            }else if (!ok6){
                JOptionPane.showMessageDialog(null, "El cupo de asistencia a esta clase esta lleno por hoy");
            }
            return;
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

                    //Reducimos en 1 la cantidad de pases
                    membresia.setCantidadPases(membresia.getCantidadPases()-1);
                    membresiaData.modificarCantidadPases(membresia);

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
                asistencia.setSocio(socioData.buscarSocioPorID(rs.getInt("ID_Socio")));
                asistencia.setFechaAsistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Asistencia "+e.getMessage());
        }

        return asistencia;
    }
    
    public List<Asistencia> listarAsistencia(){
        List<Asistencia> asistencias = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM asistencia";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setIdAsistencia(rs.getInt("ID_Asistencia"));
                asistencia.setSocio(socioData.buscarSocioPorID(rs.getInt("ID_Socio")));
                asistencia.setClase(claseData.buscarClase(rs.getInt("ID_Clase")));
                asistencia.setFechaAsistencia(LocalDate.MIN);
                asistencia.setFechaAsistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
                asistencias.add(asistencia);
            }
            ps.close();
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al acceder la tabla Clase "+e.getMessage());
        }
        
        return asistencias;
    }
    
    public List<Asistencia> listarAsistenciaPorClase(int idClase){
        List<Asistencia> asistencias = listarAsistencia();
        asistencias.removeIf(asistencia -> idClase != asistencia.getClase().getIdClase());
        
        return asistencias;
    }
    
    public List<Asistencia> listarAsistenciaPorSocio(int idSocio){
        List<Asistencia> asistencias = listarAsistencia();
        asistencias.removeIf(asistencia -> idSocio != asistencia.getSocio().getIdSocio());
        
        return asistencias;
    }
    
    public List<Asistencia> listarAsistenciaPorFechaYClase(LocalDate fecha, int idClase){
        return listarAsistencia().stream()
                .filter(asistencia ->   idClase == asistencia.getClase().getIdClase() &&
                        fecha.equals(asistencia.getFechaAsistencia()))
                .collect(Collectors.toList());
    }
    
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
    
    public int contarCuposLibres(Clase clase){
        
        LocalDate fechaDeHoy = LocalDate.now();
        List<Asistencia> asistencias = listarAsistenciaPorFechaYClase(fechaDeHoy, clase.getIdClase());
        
        int cuposLibres = clase.getCapacidad() - asistencias.size();
        
        return cuposLibres;
    }
    
    //Verifica si el usuario asistio hoy a esa clase
    public boolean usuarioAsistioHoy(Clase clase, Socio socio){
        
        boolean asistio = false;
        
        LocalDate fechaDeHoy = LocalDate.now();
        List<Asistencia> asistencias = listarAsistenciaPorFechaYClase(fechaDeHoy, clase.getIdClase());
        
        for (Asistencia a: asistencias){
            int idSocio1 = a.getSocio().getIdSocio();
            int idSocio2 = socio.getIdSocio();
            if (idSocio1 == idSocio2){
                asistio = true;
                break;
            }
        }
        return asistio;
    }
    
}
