/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Luciano
 */
public class data {
    
     public static void main (String args[])
    {   
     SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); 
      
     Calendar c = new GregorianCalendar(2004, 9, 2); 
      
     //System.out.println("Data: " + sd.format(c.getTime())); 
      
     c.add(Calendar.DAY_OF_MONTH, 60);
     System.out.println("Sessenta dias depois: " + sd.format(c.getTime()));
      
     c.add(Calendar.DAY_OF_MONTH, -1); 
     System.out.println("Um dia antes: " + sd.format(c.getTime())); 
      
     c.add(Calendar.MONTH, -1); 
     System.out.println("Um mês antes: " + sd.format(c.getTime())); 
      
     c = new GregorianCalendar(2003, Calendar.MARCH, 3); 
     System.out.println("Data: " + sd.format(c.getTime())); 
      
     c.add(Calendar.DAY_OF_MONTH, -1); 
     System.out.println("Um dia antes: " + sd.format(c.getTime())); 
      
     c.add(Calendar.MONTH, -1); 
     System.out.println("Um mês antes: " + sd.format(c.getTime()));
    };
    
}
