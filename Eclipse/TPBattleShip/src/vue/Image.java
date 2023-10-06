package vue;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import javax.swing.JPanel;
//import javax.swing.JPanel;

public class Image implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("JLabel test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(760, 460);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		String url = "Title.png";
		ImageIcon icone = new ImageIcon(url);
		
		JLabel label = new JLabel(icone,JLabel.CENTER);
		
		frame.add(label);

	
//		frame.setLayout(new GridLayout(4,1));
//		Icon icon = new ImageIcon("start.png");
//		JPanel b = new JPanel();
//		b.add(new JButton("JOUER "),icon);
//		
//		JPanel b1 = new JPanel();
//		b1.add(new JButton("OPTIONS "));
//		
//		JPanel b2 = new JPanel();
//		b2.add(new JButton("QUITTER "));
//		
//		b.setBounds(40,30,200,40);
//		
//		frame.add(b);frame.add(b1);frame.add(b2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}