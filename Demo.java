import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

public class Demo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Pole dla dlugosci hasla
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
			formatter.setValueClass(Integer.class);
			formatter.setMinimum(8);
			formatter.setMaximum(20);
			formatter.setCommitsOnValidEdit(true);
			
		JFormattedTextField passLenField = new JFormattedTextField(formatter);
			passLenField.setColumns(7);
			passLenField.setToolTipText("Dlugosc has³a 8-20 znakow");
			passLenField.setText("8");
			
		//Pole w ktorym wyswietli sie haslo
		JTextArea ta = new JTextArea(5,40);
			ta.setBackground(Color.lightGray);
			ta.setEditable(false);
			
		//Okienko programu
		JFrame mainFrame = new JFrame("Generator hasel");
			mainFrame.setSize(500,500);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setVisible(true);
			mainFrame.setLayout(new GridLayout(1,2));
			mainFrame.setLocationRelativeTo(null);
			
		//Glowny panel
		JPanel mainPanel = new JPanel();
			mainPanel.setBorder(BorderFactory.createSoftBevelBorder(2));
			mainPanel.setBackground(Color.gray);
			
		//Panel z checkboxami dla slownikow
		JPanel checkBoxsPanel = new JPanel();
			checkBoxsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(2), "Slowniki"));
			checkBoxsPanel.setBackground(Color.gray);
		
//		Lista checkboxow aby latwiej mozna bylo wyciagac dane z nim w zdarzeniu 
		List<JCheckBox> chkbxList = new ArrayList<JCheckBox>();
			JCheckBox smallLetBox = new JCheckBox("Male litery", true);
			JCheckBox bigLetBox = new JCheckBox("Duze Litery", true);
			JCheckBox numbersBox = new JCheckBox("Liczby", true);
			JCheckBox specialCharBox = new JCheckBox("Znaki specjalne", true);
			
			chkbxList.add(smallLetBox);
			chkbxList.add(bigLetBox);
			chkbxList.add(numbersBox);
			chkbxList.add(specialCharBox);
			
			//PEtla do ustawiani tla checkboxow
			for(JCheckBox jcb : chkbxList){
				jcb.setBackground(Color.gray);
			}
		
		//Przycisk z zdarzeniem generujacym hasla
		JButton generateButton = new JButton("Wygeneruj");
			generateButton.setSize(50,75);
			generateButton.addActionListener(new GeneratePassAction(chkbxList, ta, passLenField));
			
			
		JPanel buttAndField = new JPanel();
			buttAndField.add(passLenField);
			buttAndField.add(generateButton);
			buttAndField.setBackground(Color.gray);
			
		//Panel w ktorym znajduja sie checkboxy, pole dla dluhosci hasla i przycisk
		JPanel optionsPanel = new JPanel();
			optionsPanel.add(checkBoxsPanel);
			optionsPanel.add(buttAndField);
			optionsPanel.setLayout(new GridLayout(2,1));
			optionsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(2)));
			optionsPanel.setBackground(Color.gray);
			
		//Dodawanie elementow do okna
		checkBoxsPanel.add(chkbxList.get(0));
		checkBoxsPanel.add(chkbxList.get(1));
		checkBoxsPanel.add(chkbxList.get(2));
		checkBoxsPanel.add(chkbxList.get(3));
		mainPanel.add(optionsPanel);
		mainPanel.add(ta);
		mainFrame.add(mainPanel);
		
		//Odswiezanie okna
		SwingUtilities.updateComponentTreeUI(mainFrame);
	}

}

