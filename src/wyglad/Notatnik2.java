package wyglad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Notatnik2 extends JFrame implements ActionListener {
	
	JLabel label1;
	JButton bSzukaj, bWybierzKolor; 
	JPopupMenu popup;
	JMenuBar menuBar; 
	JMenu menuPlik, menuNarzedzia, mLookAndFeel, menuOpcje, menuPomoc;
	JMenuItem mOtw�rz, mZapisz, mWyj�cie, mNarz1, mNarz2, mMetal, mNimbus, mWindows, mpKopiuj, mpWklej, mpDo��cz, mOpcja1, mOProgramie;
	JTextField tSzukany;
	JCheckBoxMenuItem chOpcja2;
	JTextArea notatnik;
	JComboBox colorCombo;
	String wybranyTekst;
	
	public Notatnik2()
	{
		setTitle("Demonstracja JMenuBar");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//Pierwsza cz�� menu, pierwszy wiersz tworzy ca�e menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar); //wstawianie menu
		
		menuPlik = new JMenu("Plik");
		menuBar.add(menuPlik);
		mOtw�rz = new JMenuItem("Otw�rz", 'O'); //mnemoniki, po naci�ni�ciu O gdy b�dziemy w menu to wybierze nam to
		mOtw�rz.addActionListener(this);
		mZapisz = new JMenuItem("Zapisz");
		mZapisz.addActionListener(this);
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
			//drugi
		mLookAndFeel = new JMenu("Look and Feel");
		menuBar.add(mLookAndFeel);
			mMetal = new JMenuItem("Metal");
			mMetal.addActionListener(this);
			mNimbus = new JMenuItem("Nimbus");
			mNimbus.addActionListener(this);
			mWindows = new JMenuItem("Windows");
			mWindows.addActionListener(this);
			
			mLookAndFeel.add(mMetal);
			mLookAndFeel.add(mNimbus);
			mLookAndFeel.add(mWindows);
			
		
		
		//cz�� 3 pomoc
		menuBar.add(Box.createHorizontalGlue());
		
		menuPomoc = new JMenu("Pomoc");
		menuBar.add(menuPomoc);
		mOProgramie = new JMenuItem("O programie");
		mOProgramie.addActionListener(this);
		menuPomoc.add(mOProgramie);
		
		// dodajemy notatnik
		notatnik = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(notatnik); //s�u�y to do osadzenia notatnika
		//notatnik.setBounds(50, 50, 200, 200);
		scrollPane.setBounds(50, 50, 400, 400);
		add(scrollPane);
		
		
		//wyszukiwarka
		tSzukany = new JTextField();
		tSzukany.setBounds(50, 500, 100, 20);
		add(tSzukany);
		
		bSzukaj = new JButton("Szukaj");
		bSzukaj.setBounds(200, 500, 100, 20);
		add(bSzukaj);
		bSzukaj.addActionListener(this);
		
		//dodanie buttonu do wyboru koloru
		bWybierzKolor = new JButton("Wybierz kolor");
		bWybierzKolor.setBounds(350, 500, 150, 20);
		add(bWybierzKolor);
		bWybierzKolor.addActionListener(this);
		
		// Menu kontekstowe
		popup = new JPopupMenu();
		mpKopiuj = new JMenuItem("Kopiuj");
		mpKopiuj.addActionListener(this);
		mpWklej = new JMenuItem("Wklej");
		mpWklej.addActionListener(this);
		mpDo��cz = new JMenuItem("Do��cz");
		mpDo��cz.addActionListener(this);
		
		popup.add(mpKopiuj);
		popup.add(mpWklej);
		popup.add(mpDo��cz);
		
		notatnik.setComponentPopupMenu(popup);
		
		//Wstawiamy combo
		colorCombo = new JComboBox();
		colorCombo.setBounds(450, 50, 100, 20);
		colorCombo.addItem("czarny");
		colorCombo.addItem("czerwony");
		colorCombo.addItem("zielony");
		colorCombo.addItem("niebieski");
		add(colorCombo);
		colorCombo.addActionListener(this);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		//wstawiamy filechoosera
		if (source == mOtw�rz) 
		{
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File plik = fc.getSelectedFile();
				//JOptionPane.showMessageDialog(null, "Wybrany plik to " + plik.getAbsolutePath());// nazwa samego pliku  plik.getName()
				try 
				{
					Scanner skaner = new Scanner(plik);
					while(skaner.hasNextLine())
						notatnik.append(skaner.nextLine() + "\n");
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
			}
				
		} 
		else if  (source == mZapisz)
		{
			JFileChooser fc = new JFileChooser();
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File plik = fc.getSelectedFile();
				//JOptionPane.showMessageDialog(null, "Wybrany plik to " + plik);
				try 
				{
					PrintWriter pw = new PrintWriter(plik);
					Scanner skaner = new Scanner(notatnik.getText());
					while(skaner.hasNext())
					{
						pw.println(skaner.nextLine() + "\n");
					}
					pw.close();
				} 
				catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
			}
		}
		else if(source == mWyj�cie) 
		{
			int odp = JOptionPane.showConfirmDialog(this, "Czy na pewno wyj�� ?", "Pytanie", JOptionPane.YES_NO_OPTION);
			
			if (odp == JOptionPane.YES_OPTION) dispose();
			else if (odp == JOptionPane.NO_OPTION) JOptionPane.showMessageDialog(null, "Wiedzia�em...");
			else if (odp == JOptionPane.CLOSED_OPTION) JOptionPane.showMessageDialog(null, "Tak nie robimy","Tytu�", JOptionPane.WARNING_MESSAGE);
		}
		else if (source == chOpcja2 ) 
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
		else if (source == mOProgramie) {
			JOptionPane.showMessageDialog(this,"Program demonstruje wykorzystanie JMenuBar i JMenu \nWersja 1.0", "Tytu�", JOptionPane.WARNING_MESSAGE);
		}
		else if (source == bSzukaj)
		{
			String tekst = notatnik.getText();
			String szukane = tSzukany.getText();
			String wystapienia = "";
			int i = 0;
			int index;
			int startIndex = 0;
			while ((index = tekst.indexOf(szukane, startIndex)) != -1) 
			{
				startIndex = index + szukane.length();
				i++;
				wystapienia = wystapienia + " " + index;  
				
			}
			JOptionPane.showMessageDialog(null, szukane + " wyst�pi�o " + i + " razy: " + wystapienia);
			
		}
		else if (source == bWybierzKolor)
		{
			Color wybranyKolor = JColorChooser.showDialog(null, "Wyb�r koloru", Color.GREEN);
			notatnik.setForeground(wybranyKolor);
		}
		else if (source == mpKopiuj)
		{
			wybranyTekst = notatnik.getSelectedText();
		}
		else if (source == mpWklej)
		{
			notatnik.insert(wybranyTekst, notatnik.getCaretPosition());
		} 
		else if (source == mpDo��cz)
		{
			notatnik.append("\n" + wybranyTekst);
		}
		else if (source == colorCombo)
		{
			String color = colorCombo.getSelectedItem().toString();
			if (color.equals("zielony"))
				notatnik.setForeground(Color.GREEN);
			else if (color.equals("czarny"))
					notatnik.setForeground(Color.BLACK);
			else if (color.equals("czerwony"))
				notatnik.setForeground(Color.RED);
			else if (color.equals("niebieski"))
				notatnik.setForeground(Color.BLUE);
		}
		else if (source == mMetal) 
		{
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
			
				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		else if (source == mNimbus) 
		{
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
			
				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		else if (source == mWindows) 
		{
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.windowsxp.WindowsXPLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
			
				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		
	}
	
	public static void main(String[] args)
	{
		Notatnik2 appMenu = new Notatnik2();
		appMenu.setVisible(true);
	}

}
