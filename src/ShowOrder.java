import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ShowOrder {

	Order order;
	User user;

	private JFrame frame;
	private JTextField textOMID;
	private JTextField textSID;
	private JTextField textSNAME;
	private JTextField textOID;
	private JTextField textDATE;
	private JTextField textSTATUS;
	private JTextField textPID;
	private JTextField textPNM;
	private JTextField textQ;
	private JTextField textPR;
	private JTextField textTP;	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					  ShowOrder window = new ShowOrder(order,user);
					  window.frame.setVisible(true);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}


 public ShowOrder(Order order,User user) {
	 
	 
	 if(user instanceof OrderManager){
	   
		 OrderΜanager ord = (OrderΜanager) user ;
	 
	    frame = new JFrame();
		frame.setTitle("Order");
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Order ID :");
		lblNewLabel_1.setBounds(125, 164, 117, 17);
		lblNewLabel_1.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(125, 409, 150, 20);
		lblQuantity.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblNewLabel_2 = new JLabel("Supplier ID :");
		lblNewLabel_2.setBounds(125, 66, 205, 20);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblOrderManagerId = new JLabel("Order Manager ID :");
		lblOrderManagerId.setBounds(125, 19, 246, 28);
		lblOrderManagerId.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblOrderManagerId);
		
		JLabel lblSupplierName = new JLabel("Supplier Name :");
		lblSupplierName.setBounds(122, 107, 194, 31);
		lblSupplierName.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblSupplierName);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(125, 211, 150, 17);
		lblDate.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblDate);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(125, 261, 150, 17);
		lblStatus.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblStatus);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(125, 462, 162, 20);
		lblPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblPrice);
		
		JLabel lblTotalPrice = new JLabel("Total Price :");
		lblTotalPrice.setBounds(125, 516, 162, 17);
		lblTotalPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblTotalPrice);
		
		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setBounds(125, 311, 185, 17);
		lblProductId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblProductId);
		
		JLabel lblProductName = new JLabel("Product Name :");
		lblProductName.setBounds(125, 362, 219, 17);
		lblProductName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblProductName);
		
		
		textOMID = new JTextField(order.getOrderId());
		textOMID.setBounds(682, 22, 86, 20);
		textOMID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textOMID);
		textOMID.setColumns(10);
		textOMID.setEditable(false);
		
		textSID = new JTextField(order.getQuantity());
		textSID.setBounds(682, 65, 86, 20);
		textSID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textSID);
		textSID.setColumns(10);
		textSID.setEditable(false);
		
		textSNAME = new JTextField(order.getSupplierId());
		textSNAME.setBounds(682, 111, 86, 20);
		textSNAME.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textSNAME);
		textSNAME.setColumns(10);
		textSNAME.setEditable(false);
		
		textOID = new JTextField(order.getOrderManagerId());
		textOID.setBounds(682, 162, 86, 20);
		textOID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textOID);
		textOID.setColumns(10);
		textOID.setEditable(false);
		
		textDATE = new JTextField(order.getSupplierName());
		textDATE.setBounds(682, 209, 86, 20);
		textDATE.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textDATE);
		textDATE.setColumns(10);
		textDATE.setEditable(false);
		
		textSTATUS = new JTextField(order.getDate());
		textSTATUS.setBounds(682, 267, 86, 20);
		textSTATUS.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textSTATUS);
		textSTATUS.setColumns(10);
		textSTATUS.setEditable(false);
		
		textPID = new JTextField(order.getStatus());
		textPID.setBounds(682, 309, 86, 20);
		textPID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textPID);
		textPID.setColumns(10);
		textPID.setEditable(false);
		
		textPNM = new JTextField(order.getPrice());
		textPNM.setBounds(682, 360, 86, 20);
		textPNM.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textPNM);
		textPNM.setColumns(10);
		textPNM.setEditable(false);
		
		textQ = new JTextField(order.getTotalPrice());
		textQ.setBounds(682, 409, 86, 20);
		textQ.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textQ);
		textQ.setColumns(10);
		textQ.setEditable(false);
		
		textPR = new JTextField(order.getProductId());
		textPR.setBounds(682, 461, 86, 20);
		textPR.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textPR);
		textPR.setColumns(10);
		textPR.setEditable(false);
		
		textTP = new JTextField(order.getProductName());
		textTP.setBounds(682, 513, 86, 20);
		textTP.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textTP);
		textTP.setColumns(10);
		textTP.setEditable(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 1015,2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 98, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 142, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 192, 1015, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 248, 1015, 2);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 298, 1015, 2);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 342, 1015, 2);
		frame.getContentPane().add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 396, 1015, 2);
		frame.getContentPane().add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(10, 449, 1015, 2);
		frame.getContentPane().add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(10, 493, 1015, 2);
		frame.getContentPane().add(separator_9);
		
		JButton EditButton = new JButton("Edit Order Information");
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//enable text field Status
				
				textSTATUS.setEditable(true);
				String Status = textSTATUS.getText();
				Double st = Double.parseDouble(Status);
				checkForError();
				
			}
		});
		EditButton.setBounds(245, 584, 177, 29);
		frame.getContentPane().add(EditButton);
		
		JButton SaveButton = new JButton("Save Order ");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ord.getOrders();
				
			}
		});
		SaveButton.setBounds(591, 584, 177, 26);
		frame.getContentPane().add(SaveButton);
	 }
	 else if (user instanceof Seller ){ 
		 
		 Seller sel = (Seller ) user;
		 
		 frame = new JFrame();
			frame.setTitle("Order");
			frame.setBounds(100, 100, 1041, 653);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
			frame.getContentPane().setBackground(new Color(136, 177, 179));
			frame.setResizable(false);
			
			JLabel lblNewLabel_1 = new JLabel("Order ID :");
			lblNewLabel_1.setBounds(125, 164, 117, 17);
			lblNewLabel_1.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblQuantity = new JLabel("Quantity :");
			lblQuantity.setBounds(125, 409, 150, 20);
			lblQuantity.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblQuantity);
			
			JLabel lblNewLabel_2 = new JLabel("Seller ID :");
			lblNewLabel_2.setBounds(125, 22, 205, 20);
			lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblOrderManagerId = new JLabel("Buyer ID :");
			lblOrderManagerId.setBounds(125, 107, 246, 28);
			lblOrderManagerId.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblOrderManagerId);
			
			JLabel lblSupplierName = new JLabel("Seller Name :");
			lblSupplierName.setBounds(125, 61, 194, 31);
			lblSupplierName.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSupplierName);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setBounds(125, 211, 150, 17);
			lblDate.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblDate);
			
			JLabel lblStatus = new JLabel("Status :");
			lblStatus.setBounds(125, 261, 150, 17);
			lblStatus.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblStatus);
			
			JLabel lblPrice = new JLabel("Price :");
			lblPrice.setBounds(125, 462, 162, 20);
			lblPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblPrice);
			
			JLabel lblTotalPrice = new JLabel("Total Price :");
			lblTotalPrice.setBounds(125, 516, 162, 17);
			lblTotalPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblTotalPrice);
			
			JLabel lblProductId = new JLabel("Product ID :");
			lblProductId.setBounds(125, 311, 185, 17);
			lblProductId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblProductId);
			
			JLabel lblProductName = new JLabel("Product Name :");
			lblProductName.setBounds(125, 362, 219, 17);
			lblProductName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblProductName);
			
			
			textOMID = new JTextField();
			textOMID.setBounds(682, 111, 86, 20);
			textOMID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textOMID);
			textOMID.setColumns(10);
			textOMID.setEditable(false);
			
			textSID = new JTextField();
			textSID.setBounds(682, 21, 86, 20);
			textSID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textSID);
			textSID.setColumns(10);
			textSID.setEditable(false);
			
			textSNAME = new JTextField();
			textSNAME.setBounds(682, 65, 86, 20);
			textSNAME.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textSNAME);
			textSNAME.setColumns(10);
			textSNAME.setEditable(false);
			
			textOID = new JTextField();
			textOID.setBounds(682, 162, 86, 20);
			textOID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textOID);
			textOID.setColumns(10);
			textOID.setEditable(false);
			
			textDATE = new JTextField();
			textDATE.setBounds(682, 209, 86, 20);
			textDATE.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textDATE);
			textDATE.setColumns(10);
			textDATE.setEditable(false);
			
			textSTATUS = new JTextField();
			textSTATUS.setBounds(682, 267, 86, 20);
			textSTATUS.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textSTATUS);
			textSTATUS.setColumns(10);
			textSTATUS.setEditable(false);
			
			textPID = new JTextField();
			textPID.setBounds(682, 309, 86, 20);
			textPID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textPID);
			textPID.setColumns(10);
			textPID.setEditable(false);
			
			textPNM = new JTextField();
			textPNM.setBounds(682, 360, 86, 20);
			textPNM.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textPNM);
			textPNM.setColumns(10);
			textPNM.setEditable(false);
			
			textQ = new JTextField();
			textQ.setBounds(682, 409, 86, 20);
			textQ.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textQ);
			textQ.setColumns(10);
			textQ.setEditable(false);
			
			textPR = new JTextField();
			textPR.setBounds(682, 461, 86, 20);
			textPR.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textPR);
			textPR.setColumns(10);
			textPR.setEditable(false);
			
			textTP = new JTextField();
			textTP.setBounds(682, 513, 86, 20);
			textTP.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textTP);
			textTP.setColumns(10);
			textTP.setEditable(false);
		
			

			JSeparator separator = new JSeparator();
			separator.setBounds(10, 53, 1015,2);
			frame.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 98, 1015, 2);
			frame.getContentPane().add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(10, 142, 1015, 2);
			frame.getContentPane().add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(10, 192, 1015, 2);
			frame.getContentPane().add(separator_3);
			
			JSeparator separator_4 = new JSeparator();
			separator_4.setBounds(10, 248, 1015, 2);
			frame.getContentPane().add(separator_4);
			
			JSeparator separator_5 = new JSeparator();
			separator_5.setBounds(10, 298, 1015, 2);
			frame.getContentPane().add(separator_5);
			
			JSeparator separator_6 = new JSeparator();
			separator_6.setBounds(10, 342, 1015, 2);
			frame.getContentPane().add(separator_6);
			
			JSeparator separator_7 = new JSeparator();
			separator_7.setBounds(10, 396, 1015, 2);
			frame.getContentPane().add(separator_7);
			
			JSeparator separator_8 = new JSeparator();
			separator_8.setBounds(10, 449, 1015, 2);
			frame.getContentPane().add(separator_8);
			
			JSeparator separator_9 = new JSeparator();
			separator_9.setBounds(10, 493, 1015, 2);
			frame.getContentPane().add(separator_9);
			
			
			
			JButton EditButton = new JButton("Edit Order Information");
			EditButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//enable text fields Price,Total Price,Status
					
					textPR.setEditable(true);
					String  Price= textPR.getText();
					Double pr = Double.parseDouble(Price);
					checkForError();
					
				    Double newtext = pr*order.getQuantity();
				    String text = Double.toString(newtext);  
					textTP = new JTextField(text);
					
					textSTATUS.setEditable(true);
					String Status = textSTATUS.getText();
					Double st = Double.parseDouble(Status);
					checkForError();
					
				}
			});
			EditButton.setBounds(245, 584, 177, 29);
			frame.getContentPane().add(EditButton);
			
			JButton SaveButton = new JButton("Save Order ");
			SaveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					sel.getOrders();
					
				}
			});
			SaveButton.setBounds(591, 584, 177, 26);
			frame.getContentPane().add(SaveButton);
			
		 
	 }
	 else { 
		 Stockkeeper stk = (Stockkeeper) user;
	     
		 frame = new JFrame();
			frame.setTitle("Order");
			frame.setBounds(100, 100, 1041, 653);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
			frame.getContentPane().setBackground(new Color(136, 177, 179));
			frame.setResizable(false);
			
			JLabel lblNewLabel_1 = new JLabel("Order ID :");
			lblNewLabel_1.setBounds(125, 164, 117, 17);
			lblNewLabel_1.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblQuantity = new JLabel("Quantity :");
			lblQuantity.setBounds(125, 409, 150, 20);
			lblQuantity.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblQuantity);
			
			JLabel lblNewLabel_2 = new JLabel("Supplier ID :");
			lblNewLabel_2.setBounds(125, 66, 205, 20);
			lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblOrderManagerId = new JLabel("Order Manager ID :");
			lblOrderManagerId.setBounds(125, 19, 246, 28);
			lblOrderManagerId.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblOrderManagerId);
			
			JLabel lblSupplierName = new JLabel("Supplier Name :");
			lblSupplierName.setBounds(122, 107, 194, 31);
			lblSupplierName.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSupplierName);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setBounds(125, 211, 150, 17);
			lblDate.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblDate);
			
			JLabel lblStatus = new JLabel("Status :");
			lblStatus.setBounds(125, 261, 150, 17);
			lblStatus.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblStatus);
			
			JLabel lblPrice = new JLabel("Price :");
			lblPrice.setBounds(125, 462, 162, 20);
			lblPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblPrice);
			
			JLabel lblTotalPrice = new JLabel("Total Price :");
			lblTotalPrice.setBounds(125, 516, 162, 17);
			lblTotalPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblTotalPrice);
			
			JLabel lblProductId = new JLabel("Product ID :");
			lblProductId.setBounds(125, 311, 185, 17);
			lblProductId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblProductId);
			
			JLabel lblProductName = new JLabel("Product Name :");
			lblProductName.setBounds(125, 362, 219, 17);
			lblProductName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(lblProductName);
			
			
			textOMID = new JTextField(order.getOrderId());
			textOMID.setBounds(682, 22, 86, 20);
			textOMID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textOMID);
			textOMID.setColumns(10);
			textOMID.setEditable(false);
			
			textSID = new JTextField(order.getQuantity());
			textSID.setBounds(682, 65, 86, 20);
			textSID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textSID);
			textSID.setColumns(10);
			textSID.setEditable(false);
			
			textSNAME = new JTextField(order.getSupplierId());
			textSNAME.setBounds(682, 111, 86, 20);
			textSNAME.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textSNAME);
			textSNAME.setColumns(10);
			textSNAME.setEditable(false);
			
			textOID = new JTextField(order.getOrderManagerId());
			textOID.setBounds(682, 162, 86, 20);
			textOID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textOID);
			textOID.setColumns(10);
			textOID.setEditable(false);
			
			textDATE = new JTextField(order.getSupplierName());
			textDATE.setBounds(682, 209, 86, 20);
			textDATE.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textDATE);
			textDATE.setColumns(10);
			textDATE.setEditable(false);
			
			textSTATUS = new JTextField(order.getDate());
			textSTATUS.setBounds(682, 267, 86, 20);
			textSTATUS.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textSTATUS);
			textSTATUS.setColumns(10);
			textSTATUS.setEditable(false);
			
			textPID = new JTextField(order.getStatus());
			textPID.setBounds(682, 309, 86, 20);
			textPID.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textPID);
			textPID.setColumns(10);
			textPID.setEditable(false);
			
			textPNM = new JTextField(order.getPrice());
			textPNM.setBounds(682, 360, 86, 20);
			textPNM.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textPNM);
			textPNM.setColumns(10);
			textPNM.setEditable(false);
			
			textQ = new JTextField(order. getTotalPrice());
			textQ.setBounds(682, 409, 86, 20);
			textQ.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textQ);
			textQ.setColumns(10);
			textQ.setEditable(false);
			
			textPR = new JTextField(order.getProductId());
			textPR.setBounds(682, 461, 86, 20);
			textPR.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textPR);
			textPR.setColumns(10);
			textPR.setEditable(false);
			
			textTP = new JTextField(order.getProductName());
			textTP.setBounds(682, 513, 86, 20);
			textTP.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(textTP);
			textTP.setColumns(10);
			textTP.setEditable(false);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 53, 1015,2);
			frame.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 98, 1015, 2);
			frame.getContentPane().add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(10, 142, 1015, 2);
			frame.getContentPane().add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(10, 192, 1015, 2);
			frame.getContentPane().add(separator_3);
			
			JSeparator separator_4 = new JSeparator();
			separator_4.setBounds(10, 248, 1015, 2);
			frame.getContentPane().add(separator_4);
			
			JSeparator separator_5 = new JSeparator();
			separator_5.setBounds(10, 298, 1015, 2);
			frame.getContentPane().add(separator_5);
			
			JSeparator separator_6 = new JSeparator();
			separator_6.setBounds(10, 342, 1015, 2);
			frame.getContentPane().add(separator_6);
			
			JSeparator separator_7 = new JSeparator();
			separator_7.setBounds(10, 396, 1015, 2);
			frame.getContentPane().add(separator_7);
			
			JSeparator separator_8 = new JSeparator();
			separator_8.setBounds(10, 449, 1015, 2);
			frame.getContentPane().add(separator_8);
			
			JSeparator separator_9 = new JSeparator();
			separator_9.setBounds(10, 493, 1015, 2);
			frame.getContentPane().add(separator_9);
		 
			JButton EditButton = new JButton("Edit Order Information");
			EditButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//enable text field Status
					
					textSTATUS.setEditable(true);
					String Status = textSTATUS.getText();
					Double st = Double.parseDouble(Status);
					checkForError();
					
				}
			});
			EditButton.setBounds(245, 584, 177, 29);
			frame.getContentPane().add(EditButton);
			
			JButton SaveButton = new JButton("Save Order ");
			SaveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					stk.getOrders();
					
				}
			});
			SaveButton.setBounds(591, 584, 177, 26);
			frame.getContentPane().add(SaveButton);
			
	 }
}



 boolean checkForError()
 {

     if(textPR.getText()!=null && textSTATUS.getText()!=null)
     {
		 if((textSTATUS.getText()>=1 && textSTATUS.getText()=< 5) && (textPR.getText()).matches("[0-9]+"))
		 {
			 return true;
		 }
	     else
	     {   
			 System.out.println("Some of the data you have entered must be invalid.Please try again");
			 return false;
	      }
			
      }
      else
      {
   	   System.out.println("You didn't fill in all the information needed.Please try again.");
   	   return false;
      }
	 
	 
	 
 }



