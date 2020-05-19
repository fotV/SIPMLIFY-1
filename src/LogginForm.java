package src;

<<<<<<< HEAD

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
    import javax.swing.*;

    public class LogginForm{
    	private ArrayList<Users> userList;
    	private JFrame frame;
    	private JTextField textField;
    	private JPasswordField passwordField;

    	/**
    	 * Launch the application.
    	 */
    	public static void main(String[] args) {
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					LogginForm window = new LogginForm();
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
    	public LogginForm() {
    		initialize();
    	}

    	/**
    	 * Initialize the contents of the frame.
    	 */
    	private void initialize() {
    		frame = new JFrame();
    		frame.setTitle("Login");
    		frame.setBounds(100, 100, 811, 677);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
    		JPanel panel = new JPanel();
    		panel.setBackground(Color.WHITE);
    		frame.getContentPane().add(panel, BorderLayout.CENTER);
    		panel.setLayout(null);
    		
    		JLabel lblNewLabel = new JLabel("    Username :");
    		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
    		lblNewLabel.setBounds(175, 347, 145, 40);
    		panel.add(lblNewLabel);
    		
    		JLabel lblNewLabel_1 = new JLabel("Password :");
    		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
    		lblNewLabel_1.setBounds(196, 402, 98, 46);
    		panel.add(lblNewLabel_1);
    		
    		textField = new JTextField();
    		textField.setBounds(367, 360, 219, 19);
    		panel.add(textField);
    		textField.setColumns(10);
    		
    		JButton btnNewButton = new JButton("Log In");
    		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
    		btnNewButton.setBounds(419, 503, 98, 29);
    		panel.add(btnNewButton);
    		
    		JLabel lblNewLabel_2 = new JLabel("");
    		lblNewLabel_2.setIcon(new ImageIcon(LogginForm.class.getResource("/image/OrganizedOrders2.jpg")));
    		lblNewLabel_2.setBounds(265, 10, 491, 299);
    		panel.add(lblNewLabel_2);
    		
    		passwordField = new JPasswordField();
    		passwordField.setBounds(367, 418, 219, 19);
    		panel.add(passwordField);
    	}
		class ButtonListener implements ActionListener{
			
		
               public void actionPerformed(ActionEvent e) {
				
				String Usersusername = textField.getText();
				String Userspassword=passwordField.getText();
				
				User selectedUsers = null;
				
				
				for(Users u : userList)
				{
					if (User.getPassword().equals(Usersusername))
					{
						selectedUsers = u;}
					
					
				}
					if(selectedUsers != null)	
				{
					
				    if(User.getPassword().equals(Userspassword))
				    {
				    	OrderManagerForm ord= new OrderManagerForm() ;
				    	
					}
					else if(Users.getPassword().equals(Userspassword))
						{
							
							SellerForm sel= new SellerForm();
							
							
						}
						else if (Users.getPassword().equals(Userspassword))
						 {
							
							StockkeeperForm st= new StockkeeperForm();
							
							
						 }
			
				}
				else
			    {System.out.println("There is no user with this username"
			    		+ "Try Again");}
				}
		}
               
               
               }
				
		
=======
>>>>>>> f6348febcdb2ec0db992e3097f5719282fbddbc3
		
    
              
   
    
		
               
					
					
					
						
		
			
	
						
					
						
				
				
				
			
			
			
			
			
			
		
    
		
		


	


