/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Ferramenta.ConexaoBD;
import Ferramenta.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBIntrospector;

/**
 *
 * @author Luciano
 */
public class M_usuarios {
    
    ConexaoBD conex = new ConexaoBD();
    Usuarios mod = new Usuarios();
    
    
    public void Salvar (Usuarios mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into user(Nome,email,fone,usuario,senha,sexo,cargo,nivel) values(?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getUsuNome());
            pst.setString(2,mod.getUsuEmail());
            pst.setString(3,mod.getUsuFone());
            pst.setString(4,mod.getUsuUsuario());
            pst.setString(5,mod.getUsuSenha());
            pst.setString(6,mod.getUsuSexo());
            pst.setString(7,mod.getUsuCargo());
            pst.setString(8,mod.getUsuNivel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário gravado com sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao gravar usuário!/nErro:" +ex);
        }
        conex.desconecta();
    }
    
    
}
