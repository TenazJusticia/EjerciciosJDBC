
package modelo.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.Constants;

/**
 *
 * @author vicrodriguezp
 */
public class ConexionDB {

    public Connection GetConnection() {
        Connection conexion = null;

        try {
            //me conecto a la base de datos y abro una conexión
        conexion = DriverManager.getConnection(Constants.URL, Constants.USUARIO, Constants.PASSWORD);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return conexion;
        }
    }

}
