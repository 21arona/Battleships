package vue;


import java.awt.Graphics;
import javax.swing.*;
public class graphics extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paint(Graphics g){
    
    g.drawRect(50, 35, 300, 300);  
    g.drawRect(400, 35, 300, 300); 
        
  }
   
  public static void main(String[] args){
    JFrame f = new JFrame("Dessiner un rectangle");
    f.getContentPane().add(new graphics());
    f.getContentPane().add(new graphics());
    f.setSize(760, 460);
    f.setVisible(true);
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}