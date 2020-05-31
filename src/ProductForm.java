import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class ProductForm extends JFrame
{
	/*ProductForm.java
	 * Purpose : Displays the GUI of a form for user in order to add a product to the database.
	 * @author Fotiadou Vassiliki
	 */
	private JFrame frame;
	private Seller seller;
	private OrderManager om;
	String user; 
	private boolean errorFlag; //false if there are no errors else true

	public ProductForm(OrderManager om)
	{
		this.om = om;
		user = "om";
		
	}
	
	public ProductForm(Seller seller)
	{
		this.seller = seller;
		user = "seller";
		
	}
	
	
	public void addAProduct()
	{
		/*Checks if user is an ordermanager or seller and creates the GUI and adds product 
		 * in ArrayList if there is no error in filled form
		 * */
		
		//if user = ordermanager
		
		if(user.equals("om"))
		{
			frame = new JFrame();  
			frame.getContentPane().setBackground(new Color(136, 177, 179));
			
			//name field and textfield
			
			JLabel nameLabel = new JLabel("Product Name :");
			nameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
			nameLabel.setBounds(37, 56, 147, 21);
			frame.getContentPane().add(nameLabel);
			
			JTextField nameTXT = new JTextField();
			nameTXT.setBounds(205, 57, 191, 27);
			frame.getContentPane().add(nameTXT);
			nameTXT.setColumns(10);
			
			//id field and textfield
			
			JLabel idLabel = new JLabel("Product  ID :");
			idLabel.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
			idLabel.setBounds(562, 56, 139, 21);
			frame.getContentPane().add(idLabel);
			
			JTextField idTXT = new JTextField();
			idTXT.setColumns(10);
			idTXT.setBounds(763, 57, 191, 27);
			frame.getContentPane().add(idTXT);
			
			JLabel idMaxCharacters = new JLabel("(6 characters)");
			idMaxCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
			idMaxCharacters.setBounds(562, 65, 70, 30);
			frame.getContentPane().add(idMaxCharacters);
			
			//stock amount field and textfield
			
			JLabel stockAmLabel = new JLabel("Stock Amount :");
			stockAmLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			stockAmLabel.setBounds(37, 197, 147, 21);
			frame.getContentPane().add(stockAmLabel);
			
			JTextField stockTXT = new JTextField();
			stockTXT.setColumns(10);
			stockTXT.setBounds(205, 198, 191, 27);
			frame.getContentPane().add(stockTXT);
			
			//max stock amount field and textfield
			
			JLabel maxStockLabel = new JLabel("MaxStock Amount :");
			maxStockLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			maxStockLabel.setBounds(562, 197, 178, 21);
			frame.getContentPane().add(maxStockLabel);
			
			JTextField maxStockTXT = new JTextField();
			maxStockTXT.setColumns(10);
			maxStockTXT.setBounds(763, 198, 191, 27);
			frame.getContentPane().add(maxStockTXT);
			
			//safety stock field and textfield
			
			JLabel safetyLabel = new JLabel("Safety Stock : ");
			safetyLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			safetyLabel.setBounds(37, 363, 147, 21);
			frame.getContentPane().add(safetyLabel);
			
			JTextField safetyTXT = new JTextField();
			safetyTXT.setColumns(10);
			safetyTXT.setBounds(205, 364, 191, 27
					);
			frame.getContentPane().add(safetyTXT);
			
			//average monthly consumption field and textfield
			
			JLabel avMonConLabel = new JLabel("Average Monthly");
			avMonConLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			avMonConLabel.setBounds(562, 360, 178, 27);
			frame.getContentPane().add(avMonConLabel);
			
			JLabel lblConsumption = new JLabel("Consumption  :");
			lblConsumption.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			lblConsumption.setBounds(562, 384, 178, 21);
			frame.getContentPane().add(lblConsumption);
			
			JTextField avMonTXT = new JTextField();
			avMonTXT.setColumns(10);
			avMonTXT.setBounds(763, 364, 191, 27);
			frame.getContentPane().add(avMonTXT);
			
			//leadtime field and textfield
			
			JLabel leadtimeLabel = new JLabel("Leadtime :");
			leadtimeLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			leadtimeLabel.setBounds(37, 523, 147, 21);
			frame.getContentPane().add(leadtimeLabel);
			
			JTextField leadtimeTXT = new JTextField();
			leadtimeTXT.setColumns(10);
			leadtimeTXT.setBounds(205, 524, 191, 27);
			frame.getContentPane().add(leadtimeTXT);
			
			//expected amount field and textfield
			
			JLabel expAmLabel = new JLabel("Expected Amount :");
			expAmLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			expAmLabel.setBounds(562, 520, 178, 27);
			frame.getContentPane().add(expAmLabel);
			
			JTextField expAmTXT = new JTextField();
			expAmTXT.setColumns(10);
			expAmTXT.setBounds(763, 524, 191, 27);
			frame.getContentPane().add(expAmTXT);
			
			//Separators
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 132, 1017, 2);
			frame.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 297, 1017, 2);
			frame.getContentPane().add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(10, 460, 1017, 2);
			frame.getContentPane().add(separator_2);
			
			//add button
			
			JButton addButton = new JButton("Add");
			addButton.setFont(new Font("Helvetic Neue", Font.PLAIN, 15));
			addButton.setBounds(936, 583, 78, 21);
			frame.getContentPane().add(addButton);
			
			
			addButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					String name = nameTXT.getText();
					String id = idTXT.getText();
					String stockAm = stockTXT.getText();
					String maxStock = maxStockTXT.getText();
					String safety = safetyTXT.getText();
					String avMonCon = avMonTXT.getText();
					String leadtime = leadtimeTXT.getText();
					String expAm = expAmTXT.getText();
					
					//calls checkErrorOM function before adding product 
					errorFlag = checkErrorOM(name,id,stockAm,maxStock,safety,avMonCon,leadtime,expAm);
					
					//if errorFlag = false there is no error, adds product in ArrayList Supplier Product
					if(!errorFlag)
					{
						frame.setVisible(false);
							
						String omId = om.getId();
						SupplierProduct sup = new SupplierProduct(name,id,omId,Double.parseDouble(stockAm),Double.parseDouble(maxStock),
												  Double.parseDouble(safety),Double.parseDouble(avMonCon),Integer.parseInt(leadtime),Double.parseDouble(expAm));
						om.getProducts().add(sup);
							
							
							
						}	
		
					
			     }
			});
			
			frame.setSize(1041, 653);
			frame.setResizable(false);
			frame.setTitle("Product Form");
			frame.setLayout(null); 
			frame.setVisible(true);	
			
		}
		//user = seller
		else if(user.equals("seller"))
		{
			frame = new JFrame();  
			frame.getContentPane().setBackground(new Color(136, 177, 179));
			
				//product name field and textfield
				
				JLabel lblName = new JLabel("Product Name :");
				lblName.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
				lblName.setBounds(37, 56, 147, 21);
				frame.getContentPane().add(lblName);
				
				JTextField nameTXT = new JTextField();
				nameTXT.setBounds(205, 57, 191, 27);
				frame.getContentPane().add(nameTXT);
				nameTXT.setColumns(10);
				
				//product id field and textfield

				JLabel lblID = new JLabel("Product ID :");
				lblID.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
				lblID.setBounds(562, 56, 139, 21);
				frame.getContentPane().add(lblID);
				
				JTextField idTXT = new JTextField();
				idTXT.setColumns(10);
				idTXT.setBounds(763, 57, 191, 27);
				frame.getContentPane().add(idTXT);
				
				JLabel maxid = new JLabel("(6 characters)");
				maxid.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
				maxid.setBounds(562, 74, 70, 21);
				frame.getContentPane().add(maxid);
				
				//product price field and textfield
				
				JLabel lblPrice = new JLabel("Product Price :");
				lblPrice.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
				lblPrice.setBounds(37, 197, 147, 21);
				frame.getContentPane().add(lblPrice);
				
				JTextField priceTXT = new JTextField();
				priceTXT.setColumns(10);
				priceTXT.setBounds(205, 198, 191, 27);
				frame.getContentPane().add(priceTXT);
				
				//supplier ID field and textfield
				
				JLabel SupplierID = new JLabel("Supplier ID :");
				SupplierID.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
				SupplierID.setBounds(562, 197, 178, 21);
				frame.getContentPane().add(SupplierID);
				
				JTextField supplierIDTXT = new JTextField();
				supplierIDTXT.setColumns(10);
				supplierIDTXT.setBounds(763, 198, 191, 27);
				frame.getContentPane().add(supplierIDTXT);
				
				JLabel label = new JLabel("(6 characters)");
				label.setFont(new Font("Helvetica Neue", Font.PLAIN,10));
				label.setBounds(562, 216, 70, 21);
				frame.getContentPane().add(label);
				
				//stock amount field and textfield
				
				JLabel lblStockAmount = new JLabel("Stock Amount :");
				lblStockAmount.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
				lblStockAmount.setBounds(37, 363, 147, 21);
				frame.getContentPane().add(lblStockAmount);
				
				JTextField stockTXT = new JTextField();
				stockTXT.setColumns(10);
				stockTXT.setBounds(205, 364, 191, 27);
				frame.getContentPane().add(stockTXT);
				
				//max stock amount field and textfield
				
				JLabel lblMaxstockAmount = new JLabel("Max Stock Amount :");
				lblMaxstockAmount.setFont(new Font("Helvetica Neue", Font.PLAIN,19));
				lblMaxstockAmount.setBounds(562, 360, 181, 27);
				frame.getContentPane().add(lblMaxstockAmount);
				
				JTextField maxStockTXT = new JTextField();
				maxStockTXT.setColumns(10);
				maxStockTXT.setBounds(763, 364, 191, 27);
				frame.getContentPane().add(maxStockTXT);
				

				//safety stock field and textfield
				
				JLabel lblSafetyStock = new JLabel("Safety Stock :");
				lblSafetyStock.setFont(new Font("Helvetica Neue", Font.PLAIN,20));
				lblSafetyStock.setBounds(37, 523, 150, 24);
				frame.getContentPane().add(lblSafetyStock);
				
				JTextField safetyTXT = new JTextField();
				safetyTXT.setColumns(10);
				safetyTXT.setBounds(205, 524, 191, 27);
				frame.getContentPane().add(safetyTXT);
				
				//Separators
				
				JSeparator separator = new JSeparator();
				separator.setBounds(10, 132, 1017, 2);
				frame.getContentPane().add(separator);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 297, 1017, 2);
				frame.getContentPane().add(separator_1);
				
				JSeparator separator_2 = new JSeparator();
				separator_2.setBounds(10, 460, 1017, 2);
				frame.getContentPane().add(separator_2);
				
				
				//add button
				
				JButton btnAddButton = new JButton("Add");
				btnAddButton.setFont(new Font("Helvetica Neue", Font.PLAIN,14));
				btnAddButton.setBounds(911, 563, 94, 29);
				frame.getContentPane().add(btnAddButton);
				
				btnAddButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						String name = nameTXT.getText();
						String id = idTXT.getText();
						String price = priceTXT.getText();
						String supplierID = SupplierID.getText();
						String stockAm = stockTXT.getText();
						String maxStock = maxStockTXT.getText();
						String safety = safetyTXT.getText();
						
						//calls checkErrorSeller function before adding product
						errorFlag = checkErrorSeller(name,id,price,supplierID,safety,stockAm,maxStock);
						
						//if errorFlag = false there is no error, adds product in ArrayList Company Product
						if(!errorFlag)
						{
							frame.setVisible(false);
							CompanyProduct comp = new CompanyProduct(name,id,supplierID,Double.parseDouble(stockAm),Double.parseDouble(maxStock),
														Double.parseDouble(safety),Double.parseDouble(price));
							seller.getProducts().add(comp);
						
							
						}
						
				     }
				});
				
				
				frame.setSize(1041, 653);
				frame.setResizable(false);
				frame.setTitle("Product Form");
				frame.setLayout(null); 
				frame.setVisible(true);
				
		}
		
	}
	
	private boolean checkErrorOM(String name,String id,String stockAmount,String maxStockAmount,String safetyStock,
			String averageMonthlyConsumption,String leadtime,String expectedAmount)
	{
		/*checks if there is an error in filled product form */
		
		errorFlag = false;
		
		//checking if fields are empty
		
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(stockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(maxStockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Max Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(safetyStock.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Safety Stock Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(averageMonthlyConsumption.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Average Monthly Consumption Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(leadtime.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Leadtime Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(expectedAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Expected Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		//checking if product already exists
		
		boolean exists = false;
		int i = 0;
		if(!(id.isEmpty()))
		{
			SupplierProducts supP = new SupplierProducts();
			ArrayList<SupplierProduct> supProduct = supP.getSupplierProducts();
			while((i < supProduct.size()) && !exists)
			{
				if(id.equals(supProduct.get(i).getId()))
				{
					exists = true;
				}
				
				i++;
			}
			
		}
		
		if(exists == true)
		{
			JOptionPane.showMessageDialog(null, "A Product with the same ID already exists", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		//checking if there is a supplier that sells the product
		
		CompanyProducts comp = new CompanyProducts();
		ArrayList<CompanyProduct> compP = comp.getCompanyProducts();
		exists = false;
		i = 0;
		while((i < compP.size()) && !exists)
		{
			if(id.equals(compP.getId()))
			{
				exists = true;
			}
			i++;
		}
		
		if(exists == false)
		{
			JOptionPane.showMessageDialog(null, "There is no Supplier that provides this Product", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		else
		{
			//if a supplier sells the product then the product is added to suupplies list
			
			for(i = 0; i < compP.size(); i++)
			{
				if(id.equals(compP.getId()))
				{
					Suppl s = new Suppl(id,compP.getSellerId(),compP.getPrice());
					Supplies sup = new Supplies();
					ArrayList<Suppl> sups = sup.getSupplies();
					sups.add(s);
				}
			}
		}	
		return errorFlag;
	}

	private boolean checkErrorSeller(String name, String id, String price, String supplierID, String safetyStock,String stockAmount,String maxStockAmount)
	{
		/*checks if there is an error in filled product form */
		
		errorFlag = false;
		
		// checks if all fields are filled
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Product Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Product ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(price.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Product Price Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(supplierID.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Supplier ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		
		if(stockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(maxStockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Max Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(safetyStock.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Safety Stock Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		//checking if product already exists
		
				boolean exists = false;
				int i = 0;
				if(!(id.isEmpty()))
				{
					CompanyProducts comP = new CompanyProducts();
					ArrayList<CompanyProduct> compProduct = compP.getCompanyProducts();
					while((i < compProduct.size()) && !exists)
					{
						if(id.equals(compProduct.get(i).getId()))
						{
							exists = true;
						}
						
						i++;
					}
					
				}
				
				if(exists == true)
				{
					JOptionPane.showMessageDialog(null, "A Product with the same ID already exists", "Invalid Input",JOptionPane.ERROR_MESSAGE);
					errorFlag = true;
				}

		return errorFlag;
	}
}
