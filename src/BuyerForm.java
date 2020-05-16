
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
import javax.swing.SwingConstants;

public class BuyerForm extends JFrame
{
	private JPanel panel;
	private JFrame frame;
	private boolean errorFlag;//false if there is no error else true
	private Seller seller;
	
	public BuyerForm(Seller seller)
	{
		this.seller = seller;
	}
	
	public void addAClient()
	{
		//creation of gui
		
		frame = new JFrame();
		panel=new JPanel();  
		frame.getContentPane().setBackground(new Color(135, 206, 235));
	
		JLabel title = new JLabel("Client Form");
		title.setFont(new Font("Tahoma", Font.BOLD, 15));
		title.setBounds(194, 21, 176, 14);
		frame.getContentPane().add(title);
	
		// name
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLabel.setBounds(26, 86, 71, 14);
		frame.getContentPane().add(nameLabel);
		
		JTextField  nameTXT = new JTextField();
		nameTXT.setBounds(126, 85, 257, 20);
		frame.getContentPane().add( nameTXT);
		nameTXT.setColumns(10);
		
		//last name
		
		JLabel lastNameLabel = new JLabel("Last Name :");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastNameLabel.setBounds(26, 136, 90, 14);
		frame.getContentPane().add(lastNameLabel);
		
		JTextField lastNameTXT = new JTextField();
		lastNameTXT.setColumns(10);
		lastNameTXT.setBounds(126, 135, 257, 20);
		frame.getContentPane().add(lastNameTXT);

		//id
		
		JLabel idLabel = new JLabel("ID :");
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		idLabel.setBounds(26, 186, 71, 14);
		frame.getContentPane().add(idLabel);
		
		JTextField idTXT = new JTextField();
		idTXT.setColumns(10);
		idTXT.setBounds(126, 185, 257, 20);
		frame.getContentPane().add(idTXT);
		
		JLabel idmaxCharacters = new JLabel("(6 characters)");
		idmaxCharacters.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idmaxCharacters.setBounds(126, 202, 109, 14);
		frame.getContentPane().add(idmaxCharacters);
		
		//afm
		
		JLabel afmLabel = new JLabel("AFM :");
		afmLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		afmLabel.setBounds(26, 230, 71, 14);
		frame.getContentPane().add(afmLabel);
		
		JTextField afmTXT = new JTextField();
		afmTXT.setColumns(10);
		afmTXT.setBounds(126, 229, 257, 20);
		frame.getContentPane().add(afmTXT);
		
		JLabel afmMaxCharacters = new JLabel("(10 characters)");
		afmMaxCharacters.setFont(new Font("Tahoma", Font.PLAIN, 10));
		afmMaxCharacters.setBounds(126, 245, 109, 14);
		frame.getContentPane().add(afmMaxCharacters);
		
		//phone
		
		JLabel phonelabel = new JLabel("Phone :");
		phonelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		phonelabel.setBounds(26, 278, 71, 14);
		frame.getContentPane().add(phonelabel);
		
		JTextField phoneTXT = new JTextField();
		phoneTXT.setColumns(10);
		phoneTXT.setBounds(126, 277, 257, 20);
		frame.getContentPane().add(phoneTXT);
		
		JLabel phoneMaxCharacters = new JLabel("(10 characters)");
		phoneMaxCharacters.setFont(new Font("Tahoma", Font.PLAIN, 10));
		phoneMaxCharacters.setBounds(126, 296, 109, 14);
		frame.getContentPane().add(phoneMaxCharacters);
		
		//add button
		
		JButton addButton = new JButton("ADD");
		addButton.setFont(new Font("Tahoma",Font.BOLD, 15));
		addButton.setBounds(425, 340, 89, 23);
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
				
			
				errorFlag = checkError(name,lastName,id,afm,phone);
				
				if(!errorFlag)
				{
					Buyer buyer = new Buyer(name,lastName,id,afm,phone);
					seller.addBuyer(buyer);
					System.exit(0);
					
				}
				
				
			}
		});
		
		
		
		frame.setSize(540, 413); 
		frame.setTitle("Add A Client");
		frame.setLayout(null); 
		frame.setVisible(true);
	}
	
	private boolean checkError(String name,String lastName,String id,String afm,String phone)
	{
		//checks if all fields are filled
		
				JFrame popUp = new JFrame();
				errorFlag = false;
				
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(popUp, "Name Field Must Be Filled");
					errorFlag = true;
				}	
				
				if(lastName.isEmpty())
				{
					JOptionPane.showMessageDialog(popUp, "Last Name Field Must Be Filled");
					errorFlag = true;
				}
				
				if(id.isEmpty())
				{
					JOptionPane.showMessageDialog(popUp, "ID Field Must Be Filled");
					errorFlag = true;
				}
				if(!id.isEmpty())
				{
					if(id.length() != 6)
					{
						JOptionPane.showMessageDialog(popUp, "Wrong ID Input");
					}
				}
				
				if(afm.isEmpty())
				{
					JOptionPane.showMessageDialog(popUp, "AFM Field Must Be Filled");
					errorFlag = true;
				}
				if(!afm.isEmpty())
				{
					if(afm.length() != 10)
					{
						JOptionPane.showMessageDialog(popUp, "Wrong AFM Input");
					}
				}
				
				if(phone.isEmpty())
				{
					JOptionPane.showMessageDialog(popUp, "Phone Field Must Be Filled");
					errorFlag = true;
				}
				if(!phone.isEmpty())
				{
					if(phone.length() != 10)
					{
						JOptionPane.showMessageDialog(popUp, "Wrong Phone Input");
						errorFlag = true;
					}
				}
				
				//checks if buyer already exists in database
				
				if((!id.isEmpty()) && (id.length() == 6 ))
				{
					Buyers buyer = new Buyers();
					ArrayList<Buyer> buyerID = buyer.getBuyers(); 
					for(int i = 0; i < buyerID.size(); i++)
					{
						if(buyerID.get(i).getId().equals(id))
						{
							JOptionPane.showMessageDialog(popUp, "Client with the same ID already exists");
							errorFlag = true;
						}
					}
				}
				
				return errorFlag;
	}
	
}

