import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SelectionGui extends JFrame
{
	private String[] options;
	 //options[0] variable
	 //options[1] filter
     //options[2] key
     //options[3] chart
     //options[4] from month
	 //options[5] from year
	 //options[6] to month
	 //options[7] to year
	 
	private Boolean errorFlag; //false if there is no error else true
	private OrderManager om;
	private Seller seller;
	private String user;
	private String[] months;
	private JPanel panel;
	private int user2; //0 if ordermanager, 1 if seller created to help method checkerror for options[3] input
	
	public SelectionGui(OrderManager om)
	{	
		user = "om";
		errorFlag = false;
		options = new String[8];
		months = new String [12];
		months[0] = "January";
		months[1] = "February";
		months[2] = "March";
		months[3] = "April";
		months[4] = "May";
		months[5] = "June";
		months[6] = "July";
		months[7] = "August";
		months[8] = "September";
		months[9] = "October";
		months[10] = "November";
		months[11] = "December";
		
		
	}

	public SelectionGui(Seller seller)
	{	
		user = "seller";
		errorFlag = false;
		options = new String[8];
		months = new String [12];
		months[0] = "January";
		months[1] = "February";
		months[2] = "March";
		months[3] = "April";
		months[4] = "May";
		months[5] = "June";
		months[6] = "July";
		months[7] = "August";
		months[8] = "September";
		months[9] = "October";
		months[10] = "November";
		months[11] = "December";
		
		
	}
	

	public void initialize() 
	{
		
		if(user.equals("om"))
		{
			user2 = 0;
			String OMvariables[] = {"","Cost","Orders"};
			String OMfilter[] = {"","Date","Supplier","Product"};
			String charts[] = {"","Pie Chart","Line Chart","Bar Chart","Matrix"};
				
			JFrame f = new JFrame();
			f.getContentPane().setBackground(new Color(136, 177, 179));
			
			//variable
			
			JLabel var = new JLabel("Choose Variable :");
			var.setBounds(197, 45, 196, 30);
			var.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			f.getContentPane().add(var);
			
			JComboBox varCb = new JComboBox(OMvariables);
			varCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
			varCb.setBounds(504, 45, 264, 30);    
		    f.getContentPane().add(varCb);  
		    
		    //filter
		    
		    JLabel filter = new JLabel("Choose Filter :");
		    filter.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
		    filter.setBounds(197, 144, 196, 30);
			f.getContentPane().add(filter);
			
			JComboBox filterCb = new JComboBox(OMfilter);
			filterCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			filterCb.setBounds(504, 144, 264, 30);
			f.getContentPane().add(filterCb);
			
			//key
			
			JLabel key = new JLabel("Enter Key :");
			key.setBounds(197, 243, 196, 30);
			key.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			f.getContentPane().add(key);
			
			JTextField Ekey = new JTextField();
			Ekey.setBounds(504, 250, 264, 30);
			f.getContentPane().add(Ekey);
			
			JLabel message = new JLabel("Enter Key only if chosen filter is product or supplier");
			message.setBounds(504, 236,300, 14);
			message.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
			f.getContentPane().add(message);
			
			//chart
			
			JLabel chart = new JLabel("Choose Chart : ");
			chart.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			chart.setBounds(197, 361, 196, 30);
			f.getContentPane().add(chart);
			
			JComboBox chartCb = new JComboBox(charts);
			chartCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
			chartCb.setBounds(504, 367, 264, 30);
			f.getContentPane().add(chartCb);
			
			//from months
			
		    JLabel from = new JLabel("From :");
		    from.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
		    from.setBounds(197, 470, 107, 26);
			f.getContentPane().add(from);
			
			JComboBox fromMonth = new JComboBox(months);
			fromMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
			fromMonth.setBounds(399, 476, 150, 26);
			f.getContentPane().add(fromMonth);
			
			//to month
			
			JLabel to = new JLabel("To :");
			to.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			to.setBounds(197, 526, 46, 30);
			f.getContentPane().add(to);
			
			JComboBox toMonth = new JComboBox(months);
			toMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
			toMonth.setBounds(399, 534, 150, 26);
			f.getContentPane().add(toMonth);
			
			//year
			
			JLabel enterYear = new JLabel("Enter Year :");
			setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
			enterYear.setBounds(640, 449, 128, 20);
			f.getContentPane().add(enterYear);
		
			JTextField yearFrom = new JTextField();
			yearFrom.setBounds(604, 480, 164, 20);
			f.getContentPane().add(yearFrom);
			yearFrom.setColumns(10);
			
			JTextField yearTo = new JTextField();
			yearTo.setColumns(10);
			yearTo.setBounds(604, 538, 164, 20);
			f.getContentPane().add(yearTo);
			
			//seperators
			

			JSeparator separator = new JSeparator();
			separator.setBounds(8, 106, 1007, 2);
			f.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(8, 214, 1007, 2);
			f.getContentPane().add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(10, 318, 1007, 2);
			f.getContentPane().add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(8, 437, 1007, 2);
			f.getContentPane().add(separator_3);
			
			
			JButton b = new JButton("Ok");
			b.setBounds(915, 573, 85, 21); 
			f.getContentPane().add(b);
			
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					options[0] = (String) varCb.getSelectedItem();
					
					options[1] =(String) filterCb.getSelectedItem();
					
					options[2] = Ekey.getText();
					
					options[3] = (String) chartCb.getSelectedItem();
					
					options[4] = (String) fromMonth.getSelectedItem();
					
					options[5] = yearFrom.getText();
					
					options[6] = (String) toMonth.getSelectedItem();
					
					options[7] = yearTo.getText();
					
					errorFlag = checkError(options,user2);

					if(!errorFlag)
					{
						f.setVisible(false);
						Statistics ord = new Statistics(options,months);
						ord.OrdererStat(om);
	
					}
				
				}
					
			});
			
			f.setBounds(100, 100, 1041, 653);
			f.setTitle("Statistics");
			f.setLayout(null); 
			f.setVisible(true);
		
		}
		else if(user.equals("seller"))
		{
			user2 = 1;
			String Svariables[] = {"","Profit","Purchases"};
			String Sfilter[] = {"","Date","Client","Product"};
			String charts[] = {"","Pie Chart","Line Chart","Bar Chart","Matrix"};
					
			JFrame f = new JFrame();
			f.getContentPane().setBackground(new Color(136, 177, 179));

			//variable
			
			JLabel var = new JLabel("Choose Variable :");
			var.setBounds(197, 45, 196, 30);
			var.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			f.getContentPane().add(var);
			
			JComboBox varCb = new JComboBox(Svariables);
			varCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
			varCb.setBounds(504, 45, 264, 30);    
		    f.getContentPane().add(varCb);  
		    
		    //filter
		    
		    JLabel filter = new JLabel("Choose Filter :");
		    filter.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
		    filter.setBounds(197, 144, 196, 30);
			f.getContentPane().add(filter);
			
			JComboBox filterCb = new JComboBox(Sfilter);
			filterCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			filterCb.setBounds(504, 144, 264, 30);
			f.getContentPane().add(filterCb);
			
			//key
			
			JLabel key = new JLabel("Enter Key :");
			key.setBounds(197, 243, 196, 30);
			key.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			f.getContentPane().add(key);
			
			JTextField Ekey = new JTextField();
			Ekey.setBounds(504, 250, 264, 30);
			f.getContentPane().add(Ekey);
			
			JLabel message = new JLabel("Enter Key only if chosen filter is product or supplier");
			message.setBounds(504, 236,300, 14);
			message.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
			f.getContentPane().add(message);
			
			//chart
			
			JLabel chart = new JLabel("Choose Chart : ");
			chart.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			chart.setBounds(197, 361, 196, 30);
			f.getContentPane().add(chart);
			
			JComboBox chartCb = new JComboBox(charts);
			chartCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
			chartCb.setBounds(504, 367, 264, 30);
			f.getContentPane().add(chartCb);
			
			//from months
			
		    JLabel from = new JLabel("From :");
		    from.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
		    from.setBounds(197, 470, 107, 26);
			f.getContentPane().add(from);
			
			JComboBox fromMonth = new JComboBox(months);
			fromMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
			fromMonth.setBounds(399, 476, 150, 26);
			f.getContentPane().add(fromMonth);
			
			//to month
			
			JLabel to = new JLabel("To :");
			to.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			to.setBounds(197, 526, 46, 30);
			f.getContentPane().add(to);
			
			JComboBox toMonth = new JComboBox(months);
			toMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
			toMonth.setBounds(399, 534, 150, 26);
			f.getContentPane().add(toMonth);
			
			//year
			
			JLabel enterYear = new JLabel("Enter Year :");
			setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
			enterYear.setBounds(640, 449, 128, 20);
			f.getContentPane().add(enterYear);
		
			JTextField yearFrom = new JTextField();
			yearFrom.setBounds(604, 480, 164, 20);
			f.getContentPane().add(yearFrom);
			yearFrom.setColumns(10);
			
			JTextField yearTo = new JTextField();
			yearTo.setColumns(10);
			yearTo.setBounds(604, 538, 164, 20);
			f.getContentPane().add(yearTo);
			
			//seperators
			

			JSeparator separator = new JSeparator();
			separator.setBounds(8, 106, 1007, 2);
			f.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(8, 214, 1007, 2);
			f.getContentPane().add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(10, 318, 1007, 2);
			f.getContentPane().add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(8, 437, 1007, 2);
			f.getContentPane().add(separator_3);
			
			
			JButton b = new JButton("Ok");
			b.setBounds(915, 573, 85, 21); 
			f.getContentPane().add(b);
			
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					options[0] = (String) varCb.getSelectedItem();
					
					options[1] =(String) filterCb.getSelectedItem();
					
					options[2] = Ekey.getText();
					
					options[3] = (String) chartCb.getSelectedItem();
					
					options[4] = (String) fromMonth.getSelectedItem();
					
					options[5] = yearFrom.getText();
					
					options[6] = (String) toMonth.getSelectedItem();
					
					options[7] = yearTo.getText();
					
					errorFlag = checkError(options, user2);
					
					if(!errorFlag)
					{
						f.setVisible(false);
						Statistics sup = new Statistics(options, months);
						sup.SupplierStat(seller);
						
					}
					
				}
			
			});
		
			
			
			f.setSize(512, 383); 
			f.setTitle("Supplier Statistics");
			f.setLayout(null); 
			f.setVisible(true);
		
		}
	}
		private boolean checkError(String[] options, int user2)
		{
			int fromMonth = 0;
			int toMonth = 0;
			boolean keyExists = false; //true if key(id) of options[3] input exists in database
			
			errorFlag = false;
			
			//checking variable input
			
			if(options[0].isEmpty())
			{
				errorFlag = true;
				
				JOptionPane.showMessageDialog(null, "Variable Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
			
			//checking filter input
			
			if(options[1].isEmpty())
			{
				errorFlag = true;
				
				JOptionPane.showMessageDialog(null, "Filter Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
			
			//checking key input
			
			if((options[1] == "Supplier") || (options[1] == "Product") || (options[1] == "Client"))
			{
				if(options[2].isEmpty())
				{
					errorFlag = true;
					JOptionPane.showMessageDialog(null, "Key Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
					
				}
				
			}	
			  
		    //checking if options[2](key) input exists in database
		     
		     if((!options[2].isEmpty()) && (user2 == 0) )
		     {
		    	 if(options[2].equals("Product"))
		    	 {
			    	SupplierProducts productS = new SupplierProducts();
			    	ArrayList<SupplierProduct> sProd = productS.getSupplierProducts();
			    	for(int i = 0; i < sProd.size(); i++)
			    	{
			    		if(options[2].equals(sProd.get(i).getId()))
			    		{
			    			keyExists = true;
			    		}
			    	}
		    	 }
		    	 else if (options[2].equals("Supplier"))
		    	 {
		    		 Suppliers sup = new Suppliers();
		    		 ArrayList <Supplier> supplier = sup.getSuppliers();
		    		 for(int i = 0; i < supplier.size(); i++)
		    		 {
		    			 if(options[2].equals(supplier.get(i).getId()))
		    			 {
		    				 keyExists = true;
		    			 }
		    		 }
		    	 }
		     }
		     
		     if((keyExists == false) && (user2 == 0))
		     {
		    	 errorFlag = true;
		    	 JOptionPane.showMessageDialog(null, "Key ID doesn't exist.", "Invalid Input",JOptionPane.ERROR_MESSAGE);		
		     }
		     
		     if((!options[2].isEmpty()) && (user2 == 1) )
		     {
		    	 if(options[2].equals("Product"))
		    	 {
			    	CompanyProducts prod = new CompanyProducts();
			    	ArrayList<CompanyProduct> cProd = prod.getCompProduct();
			    	for(int i = 0; i < cProd.size(); i++)
			    	{
			    		if(options[2].equals(cProd.get(i).getId()))
			    		{
			    			keyExists = true;
			    		}
			    	}
		    	 }
		    	 else if (options[2].equals("Client"))
		    	 {
		    		 Buyers b = new Buyers();
		    		 ArrayList <Buyer> buyer = b.getBuyers();
		    		 for(int i = 0; i < buyer.size(); i++)
		    		 {
		    			 if(options[2].equals(buyer.get(i).getId()))
		    			 {
		    				 keyExists = true;
		    			 }
		    		 }
		    	 }
		     }
		     
		     if((keyExists == false) && (user2 == 1))
		     {
		    	 errorFlag = true;
		    	 JOptionPane.showMessageDialog(null, "Key doesn't exist.", "Invalid Input",JOptionPane.ERROR_MESSAGE);		
		     }
		     
		     //checking chart input
				
		     if(options[3].isEmpty())
			{
				errorFlag = true;
				
				JOptionPane.showMessageDialog(null, "Chart Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);		
			}
		     
		     //checking date input
		     
		     if(options[5].isEmpty())
		     {
		    	 JOptionPane.showMessageDialog(null, "Enter Year From Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
		     }
		     if(options[7].isEmpty())
		     {
		    	 JOptionPane.showMessageDialog(null, "Enter Year To Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
		     }
		     if(options[5].compareTo(options[7]) > 0)
		     {
		    	 JOptionPane.showMessageDialog(null, "Wrong Year Input.\"From Year\" Later Than \"To Year\"", "Invalid Input",JOptionPane.ERROR_MESSAGE);
		     }
		     if(options[5].compareTo(options[7])== 0)
			{
				for(int i = 0; i< 12; i++)
				{
					if(options[4].equals(months[i]))
					{
						fromMonth = i;
					}
					if(options[6].equals(months[i]))
					{
						toMonth = i;
					}
				}
				
				if(fromMonth > toMonth)
				{
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"Wrong Year Input.\"From Month\" Later Than \"To Month\"", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
				else if((fromMonth == toMonth) || ((toMonth - fromMonth) < 2))
				{
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"For the same year,month period must be at least two months apart", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		     //checking if year input is correct
		     
			if(!options[5].isEmpty())
			{
				if(((Integer.parseInt(options[5])) < 2010) || (Integer.parseInt(options[5])) > 2040)
				{
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"Wrong \"From Year\"  input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(!options[7].isEmpty())
			{
				if(((Integer.parseInt(options[7])) < 2010) || (Integer.parseInt(options[7])) > 2040)
				{
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"Wrong \"To Year\"  input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			return errorFlag;
		}
		
}

		
