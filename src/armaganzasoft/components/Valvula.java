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



public class Valvula extends Encendido {
public class Valvula {
    
    private String code;
    
    private String name;

    public Valvula(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Valvula() {
    
    }
    
    
    
  JFrame valvula = new JFrame();
    
    public void open(){

    // the code
         
        Component panel = null;
       

        valvula.getContentPane().add( panel,BorderLayout.CENTER ); 
    
        valvula.addWindowListener (new WindowAdapter() {}); { }
    }
    
    public void close(){
        finish();
        
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

    public String getCode() {
        
        return this.code;
    }
    
    public String getName(){
        
        return this.name;
    }

    private void finish() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
