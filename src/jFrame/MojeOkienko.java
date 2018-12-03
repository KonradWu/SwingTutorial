package jFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MojeOkienko extends JFrame implements ActionListener{
	
	public final static int DEFAULT_WIDTH = 300;
	public final static int DEFAULT_HEIGHT = 200;
	
	// trzeba te pola tu poda� �eby by�y widoczne w r�nych klasach
	JButton bPodajDate, bExit;
	//pole do wy�wietlenia daty
	JLabel lShowDate;
	
	public MojeOkienko() {
		
		//ustawienie rozmiaru okna startowego i tytulu
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Moje pierwsze okienko");
		
		
		setLayout(null); //po to �eby przycisk umie�ci� gdzie� w setBounds
		//wstawiamy przycisk
		bPodajDate = new JButton("Podaj dat�: ");
		bPodajDate.setBounds(20, 20, 100, 20); // x, y, szeroko��, wysoko�� przycisku
		add(bPodajDate); //dodawanie komponent�w do aktualnego panelu
		
		bPodajDate.addActionListener(this); //ramka jest s�uchaczem zdarze� wykonanych na button
		
		
		//drugi przycisk
		bExit = new JButton("Wyj�cie");
		bExit.setBounds(130, 20, 80, 20);
		add(bExit);
		bExit.addActionListener(this);
		
		//wy�wietlanie daty w polu w etykiecie
		lShowDate = new JLabel("Data: ");
		lShowDate.setBounds(20, 50, 250, 20);
		//lShowDate.setForeground(Color.RED);
		lShowDate.setForeground(new Color(0, 100, 255 ));
		lShowDate.setFont(new Font("SansSerif", Font.BOLD, 13));
		add(lShowDate);
	}

	public static void main(String[] args) {
		
		MojeOkienko frame = new MojeOkienko();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	// implementuj�c interfejs ActionListener musimy doda� t� metod�
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//w zmienne source jest obiekt kt�ry by� zr�d�em zdarzenia
		Object source = e.getSource();
		if (source == bPodajDate) {
			//wy�wietlenie daty w panelu
		lShowDate.setText("Data: " + new Date().toString());
		//System.out.println(new Date());
		}
		else if (source == bExit) {
			//wychodzi z programu
			dispose();
		}
 	}

}
