/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ferramenta;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexaoBD {
    
    public Statement stm;
    public ResultSet rs;
    public Statement stmc;
    public ResultSet rsc;
    //private String driver = "jdbc:ucanaccess://";
    //private String caminho = "te1.accdb";
    private String usuario = " ";
    private String senha = "merumeru";
    public Connection con;
    public Connection conc;
    
    
    public void conexao(){
        
        try {
           // System.setProperties("");
            con = DriverManager.getConnection("jdbc:ucanaccess://dump.mdb", usuario, senha);
            //con=DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "CONECTADO!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\\n" +ex);
        }
    }
    
    public void conexaon(){
        
        try {
           // System.setProperties("");conc = DriverManager.getConnection("jdbc:ucanaccess://M:\\data\\bd\\dump.mdb", usuario, senha);
            conc = DriverManager.getConnection("jdbc:ucanaccess://dump.mdb", usuario, senha);
            //con=DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "CONECTADO!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\\n" +ex);
        }
    }
    
    public void executarSql(String sql){
        try{
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, "Erro ExecutaSQL!\\n" +ex); 
            JOptionPane.showMessageDialog(null, "erro ao conectar!!  (NO SQL)");
        }
        
        
        
    }
    
        public void executarSqln(String sql){
        try{
            stmc = conc.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rsc = stmc.executeQuery(sql);
            
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, "Erro ExecutaSQL!\\n" +ex); 
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR AO NUMERO CONTRATO!!" +ex);
        }
        
        
        
    }
    
        public void desconecta(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "BD Desconectado!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar ao BD!\\n" +ex);
        }
    }
        public void desconectan(){
        try {
            conc.close();
            //JOptionPane.showMessageDialog(null, "BD Desconectado!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar ao BD!\\n" +ex);
        }
    }
    
}
