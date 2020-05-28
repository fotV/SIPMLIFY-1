
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowBuyerSeller {

	
	private JFrame frame;
	Object object;

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
					try {
						if( object == 'Buyer')
						{
							ShowBuyerSeller window = new ShowBuyerSeller( byr);
						    window.frame.setVisible(true);
						}
						if( object == 'Seller')
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
		frame.setBounds(100, 100, 352, 294);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBuyerInformation = new JLabel("Buyer Information");
		lblBuyerInformation.setBounds(122, 11, 122, 14);
		frame.getContentPane().add(lblBuyerInformation);
		
		JLabel lblName = new JLabel("First name :");
		lblName.setBounds(51, 66, 68, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Last name :");
		lblNewLabel.setBounds(51, 95, 56, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(51, 120, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblAfm = new JLabel("AFM :");
		lblAfm.setBounds(51, 145, 46, 14);
		frame.getContentPane().add(lblAfm);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setBounds(51, 170, 84, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblfname = new JLabel(byr.getName());
		lblfname.setBounds(198, 66, 46, 14);
		frame.getContentPane().add(lblfname);
		
		JLabel lblLname = new JLabel(byr.getLastName());
		lblLname.setBounds(198, 95, 46, 14);
		frame.getContentPane().add(lblLname);
		
		JLabel lblBid = new JLabel(byr.getId());
		lblBid.setBounds(198, 120, 46, 14);
		frame.getContentPane().add(lblBid);
		
		JLabel lblBAFM = new JLabel(byr.getAFM());
		lblBAFM.setBounds(198, 145, 46, 14);
		frame.getContentPane().add(lblBAFM);
		
		JLabel lblBPN = new JLabel(byr.getPnoneNumber());
		lblBPN.setBounds(198, 170, 46, 14);
		frame.getContentPane().add(lblBPN);
	
	
	
	
	}
	
	public ShowBuyerSeller(Seller cl)
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 372, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSellerInformation = new JLabel("Seller Information");
		lblSellerInformation.setBounds(138, 11, 98, 14);
		frame.getContentPane().add(lblSellerInformation);
		
		JLabel lblFirstName = new JLabel("First name :");
		lblFirstName.setBounds(66, 50, 74, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name :");
		lblLastName.setBounds(66, 85, 74, 14);
		frame.getContentPane().add(lblLastName);
		
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(66, 116, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("AFM :");
		lblNewLabel.setBounds(66, 152, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPhoneNum = new JLabel("Phone Number :");
		lblPhoneNum.setBounds(66, 188, 90, 14);
		frame.getContentPane().add(lblPhoneNum);
		
		JLabel lblNewLabel_1 = new JLabel(cl.getFirstName());
		lblNewLabel_1.setBounds(190, 50, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(cl.getSurName());
		lblNewLabel_2.setBounds(190, 85, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(cl.getId());
		lblNewLabel_3.setBounds(190, 116, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(cl.getAFM());
		lblNewLabel_4.setBounds(190, 152, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(cl.getTelephone());
		lblNewLabel_5.setBounds(190, 188, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
	
	
	
	
	}
	
	
}
