package AccesoADatos;

import java.sql.*;

public class AsistenciaData {
    private Connection con = null;

    public AsistenciaData() {
        con = Conexion.GetConexion();
    }
    
}
