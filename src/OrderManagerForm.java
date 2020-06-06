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
		searchForJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		searchForJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(1, ordManager);
			}
		});
		searchForJMn.add(searchForJMnItm);
		
		/* Searches for a product */
		JMenuItem productsJMnItm = new JMenuItem("Products");
		productsJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		productsJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(2, ordManager);
			}
		});
		searchForJMn.add(productsJMnItm);
		
		/* Searches for a supplier */
		JMenuItem suppliersJMnItm = new JMenuItem("Suppliers");
		suppliersJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
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
		addProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		addProdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductForm(ordManager).addAProduct();
			}
		});
		myProdJMn.add(addProdJMnItm);
		
		/* Shows a specific product from presentation form */
		JMenuItem showProdJMnItm = new JMenuItem("Show a Product");
		showProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
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
		addOrderJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		addOrderJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderForm(ordManager);
			}
		});
		myOrdersJMn.add(addOrderJMnItm);
		
		/* Shows a specific order from presentation form */
		JMenuItem showOrdJMnItm = new JMenuItem("Show an Order");
		showOrdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
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
		addSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		addSupplJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplierForm();
			}
		});
		mySuppliersJMn.add(addSupplJMnItm);
		
		/* Shows a specific supplier from presentation form */
		JMenuItem showSupplJMnItm = new JMenuItem("Show Supplier");
		showSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
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
		*************************************************************************************
		JMenu forecastJMn = new JMenu("Forecast");
		forecastJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(forecastJMn);
		
		JMenuItem showProposalsJMnItm = new JMenuItem("Show Proposals");
		showProposalsJMnItm.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		showProposalsJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> listofProposals = new ArrayList<>(ordManager.getProposals().getProposals());
				new TryPresentationForm(ordManager, listofProposals);
			}
		});
		ordManagerJMenuBar.add(showProposalsJMnItm);
		
		JMenuItem calculateJMnItm = new JMenuItem("Calculate");
		calculateJMnItm.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		calculateJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> listofProposals = new ArrayList<>(ordManager.getProposals().getProposals());
				new TryPresentationForm(ordManager, listofProposals);
			}
		});
		ordManagerJMenuBar.add(calculateJMnItm);   
		*************************************************************************************
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel firstNameJLbl = new JLabel("First Name :");
		firstNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		firstNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameJLbl.setBounds(225, 99, 159, 32);   *******
		panel.add(firstNameJLbl);
		
		JLabel surNameJLbl = new JLabel("Surname :");
		surNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		surNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		surNameJLbl.setBounds(225, 192, 159, 32);  ********
		panel.add(surNameJLbl);
		
		JLabel telephoneJLbl = new JLabel("Telephone :");
		telephoneJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		telephoneJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		telephoneJLbl.setBounds(225, 272, 159, 32);  ******
		panel.add(telephoneJLbl);
		
		JLabel afmJLbl = new JLabel("AFM : ");
		afmJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		afmJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		afmJLbl.setBounds(225, 355, 159, 32);  ******
		panel.add(afmJLbl);
		
		JLabel idJLbl = new JLabel("ID : ");
		idJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		idJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		idJLbl.setBounds(225, 427, 159, 32);  ******
		panel.add(idJLbl);
		
		JLabel typeOfBusinessJLbl = new JLabel("Type of Business : ");
		typeOfBusinessJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		typeOfBusinessJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		typeOfBusinessJLbl.setBounds(225, 550, 159, 32);  ******
		panel.add(typeOfBusinessJLbl);
		
		****************************************************************************************
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
	
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(30, 520, 981, 2);
		panel.add(separator_4);
		
		****************************************************************************************
		
		JLabel resultFirstNameJLbl = new JLabel(ordManager.getFirstName());
		resultFirstNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultFirstNameJLbl.setBounds(608, 102, 226, 26);    *****
		panel.add(resultFirstNameJLbl);
		
		JLabel resultLastNameJLbl = new JLabel(ordManager.getLastName());
		resultLastNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultLastNameJLbl.setBounds(608, 195, 226, 26);   ******
		panel.add(resultLastNameJLbl);
		
		JLabel resultTelephoneJLbl = new JLabel(ordManager.getTelephone());
		resultTelephoneJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultTelephoneJLbl.setBounds(608, 275, 226, 26);    *******
		panel.add(resultTelephoneJLbl);
		
		JLabel resultAfmJLbl = new JLabel(ordManager.getAfm());
		resultAfmJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultAfmJLbl.setBounds(608, 358, 226, 26);   ******
		panel.add(resultAfmJLbl);
		
		JLabel resultIdJLbl = new JLabel(ordManager.getId());
		resultIdJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultIdJLbl.setBounds(608, 430, 226, 26);   ******
		panel.add(resultIdJLbl);
		
		JLabel resultSeasonJLbl = new JLabel(ordManager.getSeason());
		resultSeasonJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultSeasonJLbl.setBounds(608, 560, 226, 26);  *******
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
				frame.getContentPane().add(panel, BorderLayout.CENTER); ************
   				
				JLabel label = new JLabel(" Do you want to change your business type? "); 
				*************************************************
				label.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 25));  ***25***
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(73, 72, 265, 14);  
				**************************************************
				panel.add(label); 
				
				*******************************
				JSeparator separator = new JSeparator();
				separator.setBounds(61, 109, 288, 14);
				panel.add(separator);
				*******************************
				
				JButton regularJBtn = new JButton("Regular");
				regularJBtn.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
				regularJBtn.setBounds(92, 139, 89, 37);  *************
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
				seasonalJBtn.setBounds(227, 139, 89, 37);  ***************
				seasonalJBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame();
						frame.setTitle("Seasons Choose");
						frame.setSize(400, 400);
						frame.setVisible(true);
						frame.setResizable(false);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						JPanel panel2 = new JPanel();
						frame.getContentPane().add(panel2, BorderLayout.CENTER); *************
						
						JLabel label = new JLabel(" Choose Seasons : ");
						*********************************************
						label.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 25)); ****25****
						label.setHorizontalAlignment(SwingConstants.CENTER);
						label.setBounds(73, 72, 265, 14);	
						*********************************************
						panel2.add(label);
						
						********************************************
						JSeparator separator = new JSeparator();
						separator.setBounds(61, 109, 288, 14);
						panel.add(separator);
						********************************************
						
						JButton autmnWinter = new JButton("Autumn - Winter");
						autmnWinter.setFont(new Font("HelveticaNeue", Font.BOLD, 20));  ***20***
						autmnWinter.setBounds(92, 139, 89, 37);   *********************
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
						springSummer.setFont(new Font("HelveticaNeue", Font.BOLD, 20));  ****20***
						springSummer.setBounds(227, 139, 89, 37);   *****************
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
		resultChangeBusinessTypeJLbl.setBounds(125, 473, 189, 38);   *********************
		panel.add(resultChangeBusinessTypeJLbl);
		
		/* Refreshes all the changes that has been made in the array lists to the database */
		///alakse kai to onoma apo resultRfreshJLbl se resultRefreshJBtn/////
		JButton resultRefreshJBtn = new JButton("Refresh");
		resultRefreshJBtn.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		resultRefreshJBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordManager.refresh();
			}
		});
		resultRefreshJBtn.setBounds(818, 473, 89, 38);    ******************
		panel.add(resultRefreshJBtn);
	}
}
