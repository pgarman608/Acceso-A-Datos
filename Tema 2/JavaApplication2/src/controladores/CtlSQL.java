package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Alumno;

public class CtlSQL {
    public Connection conectarSQL() throws SQLException{
        Connection con = null;
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                                        , "AD_TEMA02", "AD_TEMA02");
        return con;
    }
    
}
