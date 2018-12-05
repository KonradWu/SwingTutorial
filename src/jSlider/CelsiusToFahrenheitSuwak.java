package jSlider;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CelsiusToFahrenheitSuwak extends JFrame implements ChangeListener
{
	private JLabel lCelsius, lFahrenheit;
	private JSlider sCelsius, sFahrenheit;
	private int tempCelsius, tempFahrenheit;
	
	
	public CelsiusToFahrenheitSuwak()
	{
		setSize(500,300);
		setTitle("Przeliczenie stopni Celsjusza na Fahrenheita");
		setLayout(null);
		
		sCelsius = new JSlider(0, 100, 0);
		sCelsius.setBounds(50, 50, 300, 50);
		sCelsius.setMajorTickSpacing(20);
		sCelsius.setMinorTickSpacing(5);
		sCelsius.setPaintTicks(true);
		sCelsius.setPaintLabels(true);
		sCelsius.addChangeListener(this);
		add(sCelsius);
		
		sFahrenheit = new JSlider(30, 212, 30);
		sFahrenheit.setBounds(50, 150, 300, 50);
		sFahrenheit.setMajorTickSpacing(20);
		sFahrenheit.setMinorTickSpacing(5);
		sFahrenheit.setPaintTicks(true);
		sFahrenheit.setPaintLabels(true);
		sFahrenheit.setEnabled(false);
		add(sFahrenheit);
		
		lCelsius = new JLabel("Celsius: ");
		lCelsius.setBounds(380, 50, 300, 50);
		add(lCelsius);
		
		lFahrenheit = new JLabel("Fahrenheit: ");
		lFahrenheit.setBounds(380, 150, 300, 50);
		add(lFahrenheit);

		
		
	}

	public static void main(String[] args)
	{
		CelsiusToFahrenheitSuwak aplikacja = new CelsiusToFahrenheitSuwak();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		tempCelsius = sCelsius.getValue();
		lCelsius.setText("Celsius: " + tempCelsius);
		
		tempFahrenheit = (int) Math.round(32 + (9.0/5.0)*tempCelsius);
		lFahrenheit.setText("Fahrenheit: " + tempFahrenheit);
		sFahrenheit.setValue(tempFahrenheit);
	
		
	}

}
