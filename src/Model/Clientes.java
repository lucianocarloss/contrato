/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Ferramenta.Conector;
import Ferramenta.ConexaoBD;
import com.sun.org.apache.xpath.internal.operations.Operation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Luciano
 */

public class Clientes {
    
    Conector conexion =new Conector();
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
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
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

        
        
       
        
    
    
     
    
    

