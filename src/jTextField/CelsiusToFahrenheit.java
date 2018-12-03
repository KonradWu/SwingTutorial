package jTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CelsiusToFahrenheit extends JFrame implements ActionListener{
	
	JLabel lCelsius, lFahrenheit;
	JTextField tCelsius, tFahrenheit;
	JButton bKonwertuj;
	
	double tempCelsius, tempFahrenheit;
	
		
	public CelsiusToFahrenheit() {
		
		
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
		
		
		//Etykieta
		lFahrenheit = new JLabel("Stopnie Fahrenheita: ");
		lFahrenheit.setBounds(20, 50, 150, 20);
		add(lFahrenheit);
		//Pole tekstowe
		tFahrenheit = new JTextField("");
		tFahrenheit.setBounds(170, 50, 50, 20);
		add(tFahrenheit);
		
		bKonwertuj = new JButton("Konwertuj");
		bKonwertuj.setBounds(20, 80, 100, 20);
		add(bKonwertuj);
		
		bKonwertuj.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		
		CelsiusToFahrenheit aplikacja = new CelsiusToFahrenheit();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tempCelsius = Double.parseDouble(tCelsius.getText());
		tempFahrenheit = 32.0 + (9.0/5.0) * tempCelsius;
		tFahrenheit.setText(String.valueOf(tempFahrenheit));
		
		
	}

}
