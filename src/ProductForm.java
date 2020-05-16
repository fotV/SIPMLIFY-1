package mine;

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
import javax.swing.JTextField;

import mine.SupplierProducts;

public class ProductForm
{
	private JPanel panel;
	private JFrame frame;
	private User user;
	private boolean errorFlag; //false if there are no errors

	public ProductForm(User user)
	{
		this.user = user;
	}
	
	
	
	public void addAProduct()
	{
		
		if(user instanceof OrderManager)
		{
			frame = new JFrame();
			panel=new JPanel();  
			frame.getContentPane().setBackground(new Color(135, 206, 235));
			
			//name
			
			JLabel nameLabel = new JLabel("Product Name :");
			nameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			nameLabel.setBounds(22, 64, 118, 14);
			frame.getContentPane().add(nameLabel);
			
			JTextField nameTXT = new JTextField();
			nameTXT.setBounds(22, 89, 155, 20);
			frame.getContentPane().add(nameTXT);
			nameTXT.setColumns(10);
			
			//id
			
			JLabel idLabel = new JLabel("Product  ID :");
			idLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			idLabel.setBounds(22, 141, 105, 14);
			frame.getContentPane().add(idLabel);
			
			JTextField idTXT = new JTextField();
			idTXT.setColumns(10);
			idTXT.setBounds(22, 165, 155, 20);
			frame.getContentPane().add(idTXT);
			
			JLabel idMaxCharacters = new JLabel("(max 6 characters)");
			idMaxCharacters.setBounds(22, 185, 118, 14);
			frame.getContentPane().add(idMaxCharacters);
			
			//stock amount
			
			JLabel stockAmLabel = new JLabel("Stock Amount :");
			stockAmLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			stockAmLabel.setBounds(22, 231, 118, 14);
			frame.getContentPane().add(stockAmLabel);
			
			JTextField stockTXT = new JTextField();
			stockTXT.setColumns(10);
			stockTXT.setBounds(22, 256, 155, 20);
			frame.getContentPane().add(stockTXT);
			
			//max stock amount
			
			JLabel maxStockLabel = new JLabel("Maximum Stock Amount :");
			maxStockLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			maxStockLabel.setBounds(22, 303, 176, 14);
			frame.getContentPane().add(maxStockLabel);
			
			JTextField maxStockTXT = new JTextField();
			maxStockTXT.setColumns(10);
			maxStockTXT.setBounds(22, 328, 155, 20);
			frame.getContentPane().add(maxStockTXT);
			
			//safety stock
			
			JLabel safetyLabel = new JLabel("Safety Stock : ");
			safetyLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			safetyLabel.setBounds(294, 64, 92, 14);
			frame.getContentPane().add(safetyLabel);
			
			JTextField safetyTXT = new JTextField();
			safetyTXT.setColumns(10);
			safetyTXT.setBounds(294, 89, 155, 20);
			frame.getContentPane().add(safetyTXT);
			
			//average monthly consumption
			
			JLabel avMonConLabel = new JLabel("Average Monthly Consumption :");
			avMonConLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			avMonConLabel.setBounds(294, 141, 217, 14);
			frame.getContentPane().add(avMonConLabel);
			
			JTextField avMonTXT = new JTextField();
			avMonTXT.setColumns(10);
			avMonTXT.setBounds(294, 165, 155, 20);
			frame.getContentPane().add(avMonTXT);
			
			//leadtime
			
			JLabel leadtimeLabel = new JLabel("Leadtime :");
			leadtimeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			leadtimeLabel.setBounds(294, 231, 105, 14);
			frame.getContentPane().add(leadtimeLabel);
			
			JTextField leadtimeTXT = new JTextField();
			leadtimeTXT.setColumns(10);
			leadtimeTXT.setBounds(294, 256, 155, 20);
			frame.getContentPane().add(leadtimeTXT);
			
			//expected amount
			
			JLabel expAmLabel = new JLabel("Expected Amount :");
			expAmLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			expAmLabel.setBounds(294, 303, 142, 14);
			frame.getContentPane().add(expAmLabel);
			
			JTextField expAmTXT = new JTextField();
			expAmTXT.setColumns(10);
			expAmTXT.setBounds(294, 328, 155, 20);
			frame.getContentPane().add(expAmTXT);
			
			//add button
			
			JButton addButton = new JButton("ADD");
			addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			addButton.setBounds(447, 411, 89, 23);
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
					
					errorFlag = checkErrorOM(name,id,stockAm,maxStock,safety,avMonCon,leadtime,expAm);
					
					if(!errorFlag)
					{
						SupplierProduct sup = new SupplierProduct();
						sup.setName(name);
						sup.setId(id);
						sup.setMaxStockAmount(Double.parseDouble(maxStock));
						sup.setSafetyStock(Double.parseDouble(safety));
						sup.setAverageMonthlyConsumption(Double.parseDouble(avMonCon));
						sup.setLeadtime(Integer.parseInt(leadtime));
						sup.setExpectedAmount(Double.parseDouble(expAm));
						
						OrderManager om = (OrderManager)user;
						om.addProduct(sup);
						
						System.exit(0);
					}	
					
					
			     }
			});
			
			frame.setSize(562, 484); 
			frame.setTitle("Add A Product");
			frame.setLayout(null); 
			frame.setVisible(true);
		}
		else if(user instanceof Seller)
		{
				
				frame.getContentPane().setBackground(new Color(135, 206, 235));
				
				//title
				JLabel lbltitle = new JLabel("Product Form");
				lbltitle.setFont(new Font("Tahoma", Font.BOLD, 15));
				lbltitle.setBounds(186, 24, 125, 14);
				frame.getContentPane().add(lbltitle);
				
				//product name
				
				JLabel lblName = new JLabel("Product Name :");
				lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblName.setBounds(20, 97, 94, 14);
				frame.getContentPane().add(lblName);
				
				JTextField nameTXT = new JTextField();
				nameTXT.setBounds(20, 122, 125, 20);
				frame.getContentPane().add(nameTXT);
				nameTXT.setColumns(10);
				
				//product id

				JLabel lblID = new JLabel("Product ID :");
				lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblID.setBounds(20, 185, 94, 14);
				frame.getContentPane().add(lblID);
				
				JTextField idTXT = new JTextField();
				idTXT.setColumns(10);
				idTXT.setBounds(20, 210, 125, 20);
				frame.getContentPane().add(idTXT);
				
				JLabel maxid = new JLabel("(6 characters)");
				maxid.setFont(new Font("Tahoma", Font.PLAIN, 10));
				maxid.setBounds(20, 229, 75, 14);
				frame.getContentPane().add(maxid);
				
				//product price
				
				JLabel lblPrice = new JLabel("Product Price :");
				lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblPrice.setBounds(20, 288, 94, 14);
				frame.getContentPane().add(lblPrice);
				
				JTextField priceTXT = new JTextField();
				priceTXT.setColumns(10);
				priceTXT.setBounds(20, 312, 125, 20);
				frame.getContentPane().add(priceTXT);
				
				//safety stock
				
				JLabel lblSafetyStock = new JLabel("Safety Stock :");
				lblSafetyStock.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblSafetyStock.setBounds(310, 98, 94, 14);
				frame.getContentPane().add(lblSafetyStock);
				
				JTextField safetyTXT = new JTextField();
				safetyTXT.setColumns(10);
				safetyTXT.setBounds(310, 122, 125, 20);
				frame.getContentPane().add(safetyTXT);
				
				//stock amount
				
				JLabel lblStockAmount = new JLabel("Stock Amount :");
				lblStockAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblStockAmount.setBounds(310, 186, 125, 14);
				frame.getContentPane().add(lblStockAmount);
				
				JTextField stockTXT = new JTextField();
				stockTXT.setColumns(10);
				stockTXT.setBounds(310, 210, 125, 20);
				frame.getContentPane().add(stockTXT);
				
				//max stock amount
				
				JLabel lblMaxstockAmount = new JLabel("Maximum Stock Amount :");
				lblMaxstockAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMaxstockAmount.setBounds(310, 289, 172, 14);
				frame.getContentPane().add(lblMaxstockAmount);
				
				JTextField maxStockTXT = new JTextField();
				maxStockTXT.setColumns(10);
				maxStockTXT.setBounds(310, 312, 125, 20);
				frame.getContentPane().add(maxStockTXT);
				
				//add button
				
				JButton btnAddButton = new JButton("ADD");
				btnAddButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						
						String name = nameTXT.getText();
						String id = idTXT.getText();
						String stockAm = stockTXT.getText();
						String maxStock = maxStockTXT.getText();
						String safety = safetyTXT.getText();
						String price = priceTXT.getText();
						
						errorFlag = checkErrorSeller(name,id,safety,stockAm,maxStock,price);
						
						if(!errorFlag)
						{
							CompanyProduct product = new CompanyProduct();
							product.setName(name);
							product.setId(id);
							product.setSafetyStock(Double.parseDouble(safety));
							product.setStockAmount(Double.parseDouble(stockAm));
							product.setMaxStockAmount(Double.parseDouble(maxStock));
							product.setPrice(Double.parseDouble(price));
							Seller seller = (Seller)user;
							seller.addProduct(product);
							
							System.exit(0);
						}
						
						
						
					}
				});
				btnAddButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAddButton.setBounds(425, 401, 89, 23);
				frame.getContentPane().add(btnAddButton);
				
				frame.setSize(540, 474);
				frame.setTitle("Add A Product");
				frame.setLayout(null); 
				frame.setVisible(true);
				
		}
		
	}
	
	private boolean checkErrorOM(String name,String id,String stockAmount,String maxStockAmount,String safetyStock,
			String averageMonthlyConsumption,String leadtime,String expectedAmount)
	{
		
		JFrame popUp = new JFrame();
		errorFlag = false;
		
		//checking if fields are empty
		
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Name Field Must Be Filled");
			errorFlag = true;
		}
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "ID Field Must Be Filled");
			errorFlag = true;
		}
		if(stockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Stock Amount Field Must Be Filled");
			errorFlag = true;
		}
		if(maxStockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Maximum Stock Amount Field Must Be Filled");
			errorFlag = true;
		}
		if(safetyStock.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Safety Stock Field Must Be Filled");
			errorFlag = true;
		}
		if(averageMonthlyConsumption.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Average Monthly Consumption Field Must Be Filled");
			errorFlag = true;
		}
		if(leadtime.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Leadtime Field Must Be Filled");
			errorFlag = true;
		}
		if(expectedAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Expected Amount Field Must Be Filled");
			errorFlag = true;
		}
		
		
		//checking if product already exists
		
		if(!(id.isEmpty()))
		{
			SupplierProducts supP = new SupplierProducts();
			ArrayList<SupplierProduct> supProduct = supP.getSupplierProducts();
			for(int i = 0; i < supProduct.size(); i++)
			{
				if(id.equals(supProduct.get(i).getId()))
				{
					JOptionPane.showMessageDialog(popUp, "A Product with the same ID already exists");
					errorFlag = true;
				}
			}
			
		}
		
		return errorFlag;
	}
	
	private boolean checkErrorSeller(String name,String id,String safetyStock,String stockAmount,String maxStockAmount,
			String price)
{
		JFrame popUp = new JFrame();
		errorFlag = false;
		
		// checks if all fields are filled
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Name Field Must Be Filled");
			errorFlag = true;
		}
		
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "ID Field Must Be Filled");
			errorFlag = true;
		}
		
		if(safetyStock.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Safety Stock Field Must Be Filled");
			errorFlag = true;
		}
		
		if(stockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Stock Amount Field Must Be Filled");
			errorFlag = true;
		}
		
		if(maxStockAmount.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Maximum Stock Amount Field Must Be Filled");
			errorFlag = true;
		}
		
		if(price.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Price Field Must Be Filled");
			errorFlag = true;
		}
		
		//checks if product already exists in database
		
		if(!(id.isEmpty()))
		{
			CompanyProducts comp = new CompanyProducts();
			ArrayList<CompanyProduct> compP = comp.getCompProduct();
			for(int i = 0; i < compP.size(); i++)
			{
				if(id.equals(compP.get(i).getId()))
				{
					JOptionPane.showMessageDialog(popUp, "A Product with the same ID already exists");
					errorFlag = true;
				}
			}
		}
	
		return errorFlag;
}
}
