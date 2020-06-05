import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class OrderManagerForm {
	private JFrame frame ;   //frame
	private	JMenuBar ordManagerJMenuBar;
	private	JMenu searchForJMn ;
	private	JMenu myProdJMn;
	private	JMenu myOrdersJMn;
	private	JMenu mySuppliersJMn;
	private	JMenu statisticsJMn;
	private	JMenu forecastJMn;
	private	JMenuItem searchForJMnItm;
	private	JMenuItem productsJMnItm;
	private	JMenuItem suppliersJMnItm ;
	private	JMenuItem addProdJMnItm;
	private	JMenuItem showProdJMnItm ;
	private	JMenuItem addOrderJMnItm;
	private	JMenuItem showOrdJMnItm;
	private	JMenuItem addSupplJMnItm;
	private	JMenuItem showSupplJMnItm;
	private	JLabel spaceLabel2;
	private	JLabel spaceLabel1 ;
	private	JLabel spaceLabel3;
	private	JLabel spaceLabel4;
	private	JLabel spaceLabel5;
	private	JPanel panel;
	private	JLabel firstNameJLbl;
	private	JLabel surNameJLbl;
	private	JLabel telephoneJLbl;
	private	JLabel idJLbl;
	private	JLabel typeOfBusinessJLbl;
	private	JLabel resultFirstNameJLbl;
	private	JLabel resultLastNameJLbl;
	private	JLabel resultTelephoneJLbl;
	private	JLabel resultAfmJLbl;
	private	JLabel resultIdJLbl;
	private	JLabel resultSeasonJLbl;
	private	JLabel afmJLbl;
	private	JButton resultChangeBusinessTypeJLbl;
	private	JButton resultRefreshJLbl;
	
		
	
	public OrderManagerForm(OrderManager ordManager) {
		frame = new JFrame("Order Manager Menu");
		
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ordManagerJMenuBar= new JMenuBar();
		ordManagerJMenuBar.setBackground(new Color(255, 228, 196));
		frame.setJMenuBar(ordManagerJMenuBar);
		
		searchForJMn = new JMenu("Search For");
		searchForJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(searchForJMn);
		
		
		searchForJMnItm = new JMenuItem("Orders");                                 //Searches for an order
		searchForJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		searchForJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(1, ordManager);
			}
		});
		searchForJMn.add(searchForJMnItm);
		
		
		productsJMnItm = new JMenuItem("Products");                               // Searches for a product
		productsJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		productsJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(2, ordManager);
			}
		});
		searchForJMn.add(productsJMnItm);
		
		
		suppliersJMnItm = new JMenuItem("Suppliers");                           //Searches for a supplier 
		suppliersJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		suppliersJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(3, ordManager);
			}
		});
		searchForJMn.add(suppliersJMnItm);
		
		spaceLabel1 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel1);
		
		myProdJMn = new JMenu("My Products");
		myProdJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(myProdJMn);
		
		                                                          
		addProdJMnItm = new JMenuItem("Add a Product");                            //Shows the product form an adds it into the list 
		addProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		addProdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductForm(ordManager);
			}
		});
		myProdJMn.add(addProdJMnItm);
		
		
		showProdJMnItm = new JMenuItem("Show a Product");						//Shows a specific product from presentation form 
		showProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		showProdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getProducts().getSupplierProducts()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		myProdJMn.add(showProdJMnItm);
		
		spaceLabel2 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel2);
		
		myOrdersJMn = new JMenu("My Orders");
		myOrdersJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(myOrdersJMn);
		
		/* Shows the order form an adds it into the list */
		addOrderJMnItm = new JMenuItem("Add an Order");
		addOrderJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20 ));
		addOrderJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderForm(ordManager);
			}
		});
		myOrdersJMn.add(addOrderJMnItm);
		
		
		showOrdJMnItm = new JMenuItem("Show an Order");          //Shows a specific order from presentation form 
		showOrdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		showOrdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getOrders().getOrders()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		myOrdersJMn.add(showOrdJMnItm);
		
		spaceLabel3 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel3);
		
		mySuppliersJMn = new JMenu("My Suppliers ");
		mySuppliersJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(mySuppliersJMn);
		
		
		addSupplJMnItm = new JMenuItem("Add a Supplier");				// Shows the supplier form an adds it into the list 
		addSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		addSupplJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplierForm(ordManager);
			}
		});
		mySuppliersJMn.add(addSupplJMnItm);
		
		
		showSupplJMnItm = new JMenuItem("Show Supplier");             // Shows a specific supplier from presentation form 
		showSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		showSupplJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getSuppliers().getSuppliers()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		mySuppliersJMn.add(showSupplJMnItm);
		
		spaceLabel4 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel4);
		
		
		statisticsJMn = new JMenu("Statistics");                 // Shows the statistics for order manager 
		statisticsJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		statisticsJMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectionGui(ordManager);
			}
		});
		ordManagerJMenuBar.add(statisticsJMn);
		
		spaceLabel5 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel5);
		
		
		forecastJMn = new JMenu("Forecast");              // Shows the results of forecast 
		forecastJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		forecastJMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> listofProposals = new ArrayList<>(ordManager.getProposals().getProposals());
				new PresentationForm(ordManager, listofProposals);
			}
		});
		ordManagerJMenuBar.add(forecastJMn);
		
		panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setVisible(true);
		
		firstNameJLbl = new JLabel("First Name :");
		firstNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		firstNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameJLbl.setBounds(125, 59, 151, 21);
		panel.add(firstNameJLbl);
		
		surNameJLbl = new JLabel("Surname :");
		surNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		surNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		surNameJLbl.setBounds(125, 116, 151, 21);
		panel.add(surNameJLbl);
		
		telephoneJLbl = new JLabel("Telephone :");
		telephoneJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		telephoneJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		telephoneJLbl.setBounds(125, 167, 151, 21);
		panel.add(telephoneJLbl);
		
		afmJLbl = new JLabel("AFM : ");
		afmJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		afmJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		afmJLbl.setBounds(125, 229, 151, 21);
		panel.add(afmJLbl);
		
		idJLbl = new JLabel("ID : ");
		idJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		idJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		idJLbl.setBounds(125, 311, 151, 21);
		panel.add(idJLbl);
		
		typeOfBusinessJLbl = new JLabel("Type of Business : ");
		typeOfBusinessJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		typeOfBusinessJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		typeOfBusinessJLbl.setBounds(125, 372, 227, 21);
		panel.add(typeOfBusinessJLbl);
		
		resultFirstNameJLbl = new JLabel(ordManager.getFirstName());
		resultFirstNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultFirstNameJLbl.setBounds(524, 67, 123, 21);
		panel.add(resultFirstNameJLbl);
		
		resultLastNameJLbl = new JLabel(ordManager.getSurName());
		resultLastNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultLastNameJLbl.setBounds(524, 116, 123, 21);
		panel.add(resultLastNameJLbl);
		
		resultTelephoneJLbl = new JLabel(ordManager.getTelephone());
		resultTelephoneJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultTelephoneJLbl.setBounds(524, 175, 123, 21);
		panel.add(resultTelephoneJLbl);
		
		resultAfmJLbl = new JLabel(ordManager.getAFM());
		resultAfmJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultAfmJLbl.setBounds(524, 236, 123, 21);
		panel.add(resultAfmJLbl);
		
		resultIdJLbl = new JLabel(ordManager.getId());
		resultIdJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultIdJLbl.setBounds(524, 312, 123, 21);
		panel.add(resultIdJLbl);
		
		resultSeasonJLbl = new JLabel(ordManager.getSeason());
		resultSeasonJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultSeasonJLbl.setBounds(525, 369, 122, 21);
		panel.add(resultSeasonJLbl);
		
		                                                                                               
		resultChangeBusinessTypeJLbl = new JButton("Change Type of Business");                        // Changes the type of business 
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
						ordManager.setSeason("Regular");
						resultSeasonJLbl.setText(ordManager.getSeason());
						if (resultSeasonJLbl.getText() == "Regular") 
						JOptionPane.showMessageDialog(frame, " The Type Of Business Has Changed To : Regular ", " Update ", JOptionPane.INFORMATION_MESSAGE);
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
								ordManager.setSeason("Autumn - Winter");
								resultSeasonJLbl.setText(ordManager.getSeason());
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
								ordManager.setSeason("Spring - Summer");
								resultSeasonJLbl.setText(ordManager.getSeason());
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
		
		                                                                     
		resultRefreshJLbl = new JButton("Refresh");                     // Refreshes all the changes that has been made in the array lists to the database 
		resultRefreshJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 11));
		resultRefreshJLbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordManager.refresh();
			}
		});
		resultRefreshJLbl.setBounds(818, 473, 89, 38);
		panel.add(resultRefreshJLbl);
		panel.setVisible(true);
		frame.setVisible(true);
	}
}