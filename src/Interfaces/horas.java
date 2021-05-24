/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Luciano
 */
public class horas {
    
    public static void start(final JLabel labelHorario){
        Thread atualizaHora = new Thread(new Runnable(){
            @Override
            public void run(){
              try {
                  while (true) {
                      Date date = new Date();
                      StringBuffer data = new StringBuffer();
                      SimpleDateFormat sdf = new SimpleDateFormat();
                      labelHorario.setText(data.toString() + sdf.format(date));
                      Thread.sleep(1000);
                      labelHorario.revalidate();
                  }
                  }catch (InterruptedException ex){
                  ex.printStackTrace();                    
                  }
                  
              }  
            }
        );
    atualizaHora.start();
}
        
}


