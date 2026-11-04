package modelo;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana extends JFrame 
{
    private JTextArea area = new JTextArea();

    
    
    public Ventana()
    {
	JScrollPane scroll=new JScrollPane(area);
	this.getContentPane().add(scroll);
	this.setVisible(true);
	this.setSize(new Dimension(600,600));
	
    }
    
    
    
    public void appendText(String arg)
    {
	    this.area.append(arg+"\n");
    }
    
    
    
    
    
    
    
    
    

        
    

}
