/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author jmartinez
 */
public class HiloReloj extends Thread{
    
     JLabel hora;
     boolean seguir = true;
   
    public HiloReloj(JLabel hora){
   
        this.hora = hora;
    }
    
    @Override
   public void run() {
       
       while(seguir){
           
           Date hoy = new Date();
           SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
           hora.setText(sdf.format(hoy));
           try {
                this.sleep(1000);
           } catch (InterruptedException ex) {
                Logger.getLogger(HiloReloj.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
   }
   
   public void detenerReloj(){
       seguir=false;
   }
    
    
    
    
}
