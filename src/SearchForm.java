
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
	/*
	 * SearchForm.java
	 * Purpose: Shows a GUI for searching .
	 * @author Evangelia Papagiannaki.
	 * @version 1.0
	 */
	private JPanel panel;
	private JButton searchButton;
	private JLabel keyLabel;
	private JLabel chooseLabel;
	private JTextField key ;
	private User user ;
	private JList<String> list = new JList<String>(); 
	private ArrayList<String> slist = new ArrayList<String>();
	private DefaultListModel<String> model= new DefaultListModel<String>();
	
	
	public SearchForm(int type,User u)
	{
		panel = new JPanel();
		user = u;
		
		if (type==1) {                    //sets the strings that are needed for searching an order
			slist.add("Order Id  ");
			slist.add("Supplier Id  ");
			slist.add("Product Id  ");
			slist.add("Product Name ");
			slist.add("Date  ");
			slist.add("Status");
		}
		else if (type==2) {			     //sets the strings that are needed for searching a SupplierProduct/CompanyProduct
			slist.add("Product Id");
			slist.add("Product Name");
			slist.add("Supplier Id");
		}
		else {
			slist.add("Id ");			//sets the strings that are needed for searching a Buyer/Supplier
			slist.add("Name");
			slist.add("Last Name ");
			slist.add("AFM");
		}
		
		list.setModel(model);
		for(String s: slist) {
			model.addElement(s);
		}
		
		
				
		chooseLabel = new JLabel("Choose Field");                                          
		chooseLabel.setFont(new Font("ΗelveticaNeue", Font.BOLD, 17));
		chooseLabel.setPreferredSize(new Dimension(120,180));
		chooseLabel.setBounds(225, 335, 159, 32);
		panel.add(chooseLabel);
		
		
		list.setFont(new Font("ΗelveticaNeue", Font.PLAIN, 15));
		list.setPreferredSize(new Dimension(200, 140));
		list.setSelectionBackground(new Color(255, 152, 61));
		panel.add(list);
		
		
		keyLabel = new JLabel("Enter an input value ");
		keyLabel.setFont(new Font("ΗelveticaNeue", Font.BOLD, 17));
		keyLabel.setBounds(1200, 1300, 100, 50);
		panel.add(keyLabel);
		
		
		key = new JTextField("Type the text",20);
		key.setFont(new Font("ΗelveticaNeue",Font.PLAIN,15));
		key.setPreferredSize(new Dimension(180,26));
		panel.add(key);
		
		
		searchButton =  new JButton("Search");
		searchButton.setFont(new Font("ΗelveticaNeue-Light", Font.PLAIN, 17));
		searchButton.setPreferredSize(new Dimension(159,26));
		panel.add(searchButton);
		
		
		
		
		
		
		
		
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean flag = checkForError(type,user);
				if (flag == true )														  // if there are not errors in the form
				{
					if (user instanceof OrderManager)                                     // if user is OrderManager
					{
						OrderManager u = (OrderManager) user;
						if (type==1) {                                                    //searching for an Order
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
						else if (type==2) {                                               //searching for a SupplierProduct
							u.searchForProduct(key.getText(), list.getSelectedIndex());
						}
						else {                                                            //searching for a Supplier
							u.searchForSupplier(key.getText(),list.getSelectedIndex());
						}
					}
					else if (user instanceof Stockkeeper) {                               // if user is Stockkeeper
						Stockkeeper u = (Stockkeeper) user;
						if (type==1) {						                              // searching for an Order
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
					}
					else if (user instanceof Seller){                                    // if user is Seller 
						Seller u = (Seller) user;
						if (type==1){                                                    // searching for an Order
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
						else if (type==2) {                                              //searching for a CompanyProduct
							u.searchForProduct(key.getText(), list.getSelectedIndex());
						}
						else{                                                            //searching for a Supplier
							u.searchForBuyer(key.getText(),list.getSelectedIndex());
						}
					}
				}
			}	
		});
		panel.setBackground(new Color(136, 177, 179));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setTitle("SearchForm");
		this.setSize(100, 100, 1041, 653);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Checks for errors in the form.
	 * @param type   the type of searching
	 * @param user   the type of user who wants to do the searching
	 * @return flag  true only if there are not errors in the form
	 */
	private boolean checkForError(int type, User user)
	{
		boolean flag = false;
		if(list.getSelectedIndex()==-1) {                                                                              //if the user did not select a field from the list
			if (key.getText().equals("Type the key") || key.getText().equals("")){                                     // if the key field does not have the correct input
				JOptionPane.showMessageDialog(panel,"Invalid input in key field and no field choosen");
			}                                                                                                         
			else{                                                                                                      // if the key field containt the correct input
				JOptionPane.showMessageDialog(panel,"No field choosen");
			}
		}
		else if (list.getSelectedIndex() == 0 && (key.getText().length() != 6)) {                                      //if the user selected the first field from the list and key field does not have 6 characters
			JOptionPane.showMessageDialog(panel,"Invalid input in key field.");		
		}
		else if (list.getSelectedIndex() == 4 ) {                                                                     //if the user selected the fifth field from the field 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			if (sdf.parse(key.getText(), new ParsePosition(0)) == null) {                                             //if key field does not have the correct format for date
			    JOptionPane.showMessageDialog(panel,"Invalid input in key field.");   
			}
		}
		else if (list.getSelectedIndex() == 5 &&( key.getText().length() != 1 || key.getText().matches("[0-4]{1}") == false)) {     //if sixth field was choosen from the list and key field length does not have 1 character or contain digits other than [0-4].	
			JOptionPane.showMessageDialog(panel,"Invalid input in key field.");
		}
		else {                                                                                                                     //if none of the above are true                                                                               
			flag = true;
		}
		return flag;
	}
}
