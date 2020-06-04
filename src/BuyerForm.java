
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
import javax.swing.SwingConstants;
	
public class BuyerForm extends JFrame{
	/*BuyerForm.java
	 * Purpose : Creates the GUI of a form for the seller in order to add a buyer to the database.
	 * @author Fotiadou Vassiliki
	 */
		private JFrame frame;
		private boolean errorFlag;//false if there is no error else true
		private Seller seller;
		
		/* Creates GUI and adds buyer in ArrayList Buyer if there is no error in filled form*/
		public BuyerForm(Seller seller){
			this.seller = seller;
		
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
			
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	
					String name = nameTXT.getText();
					String lastName = lastNameTXT.getText();
					String id = idTXT.getText();
					String afm = afmTXT.getText();
					String phone = phoneTXT.getText();
					
					errorFlag = checkError(name,lastName,id,afm,phone);					//calls checkError function before adding buyer
					
					if(!errorFlag){		//if errorFlag = false there is no error, adds client in ArrayList Buyers
						
						frame.setVisible(false);
						String sellerID = seller.getId();
						Buyer buyer = new Buyer(name,lastName,id,afm,phone,sellerID);
						seller.getBuyers().add(buyer);
					}
				}
			});
			
			frame.setBounds(100,100,1041, 653); 
			frame.setTitle("Buyer Form");
			frame.setResizable(false);
			frame.setLayout(null); 
			frame.setVisible(true);
		}
		
		/* Purpose : Checks if the filled form has all the fields filled and there is no such client already in database*/
		private boolean checkError(String name,String lastName,String id,String afm,String phone){
			
			errorFlag = false;
			
			//checks if all fields are filled
			if(name.isEmpty()){
				JOptionPane.showMessageDialog(null, "Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}	
			
			if(lastName.isEmpty()){
				JOptionPane.showMessageDialog(null, "Last Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			
			if(id.isEmpty()){
				JOptionPane.showMessageDialog(null, "Buyer ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			
			if(afm.isEmpty()){
				JOptionPane.showMessageDialog(null, "AFM Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			
			if(phone.isEmpty()){
				JOptionPane.showMessageDialog(null, "Phone Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			
			//checks if id,afm and phone have the needed number of characters
			if(!id.isEmpty()){
				if(id.length() != 6){
					JOptionPane.showMessageDialog(null,"Wrong ID Input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(!afm.isEmpty()){
				if(afm.length() != 10){
					JOptionPane.showMessageDialog(null, "Wrong AFM Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(!phone.isEmpty()){
				if(phone.length() != 10){
					JOptionPane.showMessageDialog(null, "Wrong Phone Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
					errorFlag = true;
				}
			}
			
			//checks if buyer already exists in database
			boolean exists = false;  //exists = true if buyer already exists in database
			int i = 0;
			if((!id.isEmpty()) && (id.length() == 6 )){
				Buyers buyer = new Buyers();
				ArrayList<Buyer> buyerID = buyer.getBuyers(); 
				while(( i < buyerID.size()) && !exists){
					if(buyerID.get(i).getId().equals(id)){
						exists = true;
					}
					i++;
				}
			}
			if(exists == true){
				JOptionPane.showMessageDialog(null, "Buyer with the same ID already exists","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}	
			return errorFlag;
		}
	}
