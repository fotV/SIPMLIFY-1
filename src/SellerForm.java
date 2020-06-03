
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SellerForm extends JFrame{
	
	
	/*
	 * The following constructor creates the gui for the Stock Keeper Form (home page)
	 */
	public SellerForm(Seller s)
	{
		JPanel panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(936, 510, 89, 74);
		panel.add(btnNewButton);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblFirstName.setBounds(225, 99, 159, 32);
		panel.add(lblFirstName);
		
		
		JLabel lblSurname = new JLabel("SurName:");
		lblSurname.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblSurname.setBounds(225, 192, 159, 32);
		panel.add(lblSurname);
		
		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblTelephone.setBounds(225, 272, 159, 32);
		panel.add(lblTelephone);
		
		JLabel lblAfm = new JLabel("AFM :");
		lblAfm.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblAfm.setBounds(225, 355, 159, 32);
		panel.add(lblAfm);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblId.setBounds(225, 427, 159, 32);
		panel.add(lblId);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 167, 984, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 246, 981, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 331, 981, 2);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 414, 981, 2);
		panel.add(separator_3);
		
		
		JLabel lblResultname = new JLabel(s.getFirstName());
		lblResultname.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		lblResultname.setBounds(608, 102, 226, 26);
		panel.add(lblResultname);
		
		JLabel label_4 = new JLabel(s.getSurName());
		label_4.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		label_4.setBounds(608, 195, 226, 26);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel(s.getTelephone());
		label_5.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		label_5.setBounds(608, 275, 226, 26);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel(s.getAFM());
		label_6.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		label_6.setBounds(608, 358, 226, 26);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel(s.getId());
		label_7.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		label_7.setBounds(608, 430, 226, 26);
		panel.add(label_7);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 228, 196));
		setJMenuBar(menuBar);
		
		
		JMenu mnSearchfor = new JMenu("Search for");
		mnSearchfor.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnSearchfor);
		
		JMenuItem mntmOrder = new JMenuItem("Order");
		mntmOrder.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mnSearchfor.add(mntmOrder);
		mntmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
	    	
				new SearchForm(1, s);
	    	}
		});
		
		JMenuItem mntmProduct = new JMenuItem("Product");
		mnSearchfor.add(mntmProduct);
		mntmProduct.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mntmProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    
				new SearchForm(2, s);

		    	}
			});
		          
		
		JMenuItem mntmClient = new JMenuItem("Client");
		mnSearchfor.add(mntmClient);
		mntmClient.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mntmClient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
				new SearchForm(3, s);
		    	}
			});
		
	
		
		JLabel label = new JLabel("          ");
		menuBar.add(label);
		
		JMenu mnMyProducts = new JMenu("My Products");
		mnMyProducts.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnMyProducts);
		
		JMenuItem mntmAddAProduct = new JMenuItem("Add a Product");
		mnMyProducts.add(mntmAddAProduct);
		mntmAddAProduct.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mntmAddAProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	new ProductForm(s);
		    	}
			});

		
		JMenuItem mntmShowProducts = new JMenuItem("Show Products");
		mnMyProducts.add(mntmShowProducts);
		mntmShowProducts.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mntmShowProducts.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	ArrayList<Object> temp = new ArrayList<>(s.getProducts().getCompanyProducts());
		    	new PresentationForm(s, temp);
		    	
		    	}
			});
		
		
		
		
		JLabel label_1 = new JLabel("          ");
		menuBar.add(label_1);
		
		JMenu mnMyOrders = new JMenu("My Orders");
		mnMyOrders.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnMyOrders);
		
		JMenuItem mntmShowOrders = new JMenuItem("Show Orders");
		mntmShowOrders.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mnMyOrders.add(mntmShowOrders);
		mntmShowOrders.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	ArrayList<Object> temp = new ArrayList<>(s.getOrders().getOrders());
		    	new PresentationForm(s, temp);
		    	}
			});
		
		
		
		
		JLabel label_2 = new JLabel("          ");
		menuBar.add(label_2);
		
		JMenu mnMyClients = new JMenu("My Clients");
		mnMyClients.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnMyClients);
		
		JMenuItem mntmAddaClient = new JMenuItem("Add a Client");
		mnMyClients.add(mntmAddaClient);
		mntmAddaClient.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mntmAddaClient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new BuyerForm(s);
		    	}
			});
		
		JMenuItem mntmShowClients = new JMenuItem("Show Clients");
		mnMyClients.add(mntmShowClients);
		mntmShowClients.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mntmAddaClient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    
		    	ArrayList<Object> temp = new ArrayList<>(s.getBuyers().getBuyers());
		    	new PresentationForm(s, temp);
		    	
		    	}
			});
		
		
		
		
		
		JLabel label_3 = new JLabel("          ");
		menuBar.add(label_3);
		
		JMenu mnStatistics = new JMenu("My Statistics");
		mnStatistics.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnStatistics);
		
		JMenuItem mntmSeeStatistics = new JMenuItem("See Statistics");
		mnStatistics.add(mntmSeeStatistics);
		mntmSeeStatistics.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mntmSeeStatistics.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    
		    	ArrayList<Object> temp = new ArrayList<>(s.getBuyers().getBuyers());
		    	new PresentationForm(s, temp);
		    	
		    	new SelectionGui(s);
		    	}
			});
		

		
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setResizable(false);
		this.setBounds(100, 100, 1041, 653);
		this.setTitle("HomePage");
	}
}

