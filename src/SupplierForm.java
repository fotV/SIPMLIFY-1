
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
	private ArrayList<Supplier> suppliers;
	private JPanel panel ;
	private JTextField name;
	private JTextField lastname;
	private JTextField id;
	private JTextField phonenumber;
	private JTextField afm;
	private JButton add;
	
	public SupplierForm(OrderManager Om) {
		
		
		panel = new JPanel();
		
		JLabel labelname = new JLabel("Name :");
		labelname.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		labelname.setHorizontalAlignment(SwingConstants.CENTER);
		labelname.setBounds(117, 144, 89, 49);
		panel.add(labelname);
		
	
		
		JLabel labelid = new JLabel("ID :");
		labelid.setHorizontalAlignment(SwingConstants.CENTER);
		labelid.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		labelid.setBounds(117, 294, 63, 28);
		panel.add(labelid);
		
		JLabel PhoneNumber = new JLabel("PhoneNumber :");
		PhoneNumber.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		PhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumber.setBounds(94, 369, 194, 28);
		panel.add(PhoneNumber);
		
		JLabel AFM = new JLabel("AFM :");
		AFM.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		AFM.setHorizontalAlignment(SwingConstants.CENTER);
		AFM.setBounds(117, 434, 71, 28);
		panel.add(AFM);
		
		name = new JTextField();
		name.setBounds(393, 162, 248, 31);
		panel.add(name);
		name.setColumns(10);
	
		
		id = new JTextField();
		id.setBounds(393, 298, 248, 31);
		panel.add(id);
		id.setColumns(10);
		
		phonenumber = new JTextField();
		phonenumber.setBounds(393, 369, 248, 31);
		panel.add(phonenumber);
		phonenumber.setColumns(10);
		
		afm = new JTextField();
		afm.setBounds(393, 436, 248, 31);
		panel.add(afm);
		afm.setColumns(10);
		JButton add = new JButton("Add Supplier");
		add.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
		add.setBounds(428,522, 194, 49);
		panel.add(add);
		
		panel.setBackground(new Color(136,177,179));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Lastname :");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(126, 227, 115, 38);
		panel.add(lblNewLabel_4);
		
		lastname = new JTextField();
		lastname.setBounds(393, 236, 248, 31);
		panel.add(lastname);
		lastname.setColumns(10);
		
		ButtonListener listener = new ButtonListener();
		add.addActionListener(listener);
		
		this.setTitle("SupplierForm");
		this.setVisible(true);
		this.setBounds(100, 100, 1041, 653);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
		
			String Suppliername = name.getText();
			String Supplierlastname = lastname.getText();
			String Supplierid = id.getText();
			String SuppliernphoneNumber = phonenumber.getText();
			String SupplierAFM = afm.getText();
			String SupplierOrdermanagerid =null;
			
			Supplier selectedsupplier=null;
			for(Supplier s : suppliers)
			{
				if (s.getId().equals(Supplierid))
				{
					selectedsupplier = s;
					System.out.println("The supplier already exists");
					break;
				}
			}	
			if (selectedsupplier!=null) {
				if (e.getSource().equals(add)) {
					
		
			Supplier s = new Supplier(Suppliername,Supplierlastname,Supplierid,SuppliernphoneNumber,SupplierAFM,SupplierOrdermanagerid);
			SupplierOrdermanagerid = s.getOrderManagerId();	
			suppliers.add(s);
				
					
				}
				
				
			}
		
			
			
		}

	
}
}
