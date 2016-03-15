package armaganzasoft.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.System.exit;
import javax.swing.JFrame;
import static jdk.nashorn.internal.objects.NativeJava.extend;

/**
 *
 * @author Rodrigo
 */



public class Valvula {
    
  JFrame valvula = new JFrame();
    
    public void open(){

    // the code
         
        Component panel = null;
       

        valvula.getContentPane().add( panel,BorderLayout.CENTER ); 
    
        valvula.addWindowListener (new WindowAdapter() {}); { }
    }
    
    public void close(){
        // Aqui va tu codigo Ewin
    }
    
    public void estado(){
        int valvula=0, habilitado, alerta, desabilitado;
        if(valvula<=4){
            mensaje.showMessageDialog(mensaje,"valvula encendida", "ENCENDIDA",mensaje.INFORMATION_MESSAGE);
        }else{
            if(valvula>=4){
             mensaje.showMessageDialog(mensaje,"valvula en peligro ", "PELIGRO",mensaje.WARNING_MESSAGE);   
            }else{
                mensaje.showMessageDialog(mensaje,"valvula desabilitada","APAGADO",mensaje.ERROR_MESSAGE);
            }
        }
    
    }
    
    private javax.swing.JOptionPane mensaje;
}

        
        
     
