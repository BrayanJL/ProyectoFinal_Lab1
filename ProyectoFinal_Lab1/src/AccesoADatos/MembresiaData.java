package AccesoADatos;

import java.sql.*;

public class MembresiaData {
    private Connection con = null;

    public MembresiaData() {
        con = Conexion.GetConexion();
    }
    
}
