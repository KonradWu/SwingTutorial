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
	
	// trzeba te pola tu podaæ ¿eby by³y widoczne w ró¿nych klasach
	JButton bPodajDate, bExit;
	//pole do wyœwietlenia daty
	JLabel lShowDate;
	
	public MojeOkienko() {
		
		//ustawienie rozmiaru okna startowego i tytulu
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Moje pierwsze okienko");
		
		
		setLayout(null); //po to ¿eby przycisk umieœciæ gdzieœ w setBounds
		//wstawiamy przycisk
		bPodajDate = new JButton("Podaj datê: ");
		bPodajDate.setBounds(20, 20, 100, 20); // x, y, szerokoœæ, wysokoœæ przycisku
		add(bPodajDate); //dodawanie komponentów do aktualnego panelu
		
		bPodajDate.addActionListener(this); //ramka jest s³uchaczem zdarzeñ wykonanych na button
		
		
		//drugi przycisk
		bExit = new JButton("Wyjœcie");
		bExit.setBounds(130, 20, 80, 20);
		add(bExit);
		bExit.addActionListener(this);
		
		//wyœwietlanie daty w polu w etykiecie
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
	
	// implementuj¹c interfejs ActionListener musimy dodaæ t¹ metodê
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//w zmienne source jest obiekt który by³ zród³em zdarzenia
		Object source = e.getSource();
		if (source == bPodajDate) {
			//wyœwietlenie daty w panelu
		lShowDate.setText("Data: " + new Date().toString());
		//System.out.println(new Date());
		}
		else if (source == bExit) {
			//wychodzi z programu
			dispose();
		}
 	}

}
