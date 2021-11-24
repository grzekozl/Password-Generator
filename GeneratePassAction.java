import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class GeneratePassAction implements ActionListener{
	
	private List<JCheckBox> ls;
	String smallLet, bigLet, numbers, specialChar, all, test;
	JTextArea ta;
	JFormattedTextField tf;
	int passLen;
	
	String putTogether;
	String generatedPass;
	
	public GeneratePassAction(List<JCheckBox> inList, JTextArea inTA, JFormattedTextField tf) {
		// TODO Auto-generated constructor stub
		putTogether= "";
		all = "";
		smallLet = "zaqwsxcderfvbgtyhnmjuiklop";
		bigLet = "ZAQWSXCDERFVBGTYHNMJUIKLOP";
		numbers = "1234567890";
		specialChar = "`~!@#$%^&*()_-+=|\\}]{[\"':;?/>.<,";
		
		
		ls = inList;
		ta = inTA;
		this.tf = tf;
		
		
		
		generatedPass = "";
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ls.get(0).isSelected())
			all += smallLet;
			
		if(ls.get(1).isSelected())
			all += bigLet;
			
		if(ls.get(2).isSelected())
			all += numbers;
			
		if(ls.get(3).isSelected())
			all += specialChar;
		
		
		if(tf.getValue() == null) {
			JOptionPane.showMessageDialog(null, "Podaj Dd³ugoœæ has³a, 8 do 20");
		}else {
			passLen = (Integer) tf.getValue();
			
			
			int ran;
			for(; passLen != 0; passLen--) {
				
				ran = (int) (Math.random() * 1000);
				ran = ran % all.length();
				
				generatedPass += all.charAt(ran);
				ta.setText(generatedPass);
				
			}
			
			generatedPass = "";
			all = new String();
			
		
			
		}
	}

}
