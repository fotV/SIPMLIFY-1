
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
	
	private JPanel panel ;
	private JTextField name;
	private JTextField lastname;
	private JTextField id;
	private JTextField phonenumber;
	private JTextField afm;
	private JButton add;
	
	public SupplierForm(Suppliers s) {
		
		
		panel = new JPanel();
		
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 65, 89, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(143, 124, 63, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PhoneNumber :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(63, 183, 135, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AFM :");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(135, 240, 71, 28);
		panel.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(248, 82, 245, 19);
		panel.add(name);
		name.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(248, 82, 245, 19);
		panel.add(lastname);
		lastname.setColumns(10);
		
		id = new JTextField();
		id.setBounds(248, 131, 245, 19);
		panel.add(id);
		id.setColumns(10);
		
		phonenumber = new JTextField();
		phonenumber.setBounds(248, 190, 245, 19);
		panel.add(phonenumber);
		phonenumber.setColumns(10);
		
		afm = new JTextField();
		afm.setBounds(245, 240, 248, 19);
		panel.add(afm);
		afm.setColumns(10);
		JButton add = new JButton("Add Supplier");
		add.setFont(new Font("Arial", Font.BOLD, 14));
		add.setBounds(248, 311, 194, 49);
		panel.add(add);
		
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		ButtonListener listener = new ButtonListener();
		add.addActionListener(listener);
		
		this.setTitle("SupplierForm");
		this.setVisible(true);
		this.setBounds(100, 100, 811, 677);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			
			String Suppliername = name.getText();
			String Supplierlastname = lastname.getText();
			String Supplierid = id.getText();
			String SuppliernphoneNumber = phonenumber.getText();
			String SupplierAFM = afm.getText();
			
			
			Supplier s = new Supplier(Suppliername,Supplierlastname,Supplierid,SuppliernphoneNumber,SupplierAFM);
			
			suppliers.add(s);
			
			
		}

	
}
}
