package jTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
// Robimy bez action listenera CheckBox
public class CelsiusToFahrenheit3 extends JFrame implements ActionListener{
	
	private JLabel lCelsius, lFahrenheit;
	private JTextField tCelsius, tFahrenheit;
	private JButton bKonwertuj;
	private ButtonGroup radioPanel;
	private JRadioButton rbCtoF, rbFtoC;
	

	
	private double tempCelsius, tempFahrenheit;
	
		
	public CelsiusToFahrenheit3() {
		
		
		//Ramka
		setSize(400,200);
		setTitle("Przeliczanie stopni Celsjusza na Fahrenheita");
		setLayout(null);
		//Etykieta
		lCelsius = new JLabel("Stopnie Celsjusza: ");
		lCelsius.setBounds(20, 20, 150, 20);
		add(lCelsius);
		//Pole tekstowe
		tCelsius = new JTextField("");
		tCelsius.setBounds(170, 20, 100, 20);
		add(tCelsius);
		tCelsius.addActionListener(this);
		tCelsius.setToolTipText("Podaj temperaturê w stopniach Celsjusza");
		
		
		//Etykieta
		lFahrenheit = new JLabel("Stopnie Fahrenheita: ");
		lFahrenheit.setBounds(20, 50, 150, 20);
		add(lFahrenheit);
		//Pole tekstowe
		tFahrenheit = new JTextField("");
		tFahrenheit.setBounds(170, 50, 100, 20);
		add(tFahrenheit);
		tFahrenheit.addActionListener(this);
		
		// przycisk
		bKonwertuj = new JButton("Konwertuj");
		bKonwertuj.setBounds(20, 80, 100, 20);
		add(bKonwertuj);
		
		bKonwertuj.addActionListener(this);
		
		//radioButtony
		radioPanel = new ButtonGroup();
		rbCtoF = new JRadioButton("Celsius to Fahrenheit");
		rbCtoF.setBounds(50,110, 150, 20);
		rbCtoF.setSelected(true);
		
		rbFtoC = new JRadioButton("Fahrenheit to Celsius");
		rbFtoC.setBounds(200,110, 150, 20);
		radioPanel.add(rbCtoF);
		radioPanel.add(rbFtoC);
		add(rbCtoF);
		add(rbFtoC);
		
	}
	
	public static void main(String[] args) {
		
		
		CelsiusToFahrenheit3 aplikacja = new CelsiusToFahrenheit3();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == bKonwertuj) {
			
		if(rbCtoF.isSelected()) {
			tempCelsius = Double.parseDouble(tCelsius.getText());
			tempFahrenheit = 32.0 + (9.0/5.0) * tempCelsius;
			tFahrenheit.setText(String.valueOf(tempFahrenheit));
		} else if (rbFtoC.isSelected()) {
			
			tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
			tempCelsius = (tempFahrenheit - 32.0) * (5.0/9.0);
			tCelsius.setText(String.valueOf(tempCelsius));
		}
	} 
			
			
		
		
		
	}

}
