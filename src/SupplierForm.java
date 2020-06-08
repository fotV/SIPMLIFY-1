
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

	/**
	 *SupplierForm.java
	 * Purpose : Creates the GUI of the Supplier Form and adds a supplier if there is no error in the filled fields.
	 * @author Fotiadou Vassiliki, Vlasakoudi Christina
	 */

public class SupplierForm extends JFrame {
	
	private JFrame frame;
	private boolean errorFlag;//false if there is no error else true
	private OrderManager ordermanager;
	
	public SupplierForm(OrderManager ordermanager) {
		this.ordermanager=ordermanager;
	
		frame = new JFrame(); 														//creates gui
		frame.getContentPane().setBackground(new Color(136, 177, 179));
	
		JLabel nameLabel = new JLabel("First Name :");
		nameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));				// first name label and textfield
		nameLabel.setBounds(207, 70, 154, 41);
		frame.getContentPane().add(nameLabel);
		
		JTextField  nameTXT = new JTextField();
		nameTXT.setBounds(489, 70, 291, 34);
		frame.getContentPane().add( nameTXT);
		nameTXT.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name :");
		lastNameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));			//last name label and textfield
		lastNameLabel.setBounds(207, 180, 154, 41);
		frame.getContentPane().add(lastNameLabel);
		
		JTextField lastNameTXT = new JTextField();
		lastNameTXT.setColumns(10);
		lastNameTXT.setBounds(489, 180, 291, 34);
		frame.getContentPane().add(lastNameTXT);
		
		JLabel idLabel = new JLabel("ID :");
		idLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));				//id label and textfield
		idLabel.setBounds(207, 282, 154, 41);
		frame.getContentPane().add(idLabel);
		
		JTextField idTXT = new JTextField();
		idTXT.setColumns(10);
		idTXT.setBounds(489, 292, 291, 34);
		frame.getContentPane().add(idTXT);
		
		JLabel idCharacters = new JLabel("(6 characters)");
		idCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));			//label for id characters
		idCharacters.setBounds(207, 308, 109, 14);
		frame.getContentPane().add(idCharacters);
		
		JLabel afmLabel = new JLabel("AFM :");
		afmLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));				//afm label and textfield
		afmLabel.setBounds(207, 406, 154, 41);
		frame.getContentPane().add(afmLabel);
		
		JTextField afmTXT = new JTextField();
		afmTXT.setColumns(10);
		afmTXT.setBounds(489, 406, 291, 34);
		frame.getContentPane().add(afmTXT);
		
		JLabel afmCharacters = new JLabel("(10 characters)");
		afmCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));			//label for afm characters
		afmCharacters.setBounds(207, 432, 109, 14);
		frame.getContentPane().add(afmCharacters);
		
		JLabel phonelabel = new JLabel("Phone Number :");
		phonelabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));				//phone label and textfield
		phonelabel.setBounds(207, 502, 182, 41);
		frame.getContentPane().add(phonelabel);
		
		JTextField phoneTXT = new JTextField();
		phoneTXT.setColumns(10);
		phoneTXT.setBounds(489, 509, 291, 34);
		frame.getContentPane().add(phoneTXT);
		
		JLabel phoneCharacters = new JLabel("(10 characters)");
		phoneCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));		//label for phone characters
		phoneCharacters.setBounds(207, 528, 109, 14);
		frame.getContentPane().add(phoneCharacters);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 142, 1017, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 259, 1017, 2);
		frame.getContentPane().add(separator_1);									//Separators
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 364, 1017, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 475, 1017, 2);
		frame.getContentPane().add(separator_3);
		
		JButton addButton = new JButton("Add");										//add button
		addButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		addButton.setBounds(928, 583, 90, 25);
		frame.getContentPane().add(addButton);
		
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			String Suppliername = nameTXT.getText();
			String Supplierlastname = lastNameTXT.getText();
			String Supplierid = idTXT.getText();
			String SuppliernphoneNumber = phoneTXT.getText();
			String SupplierAFM = afmTXT.getText();
			
			
			errorFlag = checkError(Suppliername,Supplierlastname,Supplierid,SuppliernphoneNumber,SupplierAFM);	//calls checkError function before adding supplier
			
			//if errorFlag = false there is no error, adds client in ArrayList Suppliers
			if(!errorFlag){
				String SupplierOrdermanagerid = ordermanager.getId();
				Supplier supplier = new Supplier(Suppliername,Supplierlastname,Supplierid,SuppliernphoneNumber,SupplierAFM,SupplierOrdermanagerid);
				ordermanager.getSuppliers().getSuppliers().add(supplier);	
				JOptionPane.showMessageDialog(null, "The supplier has been added!");
				addButton.setEnabled(false);
			}
		
		  }		
		});
		
		frame.setBounds(100,100,1041, 653); 
		frame.setTitle("Supplier Form");
		frame.setResizable(false);
		frame.setLayout(null); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	*Purpose : Checks if the filled form has all the fields filled and there is no such supplier already in database
	*@param Suppliername
	*@param Supplierlastname
	*@param Supplierid
	*@param SupplierphoneNumber
	*@param Supplierafm
	*@return errorFlag
	*/
	private boolean checkError(String Suppliername,String Supplierlastname,String Supplierid,String SuppliernphoneNumber,String SupplierAFM){ 
		
		//checks if all fields are filled
		errorFlag = false;
		
		if(Suppliername.isEmpty()){
			JOptionPane.showMessageDialog(null, "Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}	
		
		if(	Supplierlastname.isEmpty()){
			JOptionPane.showMessageDialog(null, "Last Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;		
		}
		
		if(Supplierid.isEmpty()){
			JOptionPane.showMessageDialog(null, "ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(SupplierAFM.isEmpty()){
			JOptionPane.showMessageDialog(null, "AFM Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(SuppliernphoneNumber.isEmpty()){
			JOptionPane.showMessageDialog(null, "Phone Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		//checks if id,afm and phone have the needed number of characters
		if(!Supplierid.isEmpty()){
			if(Supplierid.length() != 6){
				JOptionPane.showMessageDialog(null,"Wrong ID Input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(!SupplierAFM.isEmpty()){
			if(SupplierAFM.length() != 10){
				JOptionPane.showMessageDialog(null, "Wrong AFM Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(!SuppliernphoneNumber.isEmpty()){
			if(SuppliernphoneNumber.length() != 10){
				JOptionPane.showMessageDialog(null, "Wrong Phone Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
		}
		
		//checks if supplier already exists in database
		
		boolean exists = false;
		int i = 0;
		if((!Supplierid.isEmpty()) && (Supplierid.length() == 6 )){
			Suppliers supplier = new Suppliers();
			ArrayList<Supplier> supplierID = supplier.getSuppliers(); 
			while(( i < supplierID.size()) && !exists){
				if(supplierID.get(i).getId().equals(Supplierid)){
					exists = true;
				}
				
				i++;
			}
		}
		if(exists == true){
			JOptionPane.showMessageDialog(null, "Supplier with the same ID already exists","Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}	
		
		return errorFlag;
	}
}
