/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Engenharia03
 */
import java.text.ParseException;  
import javax.swing.JFormattedTextField;  
import javax.swing.JOptionPane;  
import javax.swing.JTextField;
  
  
public class FormataCampos {  
     private JFormattedTextField cnpj_cpf;  
  
    public String getCpfCnpjFormatado(String cpfCnpj) {  
        cnpj_cpf = new javax.swing.JFormattedTextField();  
  
        String valor = cpfCnpj.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "").replaceAll(" ", "");  
        if (valor.length() == 11) {  
            try {  
                cnpj_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));  
            } catch (ParseException ex) {  
                JOptionPane.showMessageDialog(null, ex.getMessage());  
            }  
        } else {  
            try {  
                cnpj_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));  
            } catch (ParseException ex) {  
                JOptionPane.showMessageDialog(null, ex.getMessage());  
            }  
        }  
        cnpj_cpf.setText(valor);  
  
        return cnpj_cpf.getText();  
  
    }  

    public void getCpfCnpjFormatado(JTextField jTCPF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}  
