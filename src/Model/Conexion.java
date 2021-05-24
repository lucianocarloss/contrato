/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author yagami
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano
 */
public class Conexion {
    Connection conn=null;
    private String senha= "merumeru";
    private String usuario= " ";
    public Statement conectar() throws SQLException{

        Connection conexion = null;
        Statement declaracion=null;
        conn=DriverManager.getConnection("jdbc:ucanaccess://M:\\data\\bd\\dump.mdb", usuario, senha);
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

             conexion = conn;
             declaracion= (Statement) conexion.createStatement();


        } catch (ClassNotFoundException claseNoEncontrada) {
            JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(),
                    "No se encontró el controlador", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException excepcionSql) {
            //JOptionPane.showMessageDialog(null, excepcionSql.getMessage(),
                    //"Error en base de datos", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "erro ao conectar!!");

        }

        return declaracion;
    }




}