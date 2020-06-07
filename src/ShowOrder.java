
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * ShowOrder.java
 * Purpose: The class is the GUI for showing a single order. Provides the function of editting the order.
 * @author Polyzoidou Eleni, Gkouli Nikoleta
 */
public class ShowOrder {

	JFrame frame = new JFrame();
	private JTextField fieldOrderId;
	private JTextField fieldOMId;
	private JTextField fieldDate;
	private JTextField fieldProductId;
	private JTextField fieldProductName;
	private JTextField fieldQuantity;
	private JTextField fieldPrice;
	private JTextField fieldTotalPrice;
	private JTextField fieldSupId;
	private JTextField fieldSupName;
	private JTextField fieldSupAFM;
	private JTextField fieldSTATUS;
	

	public ShowOrder(User u,Order o) {
	 
	 	User user = u;
	 	Order order = o;
	 	
		frame.setTitle("Order");
		frame.setBounds(100, 100, 1041, 653);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		//Putting Labels on the frame
		JLabel lblOrderId = new JLabel("Order ID :");
		lblOrderId.setBounds(125, 19, 246, 35);
		lblOrderId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblOrderId);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(125, 64, 246, 35);
		lblDate.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblDate);
		
		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setBounds(125, 109, 246, 35);
		lblProductId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblProductId);
		
		JLabel lblProductName = new JLabel("Product Name :");
		lblProductName.setBounds(125, 153, 246, 35);
		lblProductName.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblProductName);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(125, 198, 246, 35);
		lblQuantity.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(125, 243, 246, 35);
		lblPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblPrice);
		
		JLabel lblTotalPrice = new JLabel("Total Price :");
		lblTotalPrice.setBounds(125, 288, 246, 35);
		lblTotalPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblTotalPrice);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(125, 333, 246, 35);
		lblStatus.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblStatus);
	
		//Putting TextFields on the frame
		fieldOrderId = new JTextField(order.getOrderId());
		fieldOrderId.setBounds(682, 22, 200, 28);
		fieldOrderId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldOrderId);
		fieldOrderId.setColumns(10);
		fieldOrderId.setEditable(false);
		
		fieldDate = new JTextField(order.getDate());
		fieldDate.setBounds(682, 67, 200, 28);
		fieldDate.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldDate);
		fieldDate.setColumns(10);
		fieldDate.setEditable(false);
		
		fieldProductId = new JTextField(order.getProductId());
		fieldProductId.setBounds(682, 112, 200, 28);
		fieldProductId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldProductId);
		fieldProductId.setColumns(10);
		fieldProductId.setEditable(false);
		
		fieldProductName = new JTextField(order.getProductName());
		fieldProductName.setBounds(682, 157, 200, 28);
		fieldProductName.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldProductName);
		fieldProductName.setColumns(10);
		fieldProductName.setEditable(false);
		
		fieldQuantity = new JTextField(String.valueOf(order.getQuantity()));
		fieldQuantity.setBounds(682, 202, 200, 28);
		fieldQuantity.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldQuantity);
		fieldQuantity.setColumns(10);
		fieldQuantity.setEditable(false);
		
		fieldPrice = new JTextField(String.valueOf(order.getPrice()));
		fieldPrice.setBounds(682, 247, 200, 28);
		fieldPrice.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldPrice);
		fieldPrice.setColumns(10);
		fieldPrice.setEditable(false);
		
		fieldTotalPrice = new JTextField(String.valueOf(order.getTotalPrice()));
		fieldTotalPrice.setBounds(682, 292, 200, 28);
		fieldTotalPrice.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldTotalPrice);
		fieldTotalPrice.setColumns(10);
		fieldTotalPrice.setEditable(false);
		
		fieldSTATUS = new JTextField(String.valueOf(order.getStatus()));
		fieldSTATUS.setBounds(682, 337, 200, 28);
		fieldSTATUS.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldSTATUS);
		fieldSTATUS.setColumns(10);
		fieldSTATUS.setEditable(false);
		
		fieldOMId = new JTextField(order.getOrderManagerId());
		fieldOMId.setBounds(682, 382, 200, 28);
		fieldOMId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldOMId);
		fieldOMId.setColumns(10);
		fieldOMId.setEditable(false);
		
		fieldSupId = new JTextField(order.getSupplierId());
		fieldSupId.setBounds(682, 427, 200, 28);
		fieldSupId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldSupId);
		fieldSupId.setColumns(10);
		fieldSupId.setEditable(false);
		
		fieldSupName = new JTextField(order.getSupplierName());
		fieldSupName.setBounds(682, 472, 200, 28);
		fieldSupName.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldSupName);
		fieldSupName.setColumns(10);
		fieldSupName.setEditable(false);
		
		fieldSupAFM = new JTextField(order.getSupplierAFM());
		fieldSupAFM.setBounds(682, 512, 200, 28);
		fieldSupAFM.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(fieldSupAFM);
		fieldSupAFM.setColumns(10);
		fieldSupAFM.setEditable(false);
		
		//Putting Separators on the frame	
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 1015,2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 99, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 144, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 189, 1015, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 234, 1015, 2);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 279, 1015, 2);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 324, 1015, 2);
		frame.getContentPane().add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 369, 1015, 2);
		frame.getContentPane().add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(10, 414, 1015, 2);
		frame.getContentPane().add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(10, 459, 1015, 2);
		frame.getContentPane().add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(10, 504, 1015, 2);
		frame.getContentPane().add(separator_10);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(10, 549, 1015, 2);
		frame.getContentPane().add(separator_11);
		
		//Putting Buttons on the frame
		JButton EditButton = new JButton("Edit Order");
		EditButton.setBounds(245, 584, 177, 29);
		frame.getContentPane().add(EditButton);
		
		JButton doneB  = new JButton("Save");
		doneB.setBounds(445, 584, 177, 29);
		doneB.setEnabled(false);
		frame.getContentPane().add(doneB);
	 
	 if (user instanceof OrderManager) {
	   
		OrderManager ord = (OrderManager) user ;
		
		JLabel lblOrderManagerId = new JLabel("Order Manager ID :");
		lblOrderManagerId.setBounds(125, 378, 246, 35);
		lblOrderManagerId.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblOrderManagerId);
		 
		JLabel lblSupplierId = new JLabel("Supplier ID :");
		lblSupplierId.setBounds(125, 423, 246, 35);
		lblSupplierId.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblSupplierId);
		
		JLabel lblSupplierName = new JLabel("Supplier Name :");
		lblSupplierName.setBounds(125, 468, 246, 35);
		lblSupplierName.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblSupplierName);
		
		JLabel lblSupplierAFM = new JLabel("Supplier AFM :");
		lblSupplierAFM.setBounds(125, 513, 246, 35);
		lblSupplierAFM.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.getContentPane().add(lblSupplierAFM);
		
		//A user of type OrderManager can only change the fieldSTATUS
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fieldSTATUS.setEditable(true);
				doneB.setEnabled(true);
				doneB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean flag = checkForError();
						if (flag) {
							String status = fieldSTATUS.getText();
							if (!status.equals("")) {
								Integer st = Integer.parseInt(status);
								int thesi = ord.getOrders().getOrders().indexOf(order);
								ord.getOrders().getOrders().get(thesi).setStatus(st);
							}
							fieldSTATUS.setEditable(false); 
							doneB.setEnabled(false);
						}
					}
				});
			}
		});
	 }
	 else if (user instanceof Seller ) { 
		 
		 	Seller sel = (Seller ) user;
		 
		 	JLabel lblBuyerId = new JLabel("Buyer ID :");
		 	lblBuyerId.setBounds(125, 378, 246, 35);
		 	lblBuyerId.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblBuyerId);
			 
			JLabel lblSellerId = new JLabel("Seller ID :");
			lblSellerId.setBounds(125, 423, 246, 35);
			lblSellerId.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSellerId);
			
			JLabel lblSellerName = new JLabel("Seller Name :");
			lblSellerName.setBounds(125, 468, 246, 35);
			lblSellerName.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSellerName);
			
			JLabel lblSellerAFM = new JLabel("Seller AFM :");
			lblSellerAFM.setBounds(125, 513, 246, 35);
			lblSellerAFM.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSellerAFM);
			
			//A user of type Seller can only change the fieldSTATUS, the fieldPrice and the fieldQuantity
			EditButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					fieldSTATUS.setEditable(true);
					fieldPrice.setEditable(true);
					fieldQuantity.setEditable(true);
					doneB.setEnabled(true);
					doneB.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							boolean flag = true;
							flag = checkForError();
							if (flag) {
								int thesi = sel.getOrders().getOrders().indexOf(order);
								String status = fieldSTATUS.getText();
								if (!status.equals("")) {
									Integer st = Integer.parseInt(status);
									sel.getOrders().getOrders().get(thesi).setStatus(st);
								}
								if (!fieldQuantity.getText().equals("") && !fieldPrice.getText().equals("")) {
									Double quantity = Double.parseDouble(fieldQuantity.getText());
									sel.getOrders().getOrders().get(thesi).setQuantity(quantity);
									Double price = Double.parseDouble(fieldPrice.getText());
									sel.getOrders().getOrders().get(thesi).setPrice(price);
									fieldTotalPrice.setText("" + (price*quantity));
									sel.getOrders().getOrders().get(thesi).setTotalPrice(price*quantity);	
								}
			
							fieldSTATUS.setEditable(false);
							fieldPrice.setEditable(false);
							fieldQuantity.setEditable(false); 
							doneB.setEnabled(false);
							}
						}
					});
				}
			});	
	 }
	 else { 
		 	Stockkeeper stk = (Stockkeeper) user;
	     
		 	JLabel lblOrderManagerId = new JLabel("Order Manager ID :");
			lblOrderManagerId.setBounds(125, 378, 246, 35);
			lblOrderManagerId.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblOrderManagerId);
			 
			JLabel lblSupplierId = new JLabel("Supplier ID :");
			lblSupplierId.setBounds(125, 423, 246, 35);
			lblSupplierId.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSupplierId);
			
			JLabel lblSupplierName = new JLabel("Supplier Name :");
			lblSupplierName.setBounds(125, 468, 246, 35);
			lblSupplierName.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSupplierName);
			
			JLabel lblSupplierAFM = new JLabel("Supplier AFM :");
			lblSupplierAFM.setBounds(125, 513, 246, 35);
			lblSupplierAFM.setFont(new Font("Dialog", Font.PLAIN, 20));
			frame.getContentPane().add(lblSupplierAFM);
			
			//A user of type Stockkeeper can only change the fieldSTATUS
			EditButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					fieldSTATUS.setEditable(true);
					doneB.setEnabled(true);
					doneB.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							boolean flag = checkForError();
							if (flag) {
								String status = fieldSTATUS.getText();
								if (!status.equals("")) {
									Integer st = Integer.parseInt(status);
									int thesi = stk.getOrders().getOrders().indexOf(order);
									stk.getOrders().getOrders().get(thesi).setStatus(st);
								}
								fieldSTATUS.setEnabled(false);
								JOptionPane.showMessageDialog(frame, "Changes have been saved!"); 
								doneB.setEnabled(false);
							}
						}
					});
					
				}
			});
				
	 }
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}


	/**
	 * The method checks if the inserted values in the TextFields are correct.
	 * @return flag declares if an insertion mistake has been occured (boolean)
	 */
	private boolean checkForError(){
		boolean flag = true;
		//if all fields are empty, show error Message                            
		if (fieldQuantity.getText().equals("") && fieldPrice.getText().equals("") && fieldSTATUS.getText().equals("")) {      
			JOptionPane.showMessageDialog(frame, "All fields are empty");                            
			flag = false;
		//fields should match  regex for integer and double number
		}else if (!(fieldQuantity.getText().matches("[0-9]+|[0-9]+[.]{1}[0-9]+") || fieldPrice.getText().matches("[0-9]+|[0-9]+[.]{1}[0-9]+"))) {    
			JOptionPane.showMessageDialog(frame, "Fields must contain digit");
			flag = false;
		}
		//fieldSTATUS can only get values from 1 to 5
		Integer stat = Integer.parseInt(fieldSTATUS.getText());
		if (stat<1 || stat>5) {
			JOptionPane.showMessageDialog(frame, "Status must get value from 1 to 5");
			flag = false;
		}
		
		return flag;	
	}

}


