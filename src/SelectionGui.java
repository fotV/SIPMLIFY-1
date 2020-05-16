import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class SelectionGui  extends JFrame
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
			private User user;
			private String[] months;
			private JPanel panel;
			private int user2; //0 if ordermanager, 1 if seller created to help method checkerror for options[3] input
			
			public SelectionGui(User user)
			{	
				this.user = user;
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
			
	
			public String[] getOptions()
			{
				return options;
			}
			
			public String[] getMonths()
			{
				return months;  
			}
			
			public void initialize() 
			{
				
				JFrame f = new JFrame();
				JPanel panel=new JPanel();  
				
				f.getContentPane().setBackground(new Color(176, 224, 230));
	
				if(user instanceof OrderManager)
				{
					user2 = 0;
					String OMvariables[] = {"","Cost","Orders"};
					String OMfilter[] = {"","Date","Supplier","Product"};
					String charts[] = {"","Pie Chart","Line Chart","Bar Chart","Matrix"};
							
					JLabel var = new JLabel("Choose Variable :");
					var.setBounds(8, 20, 100, 14);
					f.getContentPane().add(var);
					
					JComboBox varCb = new JComboBox(OMvariables);   
					varCb.setBounds(117, 16, 89, 22);    
				    f.getContentPane().add(varCb);  
				    
				    JLabel filter = new JLabel("Choose Filter :");
				    filter.setBounds(8, 66, 100, 14);
					f.getContentPane().add(filter);
					
					JComboBox filterCb = new JComboBox(OMfilter);
					filterCb.setBounds(117, 62, 89, 22);
					f.getContentPane().add(filterCb);
					
					JLabel key = new JLabel("Enter Key :");
					key.setBounds(8, 113, 100, 14);
					f.getContentPane().add(key);
					
					JTextField Ekey = new JTextField();
					Ekey.setBounds(117, 110, 89, 20);
					f.getContentPane().add(Ekey);
					
					JLabel message = new JLabel("Enter Key only if chosen filter is product or supplier");
					message.setBounds(8, 138,300, 14);
					f.getContentPane().add(message);
					
					JLabel chart = new JLabel("Choose Chart : ");
					chart.setBounds(8, 182, 100, 14);
					f.getContentPane().add(chart);
					
					JComboBox chartCb = new JComboBox(charts);
					chartCb.setBounds(117, 178, 89, 22);
					f.getContentPane().add(chartCb);
					
				    JLabel from = new JLabel("From :");
					from.setBounds(8, 226, 46, 14);
					f.getContentPane().add(from);
					
					JComboBox fromMonth = new JComboBox(months);
					fromMonth.setBounds(117, 229, 89, 22);
					f.getContentPane().add(fromMonth);
					
					JLabel to = new JLabel("To :");
					to.setBounds(8, 273, 46, 14);
					f.getContentPane().add(to);
					
					JComboBox toMonth = new JComboBox(months);
					toMonth.setBounds(117, 269, 89, 22);
					f.getContentPane().add(toMonth);
					
					JLabel enterYear = new JLabel("Enter Year :");
					enterYear.setBounds(228, 214, 75, 14);
					f.getContentPane().add(enterYear);
					
					JTextField yearFrom = new JTextField();
					yearFrom.setBounds(228, 231, 58, 20);
					f.getContentPane().add(yearFrom);
					yearFrom.setColumns(10);
					
					JTextField yearTo = new JTextField();
					yearTo.setColumns(10);
					yearTo.setBounds(228, 270, 58, 20);
					f.getContentPane().add(yearTo);
					
					JButton b = new JButton("Done");
					b.setBounds(415, 310, 71, 23); 
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
								Statistics ord = new Statistics(options);
								ord.OrdererStat();
								
								System.exit(0);
							}
						
							}
							
					});
					
					
					f.setSize(512, 383); 
					f.setTitle("Order Mnager Statistics");
					f.setLayout(null); 
					f.setVisible(true);
				
				}
				else if(user instanceof Seller)
				{
					user2 = 1;
					String OMvariables[] = {"","Profit","Purchases"};
					String OMfilter[] = {"","Date","Client","Product"};
					String charts[] = {"","Pie Chart","Line Chart","Bar Chart","Matrix"};
							
					JLabel var = new JLabel("Choose Variable :");
					var.setBounds(8, 20, 100, 14);
					f.getContentPane().add(var);
					
					JComboBox varCb = new JComboBox(OMvariables);   
					varCb.setBounds(117, 16, 89, 22);    
				    f.getContentPane().add(varCb);  
				    
				    JLabel filter = new JLabel("Choose Filter :");
				    filter.setBounds(8, 66, 100, 14);
					f.getContentPane().add(filter);
					
					JComboBox filterCb = new JComboBox(OMfilter);
					filterCb.setBounds(117, 62, 89, 22);
					f.getContentPane().add(filterCb);
					
					JLabel key = new JLabel("Enter Key :");
					key.setBounds(8, 113, 100, 14);
					f.getContentPane().add(key);
					
					JTextField Ekey = new JTextField();
					Ekey.setBounds(117, 110, 89, 20);
					f.getContentPane().add(Ekey);
					
					JLabel message = new JLabel("Enter ID only if chosen filter is Product or Client");
					message.setBounds(8, 138,300, 14);
					f.getContentPane().add(message);
					
					JLabel chart = new JLabel("Choose Chart : ");
					chart.setBounds(8, 182, 100, 14);
					f.getContentPane().add(chart);
					
					JComboBox chartCb = new JComboBox(charts);
					chartCb.setBounds(117, 178, 89, 22);
					f.getContentPane().add(chartCb);
					
				    JLabel from = new JLabel("From :");
					from.setBounds(8, 226, 46, 14);
					f.getContentPane().add(from);
					
					JComboBox fromMonth = new JComboBox(months);
					fromMonth.setBounds(117, 229, 89, 22);
					f.getContentPane().add(fromMonth);
					
					JLabel to = new JLabel("To :");
					to.setBounds(8, 273, 46, 14);
					f.getContentPane().add(to);
					
					JComboBox toMonth = new JComboBox(months);
					toMonth.setBounds(117, 269, 89, 22);
					f.getContentPane().add(toMonth);
					
					JLabel enterYear = new JLabel("Enter Year :");
					enterYear.setBounds(228, 214, 75, 14);
					f.getContentPane().add(enterYear);
					
					JTextField yearFrom = new JTextField();
					yearFrom.setBounds(228, 231, 58, 20);
					f.getContentPane().add(yearFrom);
					yearFrom.setColumns(10);
					
					JTextField yearTo = new JTextField();
					yearTo.setColumns(10);
					yearTo.setBounds(228, 270, 58, 20);
					f.getContentPane().add(yearTo);
					
					JButton b = new JButton("Done");
					b.setBounds(415, 310, 71, 23); 
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
								Statistics sup = new Statistics(options);
								sup.SupplierStat();
								
								System.exit(0);
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
				
				JFrame popUp = new JFrame();
				errorFlag = false;
				//checking variable input
				if(options[0].isEmpty())
				{
					errorFlag = true;
					
					JOptionPane.showMessageDialog(popUp, "Variable Field Must Be Filled");
				}
				//checking filter input
				if(options[1].isEmpty())
				{
					errorFlag = true;
					
					JOptionPane.showMessageDialog(popUp, "Filter Field Must Be Filled");
				}
				//checking key input
				if((options[1] == "Supplier") || (options[1] == "Product") || (options[1] == "Client"))
				{
					if(options[2].isEmpty())
					{
						errorFlag = true;
						JOptionPane.showMessageDialog(popUp, "Key Field Must Be Filled");
						
					}
					
				}	
				//checking chart input
			     if(options[3].isEmpty())
				{
					errorFlag = true;
					
					JOptionPane.showMessageDialog(popUp, "Chart Field Must Be Filled");		
				}
			     
			    //checking if options[3] input exists in database
			     if((!options[3].isEmpty()) && (user2 == 0) )
			     {
			    	 if(options[2].equals("Product"))
			    	 {
				    	SupplierProducts productS = new SupplierProducts();
				    	ArrayList<SupplierProduct> sProd = productS.getSupplierProducts();
				    	for(int i = 0; i < sProd.size(); i++)
				    	{
				    		if(options[3].equals(sProd.get(i).getId()))
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
			    			 if(options[3].equals(supplier.get(i).getId()))
			    			 {
			    				 keyExists = true;
			    			 }
			    		 }
			    	 }
			     }
			     
			     if((keyExists == false) && (user2 == 0))
			     {
			    	 errorFlag = true;
			    	 JOptionPane.showMessageDialog(popUp, "Key ID doesn't exist.");		
			     }
			     
			     if((!options[3].isEmpty()) && (user2 == 1) )
			     {
			    	 if(options[2].equals("Product"))
			    	 {
				    	CompanyProducts prod = new CompanyProducts();
				    	ArrayList<CompanyProduct> cProd = prod.getCompProduct();
				    	for(int i = 0; i < cProd.size(); i++)
				    	{
				    		if(options[3].equals(cProd.get(i).getId()))
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
			    			 if(options[3].equals(buyer.get(i).getId()))
			    			 {
			    				 keyExists = true;
			    			 }
			    		 }
			    	 }
			     }
			     
			     if((keyExists == false) && (user2 == 1))
			     {
			    	 errorFlag = true;
			    	 JOptionPane.showMessageDialog(popUp, "Key doesn't exist.");		
			     }
			     
			     
			     
			     //checking date input !MUST CHECK IF DATE EXISTS! 
			     if(options[5].isEmpty())
			     {
			    	 JOptionPane.showMessageDialog(popUp, "Enter Year From Field Must Be Filled");
			     }
			     if(options[7].isEmpty())
			     {
			    	 JOptionPane.showMessageDialog(popUp, "Enter Year To Field Must Be Filled");
			     }
			     if(options[5].compareTo(options[7]) > 0)
			     {
			    	 JOptionPane.showMessageDialog(popUp, "Wrong Year Input.\"From Year\" Later Than \"To Year\"");
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
						JOptionPane.showMessageDialog(popUp,"Wrong Year Input.\"From Month\" Later Than \"To Month\"");
					}
					else if((fromMonth == toMonth) || ((toMonth - fromMonth) < 2))
					{
						errorFlag = true;
						JOptionPane.showMessageDialog(popUp,"For the same year,month period must be at least two months apart");
					}
				}
				
				
				return errorFlag;
			}
			
}
