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
	JMenuItem mOtw�rz, mZapisz, mWyj�cie, mNarz1, mNarz2, mOpcja1, mOProgramie;
	JCheckBoxMenuItem chOpcja2;
	
	public JOptionPaneTest()
	{
		setTitle("Demonstracja JMenuBar");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//Pierwsza cz�� menu, pierwszy wiersz tworzy ca�e menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar); //wstawianie menu
		
		menuPlik = new JMenu("Plik");
		menuBar.add(menuPlik);
		mOtw�rz = new JMenuItem("Otw�rz", 'O'); //mnemoniki, po naci�ni�ciu O gdy b�dziemy w menu to wybierze nam to
		mZapisz = new JMenuItem("Zapisz");
		mWyj�cie = new JMenuItem("Wyj�cie");
		
		menuPlik.add(mOtw�rz);
		menuPlik.add(mZapisz);
		menuPlik.addSeparator();
		menuPlik.add(mWyj�cie);
		
		mWyj�cie.addActionListener(this); // do wyj�cia dodany Action Listener
		mWyj�cie.setAccelerator(KeyStroke.getKeyStroke("ctrl X")); //dodany skr�t klawiszowy
		
		//cz�� 2 narz�dzia
		menuNarzedzia = new JMenu("Narzedzia");
		menuBar.add(menuNarzedzia);
		mNarz1 = new JMenuItem("Narz�dzia 1");
		mNarz1.setEnabled(false); // Narz�dzia 1 b�d� nieaktywne
		mNarz2 = new JMenuItem("Narz�dzia 2");
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
			
		
		
		//cz�� 3 pomoc
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
		if(source == mWyj�cie) 
		{
			int odp = JOptionPane.showConfirmDialog(this, "Czy na pewno wyj�� ?", "Pytanie", JOptionPane.YES_NO_OPTION);
			
			if (odp == JOptionPane.YES_OPTION) dispose();
			else if (odp == JOptionPane.NO_OPTION) JOptionPane.showMessageDialog(null, "Wiedzia�em...");
			else if (odp == JOptionPane.CLOSED_OPTION) JOptionPane.showMessageDialog(null, "Tak nie robimy","Tytu�", JOptionPane.WARNING_MESSAGE);
		}
		
		if (source == chOpcja2 ) 
		{
			if (chOpcja2.isSelected()) mNarz1.setEnabled(true);
			else if (!chOpcja2.isSelected()) mNarz1.setEnabled(false);
			
		}
		
		if (source == mNarz2)
		{
			String sMetry = JOptionPane.showInputDialog("Podaj d�ugo�� w metrach");
			double metry = Double.parseDouble(sMetry);
			double stopy = metry/0.3048;
			String sStopy = String.format("%.2f ", stopy);
			JOptionPane.showMessageDialog(null, metry + " metr�w = " + sStopy + " st�p", "Metry na stopy", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		if (source == mOProgramie) {
			JOptionPane.showMessageDialog(this,"Program demonstruje wykorzystanie JMenuBar i JMenu \nWersja 1.0", "Tytu�", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public static void main(String[] args)
	{
		JOptionPaneTest appMenu = new JOptionPaneTest();
		appMenu.setVisible(true);
	}

}
