package modelo.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.DB.ConexionDB;

/**
 *
 * @author vicrodriguezp
 */
public class Profesor {

    private String nombre;
    private String rut;
    private final String querySelect = "select * from profesor where rut like ?";

    public String getQuerySelect() {
        return querySelect;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String buscarProfesorPorNombre(String profesor_rut) {

        ConexionDB conexionDB = new ConexionDB();
        Connection conexion = null;
        PreparedStatement pstmt;
        ResultSet resultado;

        try {

            conexion = conexionDB.GetConnection();
            pstmt = conexion.prepareStatement(this.querySelect);
            pstmt.setString(1,profesor_rut);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
                this.setRut(resultado.getString(1));
                this.setNombre(resultado.getString(2));
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al obtener los datos del profesor " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        }

        return nombre;
    }
}
