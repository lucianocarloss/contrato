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
import java.awt.AWTKeyStroke;  
import java.awt.KeyboardFocusManager;  
import java.awt.event.KeyEvent;  
import java.util.HashSet;  
import javax.swing.JPanel;  
public class PassaCamposComEnter {  

    public PassaCamposComEnter(JPanel panelCampos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public void passaCamposComEnter(JPanel painel){  
        // Colocando enter para pular de campo  
        HashSet conj = new HashSet(painel.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));  
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));  
        painel.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);  
    }  
} 
