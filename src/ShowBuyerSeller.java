import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class ShowBuyerSeller {
	private JFrame frame;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblId;
	private	JLabel lblAfm;
	private	JLabel lblPhoneNumber;
	private	JLabel lblfname;
	private	JLabel lblLname;
	private	JLabel lblBid ;
	private	JLabel lblBAFM ;
	private	JLabel lblBPN ;
	private	JSeparator separator ;
	private	JSeparator separator_1;
	private JSeparator separator_2 ;
	private JSeparator separator_3;
	private Object object;
		
	public ShowBuyerSeller(Buyer byr)
	{
		frame = new JFrame();
		frame.setTitle("Buyer Information");
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		lblName = new JLabel("First name :");
		lblName.setBounds(144, 62, 150, 32);
		lblName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblName);
		
		lblNewLabel = new JLabel("Last name :");
		lblNewLabel.setBounds(144, 170, 150, 32);
		lblNewLabel.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblNewLabel);
		
		lblId = new JLabel("ID :");
		lblId.setBounds(144, 282, 150, 32);
		lblId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblId);
		
		lblAfm = new JLabel("AFM :");
		lblAfm.setBounds(144, 385, 150, 32);
		lblAfm.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblAfm);
		
		lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setBounds(144, 486, 270, 65);
		lblPhoneNumber.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblPhoneNumber);
		
		lblfname = new JLabel(byr.getName());
		lblfname.setBounds(613, 62, 190, 32);
		lblfname.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblfname);
		
		
		lblLname = new JLabel(byr.getLastName());
		lblLname.setBounds(613, 189, 264, 32);
		lblLname.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblLname);
		
		
		lblBid = new JLabel(byr.getId());
		lblBid.setBounds(613, 282, 190, 32);
		lblBid.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBid);
		
		
		lblBAFM = new JLabel(byr.getAFM());
		lblBAFM.setBounds(198, 145, 46, 14);
		lblBAFM.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBAFM);
	
		
		lblBPN = new JLabel(byr.getPhoneNumber());
		lblBPN.setBounds(613, 494, 190, 32);
		lblBPN.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBPN);
		
		separator = new JSeparator();
		separator.setBounds(10, 245, 1015,2);
		frame.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 349, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 455, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 132, 1015, 2);
		frame.getContentPane().add(separator_3);
		

		
	}
	public ShowBuyerSeller(Seller cl)
	{  
		
		frame = new JFrame();
		frame.setTitle("Seller information");
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		lblName = new JLabel("First name :");
		lblName.setBounds(144, 62, 150, 32);
		lblName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblName);
		
		lblLname = new JLabel("Last name :");
		lblLname.setBounds(144, 170, 150, 32);
		lblLname.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblLname);
		
		
		lblId = new JLabel("ID :");
		lblId.setBounds(144, 282, 150, 32);
		lblId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblId);
		
		lblAfm = new JLabel("AFM :");
		lblAfm.setBounds(198, 145, 46, 14);
		lblAfm.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblAfm);
		
		lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setBounds(144, 486, 270, 65);
		lblPhoneNumber.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblPhoneNumber);
		
		lblfname = new JLabel(cl.getName());
		lblfname.setBounds(613, 62, 190, 32);
		lblfname.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblfname);
		
		
		lblLname = new JLabel(cl.getLastName());
		lblLname.setBounds(613, 189, 264, 32);
		lblLname.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblLname);
		
		
		lblBid = new JLabel(cl.getId());
		lblBid.setBounds(613, 282, 190, 32);
		lblBid.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBid);
		
		
		lblBAFM = new JLabel(cl.getAFM());
		lblBAFM.setBounds(198, 145, 46, 14);
		lblBAFM.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBAFM);
	
		
		lblBPN = new JLabel(cl.getPhoneNumber());
		lblBPN.setBounds(613, 494, 190, 32);
		lblBPN.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblBPN);
		

		separator = new JSeparator();
		separator.setBounds(10, 245, 1015,2);
		frame.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 349, 1015, 2);
		frame.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 455, 1015, 2);
		frame.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 132, 1015, 2);
		frame.getContentPane().add(separator_3);
		
	
	
	
	}
	
	
}
