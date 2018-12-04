package rownanieKwadratowe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RownanieGUI extends JFrame implements ActionListener{
	
	private JLabel lA, lB, lC;
	private JTextField tA, tB, tC, tWynik;
	private JButton bWyjscie, bRozwiaz;
	
	
	public RownanieGUI() {
		
		setSize(400,400);
		setTitle("Rozwi¹zywanie równania kwadratowego");
		setLayout(null);
		
		//dotyczy a
		lA = new JLabel("a", JLabel.RIGHT);
		lA.setBounds(10, 50, 30, 20);

		tA = new JTextField();
		tA.setBounds(50,50,50,20);
		tA.setToolTipText("Podaj wspó³czynnik a");
		
		
		//dotyczy B
		lB = new JLabel("b", JLabel.RIGHT);
		lB.setBounds(110, 50, 30, 20);
	
		
		tB = new JTextField();
		tB.setBounds(150,50,50,20);
		tB.setToolTipText("Podaj wspó³czynnik b");
		
		//dotyczy c
		lC = new JLabel("c", JLabel.RIGHT);
		lC.setBounds(210, 50, 30, 20);
		
		
		tC = new JTextField();
		tC.setBounds(250,50,50,20);
		tC.setToolTipText("Podaj wspó³czynnik c");
		
		//dodanie do ramki
		add(lA);		
		add(tA);		
		add(lB);		
		add(tB);
		add(lC);
		add(tC);
		
		//przycisk
		bRozwiaz = new JButton("Rozwi¹¿ równanie");
		bRozwiaz.setBounds(30, 150, 150, 20);
		bRozwiaz.addActionListener(this);
		
		bWyjscie = new JButton("Wyjœcie");
		bWyjscie.setBounds(220, 150, 100, 20);
		bWyjscie.addActionListener(this);
		
		add(bRozwiaz);
		add(bWyjscie);
		
		//Rozwiazanie
		tWynik = new JTextField();
		tWynik.setBounds(10, 200, 370, 20);
		add(tWynik);
	}
	

	public static void main(String[] args) {
		
		RownanieGUI app = new RownanieGUI();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == bWyjscie)
		{
			dispose();
		}
		else if (source == bRozwiaz)
		{
			int a = Integer.parseInt(tA.getText());
			int b = Integer.parseInt(tB.getText());
			int c = Integer.parseInt(tC.getText());
			
			RownanieKwadratowe rownanie = new RownanieKwadratowe(a, b, c);
			String rozwiazanie = rownanie.rozwiaz();
			tWynik.setText(rozwiazanie);
			
		}
	}
	




}
