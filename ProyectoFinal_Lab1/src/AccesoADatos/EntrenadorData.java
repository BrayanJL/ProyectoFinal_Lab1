package AccesoADatos;

import java.sql.*;

public class EntrenadorData {
    private Connection con = null;

    public EntrenadorData() {
        con = Conexion.GetConexion();
    }
    
}
