package jPasswrodField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PasswordFiledTest extends JFrame implements ActionListener
{
	
	JPasswordField pHas這;
	
	public PasswordFiledTest()
	{
		setTitle("Test has豉");
		setSize(400, 400);
		setLayout(null);
		
		pHas這 = new JPasswordField();
		pHas這.setBounds(50, 50, 150, 20);
		pHas這.setEchoChar('$'); //znaki dolara zamiast kropeczek
		pHas這.addActionListener(this);
		add(pHas這);
		
	}
	
	
	public static void main(String[] args) 
	{
		PasswordFiledTest app = new PasswordFiledTest();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setVisible(true);
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(null, Arrays.toString(pHas這.getPassword()));
		JOptionPane.showMessageDialog(null, String.valueOf(pHas這.getPassword()));
		JOptionPane.showMessageDialog(null, new String(pHas這.getPassword()));
		
	}

}
