
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class ShowBuyerSeller {

	
	private JFrame frame;
	Object object;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
					try {
						if( object == "Buyer")
						{
							ShowBuyerSeller window = new ShowBuyerSeller( byr);
						    window.frame.setVisible(true);
						}
						if( object == "Seller")
						{   
							ShowBuyerSeller window = new ShowBuyerSeller(cl);
						    window.frame.setVisible(true);
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	public ShowBuyerSeller(Buyer byr)
	{
		frame = new JFrame();
		this.setTitle("Buyer Information");
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		JLabel lblName = new JLabel("First name :");
		lblName.setBounds(144, 62, 150, 32);
		lblName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Last name :");
		lblNewLabel.setBounds(144, 170, 150, 32);
		lblNewLabel.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(144, 282, 150, 32);
		lblId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblId);
		
		JLabel lblAfm = new JLabel("AFM :");
		lblAfm.setBounds(144, 385, 150, 32);
		lblAfm.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblAfm);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setBounds(144, 486, 270, 65);
		lblPhoneNumber.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblfname = new JLabel(byr.getName());
		lblfname.setBounds(613, 62, 190, 32);
		lblfname.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblfname);
		
		
		JLabel lblLname = new JLabel(byr.getLastName());
		lblLname.setBounds(613, 189, 264, 32);
		lblLname.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblLname);
		
		
		JLabel lblBid = new JLabel(byr.getId());
		lblBid.setBounds(613, 282, 190, 32);
		lblBid.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBid);
		
		
		JLabel lblBAFM = new JLabel(byr.getAFM());
		lblBAFM.setBounds(198, 145, 46, 14);
		lblBAFM.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBAFM);
	
		
		JLabel lblBPN = new JLabel(byr.getPnoneNumber());
		lblBPN.setBounds(613, 494, 190, 32);
		lblBPN.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBPN);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 245, 1015,2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 349, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 455, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 132, 1015, 2);
		frame.getContentPane().add(separator_3);
		

		
	}
	
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}



	public ShowBuyerSeller(Seller cl)
	{  
		
		frame = new JFrame();
		this.setTitle("Seller information");
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		JLabel lblFirstName = new JLabel("First name :");
		lblFirstName.setBounds(144, 62, 150, 32);
		lblFirstName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name :");
		lblLastName.setBounds(144, 170, 150, 32);
		lblLastName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblLastName);
		
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(144, 282, 150, 32);
		lblId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("AFM :");
		lblNewLabel.setBounds(198, 145, 46, 14);
		lblNewLabel.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPhoneNum = new JLabel("Phone Number :");
		lblPhoneNum.setBounds(144, 486, 270, 65);
		lblPhoneNum.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblPhoneNum);
		
		JLabel lblNewLabel_1 = new JLabel(cl.getFirstName());
		 lblNewLabel_1.setBounds(613, 62, 190, 32);
		lblNewLabel_1.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblNewLabel_1);
	
		
		JLabel lblNewLabel_2 = new JLabel(cl.getSurName());
		lblNewLabel_2.setBounds(613, 189, 264, 32);
		lblNewLabel_2.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel(cl.getId());
		lblNewLabel_3.setBounds(613, 282, 190, 32);
		lblNewLabel_3.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblNewLabel_3);
	
		
		JLabel lblNewLabel_4 = new JLabel(cl.getAFM());
		lblNewLabel_4.setBounds(613, 385, 190, 32);
		lblNewLabel_4.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel(cl.getTelephone());
		lblNewLabel_5 .setBounds(613, 494, 190, 32);
		lblNewLabel_5.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		frame.getContentPane().add(lblNewLabel_5);
		

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 245, 1015,2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 349, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 455, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 132, 1015, 2);
		frame.getContentPane().add(separator_3);
		
	
	
	
	}
	
	
}
