package armaganzasoft;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class Botones extends JFrame{
	
	JButton encender = new JButton("Encender");
	JButton apagar = new JButton("Apagar");
 
	
	JPanel principal = new JPanel(new BorderLayout());
 
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
 
		p.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
		}
	}
}