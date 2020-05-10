
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public BuyerForm()
	{
	
	}
	
	public void addAClient()
	{
		//creation of gui
		
		frame = new JFrame();
		panel=new JPanel();  
		frame.getContentPane().setBackground(new Color(135, 206, 235));
	
		JLabel title = new JLabel("Add A Client Form");
		title.setFont(new Font("Tahoma", Font.BOLD, 15));
		title.setBounds(175, 11, 176, 14);
		frame.getContentPane().add(title);
	
		JLabel idLabel = new JLabel("ID :");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idLabel.setBounds(26, 86, 71, 14);
		frame.getContentPane().add(idLabel);
		
		JTextField idTXT = new JTextField();
		idTXT.setBounds(126, 85, 257, 20);
		frame.getContentPane().add(idTXT);
		idTXT.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(26, 136, 71, 14);
		frame.getContentPane().add(nameLabel);
		
		JTextField nameTXT = new JTextField();
		nameTXT.setColumns(10);
		nameTXT.setBounds(126, 135, 257, 20);
		frame.getContentPane().add(nameTXT);

		JLabel phoneLabel = new JLabel("Phone Number :");
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneLabel.setBounds(26, 186, 71, 14);
		frame.getContentPane().add(phoneLabel);
		
		JTextField phoneTXT = new JTextField();
		phoneTXT.setColumns(10);
		phoneTXT.setBounds(126, 185, 257, 20);
		frame.getContentPane().add(phoneTXT);
		
		JLabel afmLabel = new JLabel("AFM :");
		afmLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		afmLabel.setBounds(26, 230, 71, 14);
		frame.getContentPane().add(afmLabel);
		
		JTextField afmTXT = new JTextField();
		afmTXT.setColumns(10);
		afmTXT.setBounds(126, 229, 257, 20);
		frame.getContentPane().add(afmTXT);
		
		JButton addButton = new JButton("ADD");
		addButton.setBounds(397, 310, 89, 23);
		frame.getContentPane().add(addButton);
		
		addButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String id = idTXT.getText();
				String name = nameTXT.getText();
				String phone = phoneTXT.getText();
				String afm = afmTXT.getText();
			
				errorFlag = checkError(name,id,afm,phone);
				
				if(!errorFlag)
				{
					Buyer buyer = new Buyer(name, id, afm, phone);
					System.exit(0);
					
				}
				
				
			}
		});
		
		
		
		frame.setSize(512, 383); 
		frame.setTitle("Add A Client");
		frame.setLayout(null); 
		frame.setVisible(true);
	}
	
	private boolean checkError(String name,String id,String afm,String phone)
	{
		//checks if all fields are filled
		
		JFrame popUp = new JFrame();
		errorFlag = false;
		
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "ID Field Must Be Filled");
			errorFlag = true;
		}
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Name Field Must Be Filled");
			errorFlag = true;
		}
		if(phone.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "Phone Field Must Be Filled");
			errorFlag = true;
		}
		if(afm.isEmpty())
		{
			JOptionPane.showMessageDialog(popUp, "AFM Field Must Be Filled");
			errorFlag = true;
		}
		
		
		return errorFlag;
	}
	
}

