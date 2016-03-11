/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author ErwinValle
 */



public class Valvula {
    
    public void open(){

    // the code
 JFrame valvula = new JFrame(); 
        Component panel = null;

valvula.getContentPane().add( panel,BorderLayout.CENTER ); 
    
valvula.addWindowListener( new WindowAdapter() { 
@Override
public void windowClosing( WindowEvent evt ) { 
System.exit( 0 ); 
} 
}

        }
}

/**
 *
 * @author user
 */
