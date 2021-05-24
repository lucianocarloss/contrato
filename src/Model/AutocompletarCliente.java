/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.JTextComponent;
import javax.swing.JComboBox;

/**
 *
 * @author Luciano
 */
public class AutocompletarCliente {
    
    Clientes cliente = new Clientes();
    
    public void MostrarDados(final JComboBox combobox){
        
        combobox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt){
                String cadenaEscrita = combobox.getEditor().getItem().toString();
                
                if (evt.getKeyCode() >= 65 && evt.getKeyCode()<= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8){
                    combobox.setModel(cliente.getLista(cadenaEscrita));
                    if (combobox.getItemCount() > 0){
                        combobox.showPopup();
                        
                        if (evt.getKeyCode()!=8){
                            ((JTextComponent)combobox.getEditor().getEditorComponent()).select(cadenaEscrita.length(), combobox.getEditor().getItem().toString().length());
                            
                        }else{
                            combobox.getEditor().setItem(cadenaEscrita);
                        }
                    }else{
                        combobox.addItem(cadenaEscrita);
                    }
                }
                
                
            }
            
});
        
    }
    
}
