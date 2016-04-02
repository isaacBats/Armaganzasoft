package armaganzasoft.interfaces;

import armaganzasoft.components.Valvula;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author Rodrigo
 */
public class Botones extends JFrame {
    
    JButton abrir = new JButton("Abrir");
    JButton cerrar = new JButton("Cerrar");
    
    private Valvula valvula;

    public void setValvula(Valvula valvula) {
        this.valvula = valvula;
    }

    
    JPanel principal = new JPanel(new BorderLayout());
    public Botones(){
        
            super("Botones");
            principal.add("North", abrir);
            principal.add("South", cerrar);

            getContentPane().add(principal);

            abrir.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed( ActionEvent arg ){
                    valvula.open();
                }
            
            });
            
            cerrar.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed( ActionEvent arg ){
                    valvula.close();
                }
            
            });

            pack();
            setResizable(false);
            Dimension pantalla, cuadro;
            pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            cuadro = this.getSize();

            this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
    }
                   
}
