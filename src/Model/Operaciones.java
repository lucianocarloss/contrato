/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author yagami
 */
public class Operaciones {
    
    Conexion conexion =new Conexion();
    Statement st;
    ResultSet res;

    public DefaultComboBoxModel getLista(String cadenaEscrita){

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {

            String query = "SELECT Nome FROM client WHERE Nome LIKE '" + cadenaEscrita + "%';";
            st = conexion.conectar();
            res = (ResultSet) st.executeQuery(query);
            while (res.next()) {
                modelo.addElement(res.getString("Nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

     return modelo;

    }

    public String[] buscar(String nombre){

        String[] datos = new String[4];
        try {

            String query = "SELECT * FROM client WHERE Nome='" + nombre + "'";
            st = conexion.conectar();
            res = (ResultSet) st.executeQuery(query);
            while (res.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = res.getString(i + 1);
                }
            }
        } catch (SQLException ex) {
            return null;
        }
        return datos;
    }

}
