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

public class CelsiusToFahrenheit extends JFrame implements ActionListener{
	
	private JLabel lCelsius, lFahrenheit;
	private JTextField tCelsius, tFahrenheit;
	private JButton bKonwertuj;
	private JCheckBox chBigLetters;
	private ButtonGroup bgRozmiar;
	private JRadioButton rbSmall, rbMedium, rbBig;
	
	private double tempCelsius, tempFahrenheit;
	
		
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
		tCelsius.addActionListener(this);
		tCelsius.setToolTipText("Podaj temperatur� w stopniach Celsjusza");
		
		
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
		chBigLetters.addActionListener(this);
		
		//robimy radio button
		bgRozmiar = new ButtonGroup();
		rbSmall = new JRadioButton("Small", true); // w jednym mo�e by� true a reszta false, �eby by� jeden wyb�r
		rbSmall.setBounds(50, 110, 100, 20);
		bgRozmiar.add(rbSmall);
		add(rbSmall);
		rbSmall.addActionListener(this);
		
		rbMedium = new JRadioButton("Medium", false);
		rbMedium.setBounds(150, 110, 100, 20);
		bgRozmiar.add(rbMedium);
		add(rbMedium);
		rbMedium.addActionListener(this);
		
		rbBig = new JRadioButton("Big", false);
		rbBig.setBounds(250, 110, 100, 20);
		bgRozmiar.add(rbBig);
		add(rbBig);
		rbBig.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		
		
		CelsiusToFahrenheit aplikacja = new CelsiusToFahrenheit();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == bKonwertuj || source == tCelsius) {
			
		tempCelsius = Double.parseDouble(tCelsius.getText());
		tempFahrenheit = 32.0 + (9.0/5.0) * tempCelsius;
		tFahrenheit.setText(String.valueOf(tempFahrenheit));
		
		} else if(source == chBigLetters) {
			
			if(chBigLetters.isSelected()) {
				
				tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 18 ));
				
			} else {
				
				tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12 ));
				
			}
		} else if(source == rbSmall ) {
			
			tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 8 ));
		} else if(source == rbMedium ) {
			
			tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 14 ));
		} else if(source == rbBig ) {
			
			tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 20 ));
		}
		
		
	}

}
