package src;
import java.awt.Color;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class OrderForm extends JFrame{
	
	private JPanel panel;
	private JButton btnAdd;
	private JLabel lblorderid;
	private JLabel lblSupplierid;
	private JLabel lblProductId;
	private JLabel lblQuantity ;
	private JTextField textFieldOid;
	private JTextField textFieldSid;
	private JTextField textFieldPid;
	private JTextField textFieldQ;
	
	public OrderForm(OrderManager om)
	{
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(135, 206, 235));

		
		lblorderid = new JLabel("Order ID :");
		lblorderid.setBounds(22, 36, 121, 41);
		lblorderid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblSupplierid = new JLabel("Supplier ID:");
		lblSupplierid.setBounds(22, 98, 121, 41);
		lblSupplierid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblProductId = new JLabel("Product ID ");
		lblProductId.setBounds(22, 167, 121, 33);
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setBounds(22, 227, 121, 41);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		textFieldOid = new JTextField();
		textFieldOid.setBounds(179, 45, 247, 28);
		textFieldOid.setColumns(10);
		
		textFieldSid = new JTextField();
		textFieldSid.setBounds(179, 107, 247, 28);
		textFieldSid.setColumns(10);
		
		textFieldPid = new JTextField();
		textFieldPid.setBounds(179, 172, 247, 28);
		textFieldPid.setColumns(10);
		
		textFieldQ = new JTextField();
		textFieldQ.setBounds(179, 236, 247, 28);
		panel.add(textFieldQ);
		textFieldQ.setColumns(10);
		
		
		panel.setLayout(null);
		panel.add(lblorderid);
		panel.add(textFieldOid);
		panel.add(lblSupplierid);
		panel.add(textFieldSid);
		panel.add(lblProductId);
		panel.add(lblQuantity);
		panel.add(textFieldPid);
		panel.add(textFieldQ);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdd.setBounds(400, 320, 103, 28);
		panel.add(btnAdd);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 493, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 154, 493, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 214, 493, 2);
		panel.add(separator_2);
		
	
		btnAdd.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//creating an order
				Order order = new Order();

				//having checked for errors
				if (checkForError(om))
				{
					//fill Order Manager Id
					order.orderManagerId=om.id;
					
					//fill Order Id
					order.orderId=textFieldOid.getText(); 			
					
					//fill  Quantity
					double Value = Double.parseDouble(textFieldQ.getText());
					order.setQuantity=Value;								
					
					
					//fill Supplier Id
					order.supplierId = textFieldSid.getText();
					
					for (Supplier s : om.suppliers.suppliers)		
					{
						//According to the given Supplier Id
						if (order.supplierId.equals(s.getId()))		
						{
							//fill Supplier Name
							order.supplierName=s.getName();
							
							//fill Supplier AFM
							order.supplierAFM = s.getAFM();
						}
					}
					
					//get today's date in the preferable format
					SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date(System.currentTimeMillis());
					//fill Date
					order.date= formatter.format(date);	
					
					//fill status
					order.status=0;
					
					//fill Product Id
					order.productId= textFieldPid.getText();
					
					
					for (CompanyProduct cp : om.products.products)	
					{
						//According to the given Product Id
						if (order.productId.equals(cp.getId()))
							//fill Product Name
							order.productName=cp.getName();
					}
					
				
					for(Suppl spl : om.supplies.supplies)
					{
						//According to the given Supplier Id and the given Product Id
						if(spl.getSellerId().equals(order.supplierId) && (spl.getProductId().equals(order.productId)))
							//fill Price
							order.price=spl.getPrice();
					}
					
					//fill total price
					order.totalPrice=order.price * order.quantity;
				
					om.addOrder(order);
				}
			}	
		});
		
		
		this.setVisible(true);
		this.getContentPane().add(panel);
		this.setResizable(false);
		this.setBounds(100, 100, 529, 396);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
	}
	
	private boolean checkForError(OrderManager om) {
		Component f = null;
		int i=0;
		
		//checking if the text fields aren't empty.
		if (textFieldOid.getText()!=null && textFieldSid.getText()!=null && textFieldPid.getText()!=null)
		{
			//checking if the order id that was given doesn't already exist.
			for (Order o : om.orders.orders)		
			{
				if (!textFieldOid.getText().equals(o.orderId)) i++;
			}
		
			//checking if the supplier id that was given exists.
			for (Supplier s : om.suppliers.suppliers)		
			{
				if (textFieldSid.getText().equals(s.getId())) i++;
			}
			
			//checking if the product id that was given exists.
			for (CompanyProduct cp : om.products.products)	
			{
				if (textFieldPid.getText().equals(cp.getId())) i++;
			}
			
			for(Suppl spl : om.supplies.supplies)
			{
				if(spl.getSellerId().equals(textFieldSid.getText()) && (spl.getProductId().equals(textFieldPid.getText()))) i++;
			}
		}
		
		//checking if the quantity that was given isn't empty and is a double positive number
		if (isNumeric(textFieldQ.getText()))
		{
			if (Double.parseDouble(textFieldQ.getText())>0) i++;;
		}

		
		if(i==5) return true;
		else
		{
			JOptionPane.showMessageDialog(f, "Invalid input", "Inane error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	private static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

}
