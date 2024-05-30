package AccesoADatos;

import java.sql.*;

public class ClaseData {
    private Connection con = null;

    public ClaseData() {
        con = Conexion.GetConexion();
    }
    
}
