package jOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class JOptionPaneTest extends JFrame implements ActionListener {
	
	
	JMenuBar menuBar; 
	JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
	JMenuItem mOtwórz, mZapisz, mWyjœcie, mNarz1, mNarz2, mOpcja1, mOProgramie;
	JCheckBoxMenuItem chOpcja2;
	
	public JOptionPaneTest()
	{
		setTitle("Demonstracja JMenuBar");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//Pierwsza czêœæ menu, pierwszy wiersz tworzy ca³e menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar); //wstawianie menu
		
		menuPlik = new JMenu("Plik");
		menuBar.add(menuPlik);
		mOtwórz = new JMenuItem("Otwórz", 'O'); //mnemoniki, po naciœniêciu O gdy bêdziemy w menu to wybierze nam to
		mZapisz = new JMenuItem("Zapisz");
		mWyjœcie = new JMenuItem("Wyjœcie");
		
		menuPlik.add(mOtwórz);
		menuPlik.add(mZapisz);
		menuPlik.addSeparator();
		menuPlik.add(mWyjœcie);
		
		mWyjœcie.addActionListener(this); // do wyjœcia dodany Action Listener
		mWyjœcie.setAccelerator(KeyStroke.getKeyStroke("ctrl X")); //dodany skrót klawiszowy
		
		//czêœæ 2 narzêdzia
		menuNarzedzia = new JMenu("Narzedzia");
		menuBar.add(menuNarzedzia);
		mNarz1 = new JMenuItem("Narzêdzia 1");
		mNarz1.setEnabled(false); // Narzêdzia 1 bêd¹ nieaktywne
		mNarz2 = new JMenuItem("Narzêdzia 2");
		mNarz2.addActionListener(this);
		menuNarzedzia.add(mNarz1);
		menuNarzedzia.add(mNarz2);
		
			menuOpcje = new JMenu("Opcje");
			mOpcja1 = new JMenuItem("Opcja1");
			chOpcja2 = new JCheckBoxMenuItem("Opcja2");
			chOpcja2.addActionListener(this);
			
			menuOpcje.add(mOpcja1);
			menuOpcje.add(chOpcja2);
		menuNarzedzia.add(menuOpcje);
			
		
		
		//czêœæ 3 pomoc
		menuBar.add(Box.createHorizontalGlue());
		
		menuPomoc = new JMenu("Pomoc");
		menuBar.add(menuPomoc);
		mOProgramie = new JMenuItem("O programie");
		mOProgramie.addActionListener(this);
		menuPomoc.add(mOProgramie);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if(source == mWyjœcie) 
		{
			int odp = JOptionPane.showConfirmDialog(this, "Czy na pewno wyjœæ ?", "Pytanie", JOptionPane.YES_NO_OPTION);
			
			if (odp == JOptionPane.YES_OPTION) dispose();
			else if (odp == JOptionPane.NO_OPTION) JOptionPane.showMessageDialog(null, "Wiedzia³em...");
			else if (odp == JOptionPane.CLOSED_OPTION) JOptionPane.showMessageDialog(null, "Tak nie robimy","Tytu³", JOptionPane.WARNING_MESSAGE);
		}
		
		if (source == chOpcja2 ) 
		{
			if (chOpcja2.isSelected()) mNarz1.setEnabled(true);
			else if (!chOpcja2.isSelected()) mNarz1.setEnabled(false);
			
		}
		
		if (source == mNarz2)
		{
			String sMetry = JOptionPane.showInputDialog("Podaj d³ugoœæ w metrach");
			double metry = Double.parseDouble(sMetry);
			double stopy = metry/0.3048;
			String sStopy = String.format("%.2f ", stopy);
			JOptionPane.showMessageDialog(null, metry + " metrów = " + sStopy + " stóp", "Metry na stopy", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		if (source == mOProgramie) {
			JOptionPane.showMessageDialog(this,"Program demonstruje wykorzystanie JMenuBar i JMenu \nWersja 1.0", "Tytu³", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public static void main(String[] args)
	{
		JOptionPaneTest appMenu = new JOptionPaneTest();
		appMenu.setVisible(true);
	}

}
