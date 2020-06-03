import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class OrderManagerForm {
private JFrame frame ;   //frame
	private JPanel panel;  //panel
	
	
	public OrderManagerForm(OrderManager ordManager) {
		
		frame = new JFrame("Order Manager Menu");
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar ordManagerJMenuBar= new JMenuBar();
		ordManagerJMenuBar.setBackground(new Color(255, 228, 196));
		frame.setJMenuBar(ordManagerJMenuBar);
		
		JMenu searchForJMn = new JMenu("Search For");
		searchForJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(searchForJMn);
		
		/* Searches for an order*/
		JMenuItem searchForJMnItm = new JMenuItem("Orders");
		searchForJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		searchForJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(1, ordManager);
			}
		});
		searchForJMn.add(searchForJMnItm);
		
		/* Searches for a product */
		JMenuItem productsJMnItm = new JMenuItem("Products");
		productsJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		productsJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(2, ordManager);
			}
		});
		searchForJMn.add(productsJMnItm);
		
		/* Searches for a supplier */
		JMenuItem suppliersJMnItm = new JMenuItem("Suppliers");
		suppliersJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		suppliersJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(3, ordManager);
			}
		});
		searchForJMn.add(suppliersJMnItm);
		
		JLabel spaceLabel1 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel1);
		
		JMenu myProdJMn = new JMenu("My Products");
		myProdJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(myProdJMn);
		
		/* Shows the product form an adds it into the list */
		JMenuItem addProdJMnItm = new JMenuItem("Add a Product");
		addProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		addProdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductForm(ordManager).addAProduct();
			}
		});
		myProdJMn.add(addProdJMnItm);
		
		/* Shows a specific product from presentation form */
		JMenuItem showProdJMnItm = new JMenuItem("Show a Product");
		showProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		showProdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getProducts().getSupplierProducts()); 			
				new PresentationForm( temp);
			}
		});
		myProdJMn.add(showProdJMnItm);
		
		JLabel spaceLabel2 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel2);
		
		JMenu myOrdersJMn = new JMenu("My Orders");
		myOrdersJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(myOrdersJMn);
		
		/* Shows the order form an adds it into the list */
		JMenuItem addOrderJMnItm = new JMenuItem("Add an Order");
		addOrderJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		addOrderJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderForm(ordManager);
			}
		});
		myOrdersJMn.add(addOrderJMnItm);
		
		/* Shows a specific order from presentation form */
		JMenuItem showOrdJMnItm = new JMenuItem("Show an Order");
		showOrdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		showOrdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getOrders().getOrders()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		myOrdersJMn.add(showOrdJMnItm);
		
		JLabel spaceLabel3 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel3);
		
		JMenu mySuppliersJMn = new JMenu("My Suppliers ");
		mySuppliersJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(mySuppliersJMn);
		
		/* Shows the supplier form an adds it into the list */
		JMenuItem addSupplJMnItm = new JMenuItem("Add a Supplier");
		addSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		addSupplJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplierForm();
			}
		});
		mySuppliersJMn.add(addSupplJMnItm);
		
		/* Shows a specific supplier from presentation form */
		JMenuItem showSupplJMnItm = new JMenuItem("Show Supplier");
		showSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		showSupplJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getSuppliers().getSuppliers()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		mySuppliersJMn.add(showSupplJMnItm);
		
		JLabel spaceLabel4 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel4);
		
		/* Shows the statistics for order manager */
		JMenu statisticsJMn = new JMenu("Statistics");
		statisticsJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		statisticsJMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectionGui();
			}
		});
		ordManagerJMenuBar.add(statisticsJMn);
		
		JLabel spaceLabel5 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel5);
		
		/* Shows the results of forecast */
		JMenu forecastJMn = new JMenu("Forecast");
		forecastJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		forecastJMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> ordManObject = new ArrayList<Object>();
				JFrame frame = new JFrame();
				frame.setTitle("Forecast");
				frame.setSize(400, 400);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(136, 177, 179));
				
				JLabel label = new JLabel(" Forecast Result : ");
				panel.add(label);
				
				JTable table = new JTable();
				if (ordManager.getId().equals(resultIdJLbl)) {
					ordManObject.add(ordManager.getProposals().getProposals());
					for (Object ob : ordManObject) {
						table.setModel(new DefaultTableModel(ob));
					}
				}
				table.setBounds(30,40,200,300);
				panel.add(table);
			}
		});
		ordManagerJMenuBar.add(forecastJMn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel firstNameJLbl = new JLabel("First Name :");
		firstNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		firstNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameJLbl.setBounds(125, 59, 151, 21);
		panel.add(firstNameJLbl);
		
		JLabel surNameJLbl = new JLabel("Surname :");
		surNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		surNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		surNameJLbl.setBounds(125, 116, 151, 21);
		panel.add(surNameJLbl);
		
		JLabel telephoneJLbl = new JLabel("Telephone :");
		telephoneJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		telephoneJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		telephoneJLbl.setBounds(125, 167, 151, 21);
		panel.add(telephoneJLbl);
		
		JLabel afmJLbl = new JLabel("AFM : ");
		afmJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		afmJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		afmJLbl.setBounds(125, 229, 151, 21);
		panel.add(afmJLbl);
		
		JLabel idJLbl = new JLabel("ID : ");
		idJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		idJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		idJLbl.setBounds(125, 311, 151, 21);
		panel.add(idJLbl);
		
		JLabel typeOfBusinessJLbl = new JLabel("Type of Business : ");
		typeOfBusinessJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		typeOfBusinessJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		typeOfBusinessJLbl.setBounds(125, 372, 227, 21);
		panel.add(typeOfBusinessJLbl);
		
		JLabel resultFirstNameJLbl = new JLabel(ordManager.getFirstName());
		resultFirstNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultFirstNameJLbl.setBounds(524, 67, 123, 21);
		panel.add(resultFirstNameJLbl);
		
		JLabel resultLastNameJLbl = new JLabel(ordManager.getLastName());
		resultLastNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultLastNameJLbl.setBounds(524, 116, 123, 21);
		panel.add(resultLastNameJLbl);
		
		JLabel resultTelephoneJLbl = new JLabel(ordManager.getTelephone());
		resultTelephoneJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultTelephoneJLbl.setBounds(524, 175, 123, 21);
		panel.add(resultTelephoneJLbl);
		
		JLabel resultAfmJLbl = new JLabel(ordManager.getAfm());
		resultAfmJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultAfmJLbl.setBounds(524, 236, 123, 21);
		panel.add(resultAfmJLbl);
		
		JLabel resultIdJLbl = new JLabel(ordManager.getId());
		resultIdJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultIdJLbl.setBounds(524, 312, 123, 21);
		panel.add(resultIdJLbl);
		
		JLabel resultSeasonJLbl = new JLabel(ordManager.getSeason());
		resultSeasonJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultSeasonJLbl.setBounds(525, 369, 122, 21);
		panel.add(resultSeasonJLbl);
		
		/* Changes the type of business */
		JButton resultChangeBusinessTypeJLbl = new JButton("Change Type of Business");
		resultChangeBusinessTypeJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		resultChangeBusinessTypeJLbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setTitle("Change The Type of Your Business");
				frame.setSize(500, 500);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.activeCaption);
				
				JLabel label = new JLabel(" Do you want to change your business type? ");
				panel.add(label);
				
				JButton regularJBtn = new JButton("Regular");
				regularJBtn.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
				regularJBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						resultSeasonJLbl.setText(ordManager.setSeason("Regular"));
						if (resultSeasonJLbl.getText() == "Regular") {
							JOptionPane.showMessageDialog(frame, " The Type Of Business Has Changed To : Regular ", " Update ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				panel.add(regularJBtn);
				
				JButton seasonalJBtn = new JButton("Seasonal");
				seasonalJBtn.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
				seasonalJBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame();
						frame.setTitle("Seasons Choose");
						frame.setSize(400, 400);
						frame.setVisible(true);
						frame.setResizable(false);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						JPanel panel2 = new JPanel();
						panel2.setBackground(SystemColor.activeCaption);
						
						JLabel label = new JLabel(" Choose Seasons : ");
						panel2.add(label);
						
						JButton autmnWinter = new JButton("Autumn - Winter");
						autmnWinter.setFont(new Font("HelveticaNeue", Font.BOLD, 11));
						autmnWinter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								resultSeasonJLbl.setText(ordManager.setSeason("Autumn - Winter"));
								if (resultSeasonJLbl.getText() == "Autumn - Winter") {
									JOptionPane.showMessageDialog(frame, " The Type Of Business Has Changed To : Autumn - Winter", " Update ", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});
						panel2.add(autmnWinter);
						
						JButton springSummer = new JButton("Spring - Summer");
						springSummer.setFont(new Font("HelveticaNeue", Font.BOLD, 11));
						springSummer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								resultSeasonJLbl.setText(ordManager.setSeason("Spring - Summer"));
								if (resultSeasonJLbl.getText() == "Spring - Summer") {
									JOptionPane.showMessageDialog(frame, " The Type Of Business Has Changed To : Spring - Summer", " Update ", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});
						panel2.add(springSummer);
						
						frame.getContentPane().add(panel2);
					}
				});
				panel.add(seasonalJBtn);
				
				frame.getContentPane().add(panel);
			}
		});
		resultChangeBusinessTypeJLbl.setBounds(125, 473, 189, 38);
		panel.add(resultChangeBusinessTypeJLbl);
		
		/* Refreshes all the changes that has been made in the array lists to the database */
		JButton resultRefreshJLbl = new JButton("Refresh");
		resultRefreshJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 11));
		resultRefreshJLbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordManager.refresh();
			}
		});
		resultRefreshJLbl.setBounds(818, 473, 89, 38);
		panel.add(resultRefreshJLbl);
	}
}
