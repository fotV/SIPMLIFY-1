package src;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
public class SearchForm extends JFrame{
	private JPanel panel ;
	private JButton searchButton ;
	private JLabel keyLabel ;
	private JLabel chooseLabel ;
	private JList<String> list = new JList<String>(); ;
	private ArrayList<String> slist = new ArrayList<String>();
	private DefaultListModel<String> model= new DefaultListModel<String>();
	private JTextField key ;
	private User user ;
	
	public SearchForm(int type,User u)
	{
		
		panel = new JPanel();
		user = u;
		
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
		
		
		chooseLabel = new JLabel("Choose Field"); 
		chooseLabel.setFont(new Font("ÇelveticaNeue-Light", Font.PLAIN, 15));
		chooseLabel.setPreferredSize(new Dimension(120,180));
		panel.add(chooseLabel);
		
		
		list.setFont(new Font("ÇelveticaNeue-Light",Font.PLAIN,15));
		list.setPreferredSize(new Dimension(180,140));
		panel.add(list);
		
		keyLabel = new JLabel("Enter an input value ");
		keyLabel.setFont(new Font("ÇelveticaNeue-Light", Font.PLAIN, 15));
		keyLabel.setPreferredSize(new Dimension(187,140));
		panel.add(keyLabel);
		
		
		key = new JTextField("Type the text",15);
		key.setFont(new Font("ÇelveticaNeue-Light",Font.PLAIN,15));
		key.setPreferredSize(new Dimension(180,26));
		panel.add(key);
		
		
		searchButton =  new JButton("Search");
		searchButton.setFont(new Font("ÇelveticaNeue-Light", Font.PLAIN, 15));
		searchButton.setPreferredSize(new Dimension(159,26));
		panel.add(searchButton);
		
		
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean flag = checkForError(type,user);
				if (flag == true )
				{
					if (user instanceof OrderManager)
					{
						
						OrderManager u = (OrderManager) user;
						if (type==1)
						{
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
						else if (type==2) 
						{
							u.searchForProduct(key.getText(), list.getSelectedIndex());
						}
						else
						{
							u.searchForSupplier(key.getText(),list.getSelectedIndex());
						}
					}
					else if (user instanceof Stockkeeper) {
						
						Stockkeeper u = (Stockkeeper) user;
						if (type==1)
						{
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
						
					}
					else if (user instanceof Seller) {
						
						Seller u = (Seller) user;
						if (type==1)
						{
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
						else if (type==2) 
						{
							u.searchForProduct(key.getText(), list.getSelectedIndex());
						}
						else
						{
							u.searchForSupplier(key.getText(),list.getSelectedIndex());
						}
					}
					
				}
				}
				
		});
	
	
		
		panel.setBackground(new Color(153, 172, 196));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setTitle("SearchForm");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	private boolean checkForError(int type, User user)
	{
		
		boolean flag = false;
		if(list.getSelectedIndex()==-1) {
			
			if (key.getText().equals("Type the key") || key.getText().equals(""))
			{
				JOptionPane.showMessageDialog(panel,"Invalid input in key field and no field choosen");
			}
			else{
				JOptionPane.showMessageDialog(panel,"No field choosen");
			}
			
		}
		else if (list.getSelectedIndex() == 0 && (key.getText().length() != 6)) {
			
				JOptionPane.showMessageDialog(panel,"Invalid input in key field.");
				
		}
		else if (list.getSelectedIndex() == 4 ) {
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    sdf.setLenient(false);
			    if (sdf.parse(key.getText(), new ParsePosition(0)) == null) JOptionPane.showMessageDialog(panel,"Invalid input in key field.");
			
		}
		else if (list.getSelectedIndex() == 5 &&( key.getText().length() != 1 || key.getText().matches("[0-4]{1}") == false)) {
				
				JOptionPane.showMessageDialog(panel,"Invalid input in key field.");
			
		}
		else {                                                                                              
			flag = true;
		}
		return flag;
		
	}
	
	
	
	
}
