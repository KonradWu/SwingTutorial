package jPasswrodField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PasswordFiledTest extends JFrame implements ActionListener
{
	
	JPasswordField pHas�o;
	
	public PasswordFiledTest()
	{
		setTitle("Test has�a");
		setSize(400, 400);
		setLayout(null);
		
		pHas�o = new JPasswordField();
		pHas�o.setBounds(50, 50, 150, 20);
		pHas�o.setEchoChar('$'); //znaki dolara zamiast kropeczek
		pHas�o.addActionListener(this);
		add(pHas�o);
		
	}
	
	
	public static void main(String[] args) 
	{
		PasswordFiledTest app = new PasswordFiledTest();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setVisible(true);
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(null, Arrays.toString(pHas�o.getPassword()));
		JOptionPane.showMessageDialog(null, String.valueOf(pHas�o.getPassword()));
		JOptionPane.showMessageDialog(null, new String(pHas�o.getPassword()));
		
	}

}
