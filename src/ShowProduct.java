import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ShowProduct extends JFrame {

	private JFrame frame;
	JButton btnEditProductInformation;
	

	private JTextField textField_1;
	private JTextField textsa;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textlt;
	private JTextField textea;
	private JTextField textField_8;
	
	
	private JTextField textname;
	private JTextField textidcp;
	private JTextField textnamecp;
	private JTextField textsscp;
	private JTextField textsacp;
	private JTextField textmsacp;
	private JTextField textpricecp;
	protected static User user;
	
	

	public ShowProduct(SupplierProduct spl)
	{
		this.setTitle("Supplier Product");
		frame = new JFrame();
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(42, 90, 113, 36);
		lblId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(42, 31, 137, 36);
		lblNewLabel.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Stock Amount :");
		lblNewLabel_3.setBounds(42, 150, 173, 36);
		lblNewLabel_3.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Max Stock Amount :");
		lblNewLabel_4.setBounds(42, 216, 287, 36);
		lblNewLabel_4.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Safety Stock :");
		lblNewLabel_5.setBounds(42, 280, 195, 36);
		lblNewLabel_5.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Average Monthly Consumption :");
		lblNewLabel_6.setBounds(42, 348, 343, 36);
		lblNewLabel_6.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Lead Time :");
		lblNewLabel_7.setBounds(42, 420, 173, 34);
		lblNewLabel_7.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Expected Amount :");
		lblNewLabel_8.setBounds(37, 488, 216, 36);
		lblNewLabel_8.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel_8);
		
		
		textField_8 = new JTextField(spl.getId());
		textField_8.setBounds(637, 31, 188, 32);
		textField_8.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_1 = new JTextField(spl.getName());
		textField_1.setBounds(637, 90, 188, 36);
		textField_1.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		textsa = new JTextField(spl.getStockAmount());
		textsa.setBounds(637, 150, 188, 36);
		textsa.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textsa);
		textsa.setColumns(10);
		
		textField_3 = new JTextField(spl.getMaxStockAmount());
		textField_3.setBounds(637, 217, 188, 36);
		textField_3.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(spl.getSafetyStock());
		textField_4.setBounds(637, 280, 188, 36);
		textField_4.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(spl.getAverageMonthlyConsumption());
		textField_5.setBounds(636, 351, 189, 34);
		textField_5.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textlt= new JTextField(spl.getLeadtime());
		textlt.setBounds(637, 420, 189, 36);
		textlt.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textlt);
		textlt.setColumns(10);
		
		textea = new JTextField(spl.getExpectedAmount());
		textea.setBounds(637, 489, 189, 36);
		textea.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textea);
		textea.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 77, 1015,  2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 137, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 197, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 267, 1015, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 335, 1015, 2);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 407, 1015, 2);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 475, 1015, 2);
		frame.getContentPane().add(separator_6);
		
		
		JButton btnEditProductInformation = new JButton("Edit Product Information");
		btnEditProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ENABLE TEXTFIELDS stockAmount, LeadTime, ExpectedAmount.
				
			    textsa.setEditable(true);
                 String  StockAmount = textsa.getText();
				Double.parseDouble(StockAmount);
				checkForError();
		        
				 
			    textlt.setEditable(true);
				String LeadTime = textlt.getText();
				Double.parseDouble(LeadTime);
				checkForError();
		     
	           textea.setEditable(true);
			   String ExpectedAmount = textea.getText();
			   Double.parseDouble(ExpectedAmount);
			   checkForError();
			        
			  }
			});
			btnEditProductInformation.setBounds(147, 579, 166, 36);
			frame.getContentPane().add(btnEditProductInformation);
		

			JButton btnSave = new JButton(" Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//save and add product
				      OrderManager.addProduct(spl);
				}
			});
			btnSave.setBounds(636, 579, 137, 34);
			frame.getContentPane().add(btnSave);
			
		
	
   }
		
    
	public ShowProduct(CompanyProduct cp)
	{   
		this.setTitle("Company Product");
		frame = new JFrame();
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		JLabel lblProductId = new JLabel(" ID :");
		lblProductId.setBounds(153, 34, 86, 33);
		lblProductId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblProductId);
		
		JLabel lblNewLabel = new JLabel(" Name :");
		lblNewLabel.setBounds(153, 112, 153, 33);
		lblNewLabel.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblProduct = new JLabel(" Safety stock :");
		lblProduct.setBounds(153, 193, 179, 33);
		lblProduct.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblProduct);
		
		JLabel lblProduct_1 = new JLabel(" Stock amount :");
		lblProduct_1.setBounds(153, 277, 179, 35);
		lblProduct_1.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblProduct_1);
		
		JLabel lblMaxStockAmount = new JLabel(" Max stock amount :");
		lblMaxStockAmount.setBounds(153, 369, 224, 33);
		lblMaxStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblMaxStockAmount);
		
		JLabel lblPrice = new JLabel(" Price :");
		lblPrice.setBounds(153, 462, 164, 33);
		lblPrice.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblPrice);
		
	
		textidcp = new JTextField(cp.getId());
		textidcp.setBounds(707, 34, 153, 33);
		textidcp.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textidcp);
		textidcp.setColumns(10);
		textidcp.setEditable(false);
		
		
		textnamecp = new JTextField(cp.getName());
		textnamecp.setBounds(707, 112, 153, 33);
		textnamecp.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textnamecp);
		textnamecp.setColumns(10);
		textnamecp.setEditable(false);

		textsscp = new JTextField(cp.getSafetyStock());
		textsscp.setBounds(707, 193, 153, 33);
		textsscp.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textsscp);
		textsscp.setColumns(10);
		textsscp.setEditable(false);
		
		textsacp = new JTextField(cp.getStockAmount());
		textsacp.setBounds(707, 277, 153, 33);
		textsacp.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textsacp);
		textsacp.setColumns(10);
		textsacp.setEditable(false);
		
		textmsacp = new JTextField(cp.getMaxStockAmount());
		textmsacp.setBounds(707, 369, 153, 33);
		textmsacp.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textmsacp);
		textmsacp.setColumns(10);
		textmsacp.setEditable(false);
		
		textpricecp = new JTextField(cp.getPrice());
		textpricecp.setBounds(707, 462, 153, 32);
		textpricecp.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textpricecp);
		textpricecp.setColumns(10);
		textpricecp.setEditable(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 88, 1015,  2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 168, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 250, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 335, 1015, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 425, 1015, 2);
		frame.getContentPane().add(separator_4);
		
		JButton btnEditProductInformation = new JButton("Edit Product Information");
		btnEditProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//enable textfileds stockamount,price and get new numbers
				textsacp.setEditable(true);
				String StockAmount = textsacp.getText();
				Double.parseDouble(StockAmount);
				checkForError();
				
				
			    
				textpricecp.setEditable(true);
				String Price= textpricecp.getText();
				Double.parseDouble(Price);
				checkForError();
				
			}
		});
		btnEditProductInformation.setBounds(197, 580, 180, 33);
		frame.getContentPane().add(btnEditProductInformation);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save and add product
				Seller.addProduct(cp);
			}
		});
		btnNewButton.setBounds(654, 580, 146, 33);
		frame.getContentPane().add(btnNewButton);
		
	}
		
	
		private boolean checkForError() 
		{
		
          if(textsa.getText()!=null && textsacp.getText()!=null && textpricecp.getText()!=null && textlt.getText()!=null && textea.getText()!=null)
		   {
			 
				 return true;
        	   
		   }
		 		   
           else
           {
        	   System.out.println("You didn't fill in all the information needed.Please try again.");
        	   return false;
           }
		
		
	}
	
	
	
	
		
}
	
	
>>>>>>> b0c7308f2573f908d0fc5188a7aceb54cc85ace0
