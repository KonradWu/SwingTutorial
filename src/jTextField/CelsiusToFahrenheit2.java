package jTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
// Robimy bez action listenera CheckBox
public class CelsiusToFahrenheit2 extends JFrame implements ActionListener{
	
	private JLabel lCelsius, lFahrenheit;
	private JTextField tCelsius, tFahrenheit;
	private JButton bKonwertuj;
	private JCheckBox chBigLetters;

	
	private double tempCelsius, tempFahrenheit;
	
		
	public CelsiusToFahrenheit2() {
		
		
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
		tCelsius.setBounds(170, 20, 50, 20);
		add(tCelsius);
		tCelsius.addActionListener(this);
		tCelsius.setToolTipText("Podaj temperaturê w stopniach Celsjusza");
		
		
		//Etykieta
		lFahrenheit = new JLabel("Stopnie Fahrenheita: ");
		lFahrenheit.setBounds(20, 50, 150, 20);
		add(lFahrenheit);
		//Pole tekstowe
		tFahrenheit = new JTextField("");
		tFahrenheit.setBounds(170, 50, 50, 20);
		add(tFahrenheit);
		
		// przycisk
		bKonwertuj = new JButton("Konwertuj");
		bKonwertuj.setBounds(20, 80, 100, 20);
		add(bKonwertuj);
		
		bKonwertuj.addActionListener(this);
		
		//Check Box
		chBigLetters = new JCheckBox("Wielkie litery");
		chBigLetters.setBounds(120,80,150,20);
		add(chBigLetters);
		//chBigLetters.addActionListener(this);
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		
		CelsiusToFahrenheit2 aplikacja = new CelsiusToFahrenheit2();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == bKonwertuj || source == tCelsius) {
			//obs³uga checkBoxa jest wrzucona tutaj
			if(chBigLetters.isSelected()) {
				
				tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 18 ));
				
			} else {
				
				tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12 ));
				
			}
			
		tempCelsius = Double.parseDouble(tCelsius.getText());
		tempFahrenheit = 32.0 + (9.0/5.0) * tempCelsius;
		tFahrenheit.setText(String.valueOf(tempFahrenheit));
		
		} 
			
			
		
		
		
	}

}
