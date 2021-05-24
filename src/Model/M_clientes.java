/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Ferramenta.ConexaoBD;
import Ferramenta.clientes;
import Interfaces.Cad_Clientes;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBIntrospector;

/**
 *
 * @author Luciano
 */
public class M_clientes {
    
    ConexaoBD conex = new ConexaoBD();
    clientes mod = new clientes();
    
    
    public void Salvar (clientes mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into client(cpf,nome,rg,sexo,escivil,uf,endereco,numero,complemento,municipio,bairro,cep,email,fone1,fone2,pessoa,registron,cpfn) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getCliCpf());
            pst.setString(2,mod.getCliNome());
            pst.setString(3,mod.getCliRG());
            pst.setString(4,mod.getCliSexo());
            pst.setString(5,mod.getCliEstcivil());
            pst.setString(6,mod.getCliUf());
            pst.setString(7,mod.getCliEndereco());
            pst.setString(8,mod.getCliNumero());
            pst.setString(9,mod.getCliComp());
            pst.setString(10,mod.getCliMunicipio());
            pst.setString(11,mod.getCliBairro());
            pst.setString(12,mod.getCliCep());
            pst.setString(13,mod.getCliEmail());
            pst.setString(14,mod.getCliFone1());
            pst.setString(15,mod.getCliFone2());
            pst.setString(16,mod.getCliPessoa());
            pst.setString(17,mod.getCliRegis());
            pst.setString(18,mod.getCliCpfn());
            
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR ESTE CLIENTE! (VERIFICAR CPF JÁ CADASTRADO):" +ex);
            
        }
        conex.desconecta();
    }
    
    
    public void Editar (clientes mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update client set nome=?,rg=?,endereco=?,numero=?,municipio=?,bairro=?,email=?,fone1=?,fone2=? WHERE cpf=?");
            pst.setString(1,mod.getCliNome());
            pst.setString(2,mod.getCliRG());
            pst.setString(3,mod.getCliEndereco());
            pst.setString(4,mod.getCliNumero());
            pst.setString(5,mod.getCliMunicipio());
            pst.setString(6,mod.getCliBairro());
            pst.setString(7,mod.getCliEmail());
            pst.setString(8,mod.getCliFone1());
            pst.setString(9,mod.getCliFone2());
            pst.setString(10,mod.getCliCpf());
            
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do cliente alterado com sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR CADASTRO!" +ex);
            
        }
        conex.desconecta();
    }
    
    
}
