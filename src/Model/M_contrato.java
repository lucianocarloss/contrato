/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Ferramenta.ConexaoBD;
import Ferramenta.clientes;
import Ferramenta.contrato;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBIntrospector;
import org.apache.poi.hssf.record.PageBreakRecord;

/**
 *
 * @author Luciano
 */
public class M_contrato {
    
    ConexaoBD conex = new ConexaoBD();
    contrato mod = new contrato();
    String r = null;
    
    public static String erro (){
        String r;
        r = "erro";
       return r; 
    }
    

    
    public void SalvarC (contrato mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into contratos(id2,ano,cpf,registro,cliente,endereco,numero,cidade,bairro,cep,uf,complemento,email,fone1,fone2,entrega,itens,amb1,amb2,amb3,amb4,amb5,amb6,amb7,amb8,vl1,vl2,vl3,vl4,vl5,vl6,vl7,vl8,total) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getClicontrato());
            pst.setString(2,mod.getClicdata());
            pst.setString(3,mod.getCliccpf());
            pst.setString(4,mod.getClicrg());
            pst.setString(5,mod.getCliconome());
            pst.setString(6,mod.getClicendereco());
            pst.setString(7,mod.getClicnumero());
            pst.setString(8,mod.getCliccidade());
            pst.setString(9,mod.getClicbairro());
            pst.setString(10,mod.getCliccep());
            pst.setString(11,mod.getClicuf());
            pst.setString(12,mod.getCliccomplemento());
            pst.setString(13,mod.getClicemail());
            pst.setString(14,mod.getClicfone1());
            pst.setString(15,mod.getClicfone2());
            pst.setString(16,mod.getClicentrega());
            pst.setString(17,mod.getClicitens());
            pst.setString(18,mod.getClicamb1());
            pst.setString(19,mod.getClicamb2());
            pst.setString(20,mod.getClicamb3());
            pst.setString(21,mod.getClicamb4());
            pst.setString(22,mod.getClicamb5());
            pst.setString(23,mod.getClicamb6());
            pst.setString(24,mod.getClicamb7());
            pst.setString(25,mod.getClicamb8());
            pst.setString(26,mod.getClicval1());
            pst.setString(27,mod.getClicval2());
            pst.setString(28,mod.getClicval3());
            pst.setString(29,mod.getClicval4());
            pst.setString(30,mod.getClicval5());
            pst.setString(31,mod.getClicval6());
            pst.setString(32,mod.getClicval7());
            pst.setString(33,mod.getClicval8());
            pst.setString(34,mod.getClictotal());
            
            
            pst.execute();
            erro();
           // JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR CONTRATO!/nErro:" +ex);
            erro();
        }
        conex.desconecta();
    }
    
    
}
