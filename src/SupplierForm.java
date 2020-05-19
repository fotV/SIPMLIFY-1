package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dialog.ModalExclusionType;

public class SupplierForm {

	private JFrame frame;
	private JTextField namefield;
	private JTextField lastnamefield;
	private JTextField idfield;
	private JTextField phoneNumberfield;
	private JTextField AFMfield;
	private ArrayList<Supplier> suppliers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierForm window = new SupplierForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupplierForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add a Supplier");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 834, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
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
		
		namefield = new JTextField();
		namefield.setBounds(248, 82, 245, 19);
		panel.add(namefield);
		namefield.setColumns(10);
		
		lastnamefield = new JTextField();
		lastnamefield.setBounds(248, 82, 245, 19);
		panel.add(lastnamefield);
		lastnamefield.setColumns(10);
		
		idfield = new JTextField();
		idfield.setBounds(248, 131, 245, 19);
		panel.add(idfield);
		idfield.setColumns(10);
		
		phoneNumberfield = new JTextField();
		phoneNumberfield.setBounds(248, 190, 245, 19);
		panel.add(phoneNumberfield);
		phoneNumberfield.setColumns(10);
		
		AFMfield = new JTextField();
		AFMfield.setBounds(245, 240, 248, 19);
		panel.add(AFMfield);
		AFMfield.setColumns(10);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String Suppliername = namefield.getText();
			String Supplierlastname = lastnamefield.getText();
			String Supplierid = idfield.getText();
			String SuppliernphoneNumber = phoneNumberfield.getText();
			String SupplierAFM = AFMfield.getText();
			
			
			Supplier s = new Supplier(Suppliername,Supplierlastname,Supplierid,SuppliernphoneNumber,SupplierAFM);
			
<<<<<<< HEAD
			Suppliers.add(s);
=======
			suppliers.add(s);
>>>>>>> f6348febcdb2ec0db992e3097f5719282fbddbc3
			
			
			
			
			
			
		}
		
		
		
		
		
		
	}
}
