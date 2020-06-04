import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JButton btnEditProductInformation;
	private JTextField textName;
	private JTextField textId;
	private JTextField textStockAmount;
	private JTextField textSafetyStock;
	private JTextField textMaxStockAmount;
	private JTextField textPrice;
	private JTextField textAverageMonthlyConsu;
	private JTextField textLeadTime;
	private JTextField textExpectedAmount;
	private JLabel labelId;
	private JLabel labelName;
	private JLabel labelStockAmount;
	private JLabel labelSafetyStock;
	private JLabel labelMaxStockAmount;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
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
		
		labelId = new JLabel("ID :");
		labelId.setBounds(42, 90, 113, 36);
		labelId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelId);
		
		labelName = new JLabel("Name :");
		labelName.setBounds(42, 31, 137, 36);
		labelName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelName);
		
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
		
		
		textId = new JTextField(spl.getId());
		textId.setBounds(637, 31, 188, 32);
		textId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		textName = new JTextField(spl.getName());
		textName.setBounds(637, 90, 188, 36);
		textName.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		
		textStockAmount = new JTextField(" "+spl.getStockAmount());
		textStockAmount.setBounds(637, 150, 188, 36);
		textStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textStockAmount);
		textStockAmount.setColumns(10);
		
		textMaxStockAmount = new JTextField(" "+spl.getMaxStockAmount());
		textMaxStockAmount.setBounds(637, 217, 188, 36);
		textMaxStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textStockAmount);
		textMaxStockAmount.setColumns(10);
		
		textSafetyStock = new JTextField(""+spl.getSafetyStock());
		textSafetyStock.setBounds(637, 280, 188, 36);
		textSafetyStock.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textSafetyStock);
		textSafetyStock.setColumns(10);
		
		textAverageMonthlyConsu = new JTextField(""+spl.getAverageMonthlyConsumption());
		textAverageMonthlyConsu.setBounds(636, 351, 189, 34);
		textAverageMonthlyConsu.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textAverageMonthlyConsu);
		textAverageMonthlyConsu.setColumns(10);
		
		textLeadTime= new JTextField(spl.getLeadtime());
		textLeadTime.setBounds(637, 420, 189, 36);
		textLeadTime.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textLeadTime);
		textLeadTime.setColumns(10);
		
		textExpectedAmount = new JTextField(""+spl.getExpectedAmount());
		textExpectedAmount.setBounds(637, 489, 189, 36);
		textExpectedAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(textExpectedAmount);
		textExpectedAmount.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(10, 77, 1015,  2);
		frame.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 137, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 197, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 267, 1015, 2);
		frame.getContentPane().add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(10, 335, 1015, 2);
		frame.getContentPane().add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(10, 407, 1015, 2);
		frame.getContentPane().add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setBounds(10, 475, 1015, 2);
		frame.getContentPane().add(separator_6);
		
		
		JButton btnEditProductInformation = new JButton("Edit Product Information");
		btnEditProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ENABLE TEXTFIELDS stockAmount, LeadTime, ExpectedAmount.
				
			    textStockAmount.setEditable(true);
                Double  StockAmount = Double.parseDouble(textStockAmount.getText());
		        
			    textLeadTime.setEditable(true);
				Double LeadTime = Double.parseDouble(textLeadTime.getText());
	
	            textExpectedAmount.setEditable(true);
			    Double ExpectedAmount = Double.parseDouble(textExpectedAmount.getText());
			   
			    boolean flag = checkForError();
			    
			  }
			});
			btnEditProductInformation.setBounds(147, 579, 166, 36);
			frame.getContentPane().add(btnEditProductInformation);
		

			JButton btnSave = new JButton(" Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//save and add product
				      //OrderManager.addProduct(spl);
				}
			});
			btnSave.setBounds(636, 579, 137, 34);
			frame.getContentPane().add(btnSave);
			frame.setVisible(true);
		
	
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
		
		labelId = new JLabel(" ID :");
		labelId.setBounds(153, 34, 86, 33);
		labelId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelId);
		
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
		
	
		textId = new JTextField(cp.getId());
		textId.setBounds(707, 34, 153, 33);
		textId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		textId.setEditable(false);
		
		
		textName = new JTextField(cp.getName());
		textName.setBounds(707, 112, 153, 33);
		textName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		textName.setEditable(false);

		textSafetyStock = new JTextField("" + cp.getSafetyStock());
		textSafetyStock.setBounds(707, 193, 153, 33);
		textSafetyStock.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textSafetyStock);
		textSafetyStock.setColumns(10);
		textSafetyStock.setEditable(false);
		
		textStockAmount = new JTextField("" + cp.getStockAmount());
		textStockAmount.setBounds(707, 277, 153, 33);
		textStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textStockAmount);
		textStockAmount.setColumns(10);
		textStockAmount.setEditable(false);
		
		textMaxStockAmount = new JTextField("" + cp.getMaxStockAmount());
		textMaxStockAmount.setBounds(707, 369, 153, 33);
		textMaxStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textMaxStockAmount);
		textMaxStockAmount.setColumns(10);
		textMaxStockAmount.setEditable(false);
		
		textPrice = new JTextField("" + cp.getPrice());
		textPrice.setBounds(707, 462, 153, 32);
		textPrice.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textPrice);
		textPrice.setColumns(10);
		textPrice.setEditable(false);
		
		separator = new JSeparator();
		separator.setBounds(10, 88, 1015,  2);
		frame.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 168, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 250, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 335, 1015, 2);
		frame.getContentPane().add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(10, 425, 1015, 2);
		frame.getContentPane().add(separator_4);
		
		JButton btnEditProductInformation = new JButton("Edit Product Information");
		btnEditProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//enable textfileds stockamount,price and get new numbers
				textStockAmount.setEditable(true);
				String StockAmount = textStockAmount.getText();
				Double.parseDouble(StockAmount);
				checkForError();
				
				
			    //expectedAmount
				textPrice.setEditable(true);
				String Price= textPrice.getText();
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
				//Seller.addProduct(cp);
			}
		});
		btnNewButton.setBounds(654, 580, 146, 33);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
		
	}
		
	
		private boolean checkForError() 
		{
		
          //if(textsa.getText()!=null && textStockAmount.getText()!=null && textpricecp.getText()!=null && textLeadTime.getText()!=null && textExpectedAmount.getText()!=null){
			return true;
         // }
         // else if(textsa.getText()!=null || textStockAmount.getText()!=null || textpricecp.getText()!=null || textLeadTime.getText()!=null && textExpectedAmount.getText()!=null){
        	   //JOptionPane.showMessageDialog(frame, ("Some fields are empty.");
        	  // return false;
          // }
	}
}
	
	