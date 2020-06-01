
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
  import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;




public class SupplierForm extends JFrame {
	
	
	/*SypplierForm.java
	 * Purpose : Displays the GUI of a form for the ordermanager.Add a supplier to the database.
	 * @author Vlasakoudi Christina
	 */
	
	
	private JPanel panel ;
	private JTextField name;
	private JTextField lastname;
	private JTextField id;
	private JTextField phonenumber;
	private JTextField afm;
	private JButton add;
	private boolean errorFlag;//false if there is no error else true
	private OrderManager ordermanager;
	
	public SupplierForm(OrderManager ordermanager) {
		this.ordermanager=ordermanager;
		
	}
	
	
	public void AddSupplier() {
		/* Creates GUI and adds supplier in ArrayList Supplier if there is no error in filled form*/
		
		//creation of gui
		
        panel = new JPanel();
        
        //name label
		
		JLabel labelname = new JLabel("Name :");
		labelname.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		labelname.setHorizontalAlignment(SwingConstants.CENTER);
		labelname.setBounds(117, 144, 89, 49);
		panel.add(labelname);
		
	//id label
		
		JLabel labelid = new JLabel("ID :");
		labelid.setHorizontalAlignment(SwingConstants.CENTER);
		labelid.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		labelid.setBounds(117, 294, 63, 28);
		panel.add(labelid);
	//phonenumber label
		
		JLabel PhoneNumber = new JLabel("PhoneNumber :");
		PhoneNumber.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		PhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumber.setBounds(94, 369, 194, 28);
		panel.add(PhoneNumber);
		//afm label
		
		JLabel AFM = new JLabel("AFM :");
		AFM.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		AFM.setHorizontalAlignment(SwingConstants.CENTER);
		AFM.setBounds(117, 434, 71, 28);
		panel.add(AFM);
		
		//name textfield
		
		name = new JTextField();
		name.setBounds(393, 162, 248, 31);
		panel.add(name);
		name.setColumns(10);
	//id textfield
		
		id = new JTextField();
		id.setBounds(393, 298, 248, 31);
		panel.add(id);
		id.setColumns(10);
		
		//phonenumber textfield
		
		phonenumber = new JTextField();
		phonenumber.setBounds(393, 369, 248, 31);
		panel.add(phonenumber);
		phonenumber.setColumns(10);
		
		//afm textfield
		
		afm = new JTextField();
		afm.setBounds(393, 436, 248, 31);
		panel.add(afm);
		afm.setColumns(10);
		//button add supplier
		
		JButton add = new JButton("Add Supplier");
		add.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
		add.setBounds(428,522, 194, 49);
		panel.add(add);
		
		panel.setBackground(new Color(136,177,179));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//lastname babel
		
		JLabel lblNewLabel_4 = new JLabel("Lastname :");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(126, 227, 115, 38);
		panel.add(lblNewLabel_4);
		
		//lastname textfield
		
		lastname = new JTextField();
		lastname.setBounds(393, 236, 248, 31);
		panel.add(lastname);
		lastname.setColumns(10);
		
		
		
		
		
		add.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				
			String Suppliername = name.getText();
			String Supplierlastname = lastname.getText();
			String Supplierid = id.getText();
			String SuppliernphoneNumber = phonenumber.getText();
			String SupplierAFM = afm.getText();
			String SupplierOrdermanagerid =null;
			

			//calls checkError function before adding client 
			errorFlag = checkError(Suppliername,Supplierlastname,Supplierid,SuppliernphoneNumber,SupplierAFM,SupplierOrdermanagerid);
			
			//if errorFlag = false there is no error, adds client in ArrayList Buyers
			if(!errorFlag)
			{
				
				Supplier supplier = new Supplier(Suppliername,Supplierlastname,Supplierid,SuppliernphoneNumber,SupplierAFM,SupplierOrdermanagerid);
				ordermanager.getSuppliers().suppliers.add(supplier);
				
			}
		
			}

			
			
		});
		
		this.setTitle("SupplierForm");
		this.setVisible(true);
		this.setBounds(100, 100, 1041, 653);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private boolean checkError(String Suppliername,String Supplierlastname,String Supplierid,String SuppliernphoneNumber,String SupplierAFM,String SupplierOrdermanagerid)
	{
		/* Purpose : Checks if the filled form has all the fields filled and there is no such supplier already in database*/
		 
		
		//checks if all fields are filled
		
		errorFlag = false;
		
		if(Suppliername.isEmpty())
		{
			if(Suppliername.length() != 10) {
			JOptionPane.showMessageDialog(null, "Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
			}
			
		}	
		
		if(	Supplierlastname.isEmpty())
		{
			if(Supplierlastname.length() != 10){
			JOptionPane.showMessageDialog(null, "Last Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;	
			}
			
		}
		
		if(Supplierid.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Buyer ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(!Supplierid.isEmpty())
		{
			if(Supplierid.length() != 6)
			{
				JOptionPane.showMessageDialog(null,"Wrong ID Input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(SupplierAFM.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "AFM Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(!SupplierAFM.isEmpty())
		{
			if(SupplierAFM.length() != 10)
			{
				JOptionPane.showMessageDialog(null, "Wrong AFM Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(SuppliernphoneNumber.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Phone Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(!SuppliernphoneNumber.isEmpty())
		{
			if(SuppliernphoneNumber.length() != 10)
			{
				JOptionPane.showMessageDialog(null, "Wrong Phone Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
		}
		if(!SupplierOrdermanagerid.isEmpty()) {
			if(SupplierOrdermanagerid.length() != 6) {
				JOptionPane.showMessageDialog(null, "Wrong Ordermanagerid Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
		}
		
		//checks if buyer already exists in database
		
		boolean exists = false;
		int i = 0;
		if((!Supplierid.isEmpty()) && (Supplierid.length() == 6 ))
		{
			Suppliers supplier = new Suppliers();
			ArrayList<Supplier> supplierID = supplier.getSuppliers(); 
			while(( i < supplierID.size()) && !exists)
			{
				if(supplierID.get(i).getId().equals(Supplierid))
				{
					exists = true;
				}
				
				i++;
			}
		}
		if(exists == true)
		{
			JOptionPane.showMessageDialog(null, "Supplier with the same ID already exists","Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}	
		
		return errorFlag;
	}
}
		
	
	

		 
			
		
			
		
	


