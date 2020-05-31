
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

	
public class BuyerForm extends JFrame
{
	/*BuyerForm.java
	 * Purpose : Displays the GUI of a form for the seller in order to add a buyer to the database.
	 * @author Fotiadou Vassiliki
	 */

		private JFrame frame;
		private boolean errorFlag;//false if there is no error else true
		private Seller seller;
		
		public BuyerForm(Seller seller)
		{
			this.seller = seller;
		}
		
		public void addAClient()
		{
			/* Creates GUI and adds buyer in ArrayList Buyer if there is no error in filled form*/
			
			//creation of gui
			
			frame = new JFrame(); 
			frame.getContentPane().setBackground(new Color(136, 177, 179));
		
			// name label and textfield
			
			JLabel nameLabel = new JLabel("First Name :");
			nameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			nameLabel.setBounds(207, 70, 154, 41);
			frame.getContentPane().add(nameLabel);
			
			JTextField  nameTXT = new JTextField();
			nameTXT.setBounds(489, 70, 291, 34);
			frame.getContentPane().add( nameTXT);
			nameTXT.setColumns(10);
			
			//last name label and textfield
			
			JLabel lastNameLabel = new JLabel("Last Name :");
			lastNameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			lastNameLabel.setBounds(207, 180, 154, 41);
			frame.getContentPane().add(lastNameLabel);
			
			JTextField lastNameTXT = new JTextField();
			lastNameTXT.setColumns(10);
			lastNameTXT.setBounds(489, 180, 291, 34);
			frame.getContentPane().add(lastNameTXT);

			//id label and textfield
			
			JLabel idLabel = new JLabel("ID :");
			idLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			idLabel.setBounds(207, 282, 154, 41);
			frame.getContentPane().add(idLabel);
			
			JTextField idTXT = new JTextField();
			idTXT.setColumns(10);
			idTXT.setBounds(489, 292, 291, 34);
			frame.getContentPane().add(idTXT);
			
			JLabel idmaxCharacters = new JLabel("(6 characters)");
			idmaxCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
			idmaxCharacters.setBounds(207, 308, 109, 14);
			frame.getContentPane().add(idmaxCharacters);
			
			//afm label and textfield
			
			JLabel afmLabel = new JLabel("AFM :");
			afmLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			afmLabel.setBounds(207, 406, 154, 41);
			frame.getContentPane().add(afmLabel);
			
			JTextField afmTXT = new JTextField();
			afmTXT.setColumns(10);
			afmTXT.setBounds(489, 406, 291, 34);
			frame.getContentPane().add(afmTXT);
			
			JLabel afmMaxCharacters = new JLabel("(10 characters)");
			afmMaxCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
			afmMaxCharacters.setBounds(207, 432, 109, 14);
			frame.getContentPane().add(afmMaxCharacters);
			
			//phone label and textfield
			
			JLabel phonelabel = new JLabel("Phone Number :");
			phonelabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
			phonelabel.setBounds(207, 502, 182, 41);
			frame.getContentPane().add(phonelabel);
			
			JTextField phoneTXT = new JTextField();
			phoneTXT.setColumns(10);
			phoneTXT.setBounds(489, 509, 291, 34);
			frame.getContentPane().add(phoneTXT);
			
			JLabel phoneMaxCharacters = new JLabel("(10 characters)");
			phoneMaxCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
			phoneMaxCharacters.setBounds(207, 528, 109, 14);
			frame.getContentPane().add(phoneMaxCharacters);
			
			//Separators
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 142, 1017, 2);
			frame.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 259, 1017, 2);
			frame.getContentPane().add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(10, 364, 1017, 2);
			frame.getContentPane().add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(10, 475, 1017, 2);
			frame.getContentPane().add(separator_3);
			
			
			//add button
			
			JButton addButton = new JButton("Add");
			addButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
			addButton.setBounds(928, 583, 90, 25);
			frame.getContentPane().add(addButton);
			
			addButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
				
					String name = nameTXT.getText();
					String lastName = lastNameTXT.getText();
					String id = idTXT.getText();
					String afm = afmTXT.getText();
					String phone = phoneTXT.getText();
					
					//calls checkError function before adding client 
					errorFlag = checkError(name,lastName,id,afm,phone);
					
					//if errorFlag = false there is no error, adds client in ArrayList Buyers
					if(!errorFlag)
					{
						frame.setVisible(false);
						Buyer buyer = new Buyer(name,lastName,id,afm,phone);
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
		
		private boolean checkError(String name,String lastName,String id,String afm,String phone)
		{
			/* Purpose : Checks if the filled form has all the fields filled and there is no such client already in database*/
			 
			
			//checks if all fields are filled
			
			errorFlag = false;
			
			if(name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}	
			
			if(lastName.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Last Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			
			if(id.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Buyer ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			if(!id.isEmpty())
			{
				if(id.length() != 6)
				{
					JOptionPane.showMessageDialog(null,"Wrong ID Input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(afm.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "AFM Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			if(!afm.isEmpty())
			{
				if(afm.length() != 10)
				{
					JOptionPane.showMessageDialog(null, "Wrong AFM Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(phone.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Phone Field Must Be Filled","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}
			if(!phone.isEmpty())
			{
				if(phone.length() != 10)
				{
					JOptionPane.showMessageDialog(null, "Wrong Phone Input","Invalid Input",JOptionPane.ERROR_MESSAGE);
					errorFlag = true;
				}
			}
			
			//checks if buyer already exists in database
			
			boolean exists = false;
			int i = 0;
			if((!id.isEmpty()) && (id.length() == 6 ))
			{
				Buyers buyer = new Buyers();
				ArrayList<Buyer> buyerID = buyer.getBuyers(); 
				while(( i < buyerID.size()) && !exists)
				{
					if(buyerID.get(i).getId().equals(id))
					{
						exists = true;
					}
					
					i++;
				}
			}
			if(exists == true)
			{
				JOptionPane.showMessageDialog(null, "Buyer with the same ID already exists","Invalid Input",JOptionPane.ERROR_MESSAGE);
				errorFlag = true;
			}	
			
			return errorFlag;
		}
		
	}


