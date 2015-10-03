package Conexao1;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionManager {

    public static Connection getConnection() {

        Connection conn = null;

        String STR_DRIVER = "org.gjt.mm.mysql.Driver";
        //conexão local
        String STR_CONEX = "jdbc:mysql://localhost:3306/DB_TCCGRUPO1";
        String USER = "root";
        String PASSWORD = "";

	
        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CONEX, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
