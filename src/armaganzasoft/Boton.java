/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package armaganzasoft;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

 
public class Botones extends JFrame{
	
	JButton encender = new JButton("Encender");
	JButton apagar = new JButton("Apagar");
 
	
	JPanel principal = new JPanel(new BorderLayout());
    private Object valvula;
 
	public Botones(){
		super("Botones");
		principal.add("North", encender);
		principal.add("South", apagar);
 
		getContentPane().add(principal);
 
		
		encender.setToolTipText("Botón ENCENDER...");                          
		apagar.setToolTipText("Botón APAGAR...");
                
                
                        
                pack();
		setResizable(false);
		Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
 
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
	}
 
	public static void main(String g[]){
		Botones p = new Botones();
		p.show();
 
		
			}

 boolean Botones = false;
        boolean Encender = false; 
        boolean Apagar = false;
        int opc;
        if (Botones == encender ){
            Scanner in=new Scanner (System.in);
            System.out.println("Que valvula Desea Encender");
            System.out.println("Elige una valvula:");
            System.out.println("1. Valvula #1");
            System.out.println("2. Valvula #2");
            opc= in.nextInt();

            System.out.println(opc+"Encendida");
        } else {
            if(Botones==Apagar){
                System.out.println("Se ha apagado la"+opc);
        
     } 
    

      }

        
}            
                 
