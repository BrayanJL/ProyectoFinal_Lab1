package AccesoADatos;

import java.sql.*;

public class SocioData {
    private Connection con = null;

    public SocioData() {
        con = Conexion.GetConexion();
    }
    
}
