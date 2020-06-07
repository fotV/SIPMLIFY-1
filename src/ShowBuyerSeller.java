import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;



public class ShowBuyerSeller {
	private JFrame frame;
	private JLabel lblName;
	private JLabel lblLastName;
	private JLabel lblId;
	private	JLabel lblAfm;
	private	JLabel lblPhoneNumber;
	private JLabel labelName;
	private JLabel labelLastName;
	private JLabel labelId;
	private JLabel labelAfm;
	private JLabel labelPhoneNumber;
	private	JSeparator separator ;
	private	JSeparator separator_1;
	private JSeparator separator_2 ;
	private JSeparator separator_3;
		
	public ShowBuyerSeller(Object o){
		frame = new JFrame();
		frame.setTitle("Seller information");
		frame.setBounds(100, 100, 1041, 653);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		lblName = new JLabel("First name :");
		lblName.setBounds(144, 70, 150, 32);
		lblName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblName);
		
		lblLastName = new JLabel("Last name :");
		lblLastName.setBounds(144, 170, 150, 32);
		lblLastName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblLastName);
		
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
		
		if (o instanceof Buyer) {
			Buyer byr = (Buyer) o;
		
			frame.setTitle("Buyer Information");
		
			labelName = new JLabel(byr.getName());
			labelName.setBounds(613, 62, 190, 32);
			labelName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelName);
		
			labelLastName = new JLabel(byr.getLastName());
			labelLastName.setBounds(613, 170, 264, 32);
			labelLastName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelLastName);
		
			labelId = new JLabel(byr.getId());
			labelId.setBounds(613, 282, 190, 32);
			labelId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelId);
		
			labelAfm = new JLabel(byr.getAFM());
			labelAfm.setBounds(613, 385, 190, 32);
			labelAfm.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelAfm);
	
			System.out.println(byr.getPhoneNumber());
			labelPhoneNumber = new JLabel(byr.getPhoneNumber());
			labelPhoneNumber.setBounds(613, 494, 190, 32);
			labelPhoneNumber.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelPhoneNumber);
		
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
		else if (o instanceof Supplier) {
			Supplier cl = (Supplier) o;
		
			frame.setTitle("Supplier information");
	
			labelName = new JLabel(cl.getName());
			labelName.setBounds(613, 70, 150, 32);
			labelName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelName);
		
			labelLastName = new JLabel(cl.getLastName());
			labelLastName.setBounds(613, 175, 190, 32);
			labelLastName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelLastName);
		
		
			labelId = new JLabel(cl.getId());
			labelId.setBounds(613, 282, 190, 32);
			labelId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelId);
		
			labelAfm = new JLabel(cl.getAFM());
			labelAfm.setBounds(613, 385, 190, 32);
			labelAfm.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelAfm);
	
			labelPhoneNumber = new JLabel(cl.getPhoneNumber());
			labelPhoneNumber.setBounds(613, 499, 190, 32);
			labelPhoneNumber.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
			frame.getContentPane().add(labelPhoneNumber);
		
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
		frame.setVisible(true);
	}
	
	
}
