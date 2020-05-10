import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
public class SearchForm extends JFrame{
	private JPanel panel = new JPanel();
	private JButton searchButton = new JButton("Search");
	private JLabel keyLabel = new JLabel();
	private JLabel chooseLabel = new JLabel("Choose Field");
	private JList<String> list = new JList<String>();
	private ArrayList<String> slist = new ArrayList<String>();
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JTextField key = new JTextField(15);
	private User user = new User();
	
	public SearchForm(int type)
	{
		
		//user = u;
		if (type==1) {
			
			slist.add("Order Id  ");
			slist.add("Supplier Id  ");
			slist.add("Product Id  ");
			slist.add("Product Name ");
			slist.add("Date  ");
			slist.add("Status");
			
		}
		else if (type==2) {
			
			slist.add("Product Id");
			slist.add("Product Name");
			slist.add("Supplier Id");
			
		}
		else {
			
			slist.add("Id ");
			slist.add("Name");
			slist.add("Last Name ");
			slist.add("AFM");
			
			
		}
		list.setModel(model);
		for(String s: slist) {
			model.addElement(s);
		}
		panel.add(chooseLabel);
		panel.add(list);
		panel.add(keyLabel);
		panel.add(key);
		panel.add(searchButton);
		
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				checkForError();
				
			}
		});
	
	
		
		panel.setBackground(new Color(135, 206, 235));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setTitle("SearchForm");
		this.setBounds(100, 100, 450, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	private void checkForError()
	{
		if(list.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(panel,"No field choosen");
		}
		if(key.getText()=="")
		{
			JOptionPane.showMessageDialog(panel,"No key was written");
		}
	}
	
	
	
	
}
