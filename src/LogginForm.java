

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
    import javax.swing.*;

    public class LogginForm{
    	private ArrayList<User> userList;
    	private JFrame frame;
    	private JTextField textField;
    	private JPasswordField passwordField;
    	private JButton btnNewButton; 

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
    		
    		JLabel lblNewLabel = new JLabel(" Username :");
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
				
				String Userid = textField.getText();
				
				String Userspassword=passwordField.getText();
				
				User selectedUser = null;
				
				
				for(User u : userList)
				{
					if (u.getId().equals(Userid))
					{
						 selectedUser = u;
						 if (((u.getPassword().length() >= 4) && (u.getPassword().length() <= 8))) {
							 System.out.println("Password length should be"
					                    + " between 4 to 8 characters"); 
						 }
						 else if(u.getPassword().contains(" ")) {
							 System.out.println("Password should not"
					                    + " contain any space"); 
					      }
						 else if (true) { 
					            int count = 0; 
					            
					            // check digits from 0 to 9 
					            for (int i = 0; i <= 9; i++) { 
					  
					                // to convert int to string 
					                String str1 = Integer.toString(i); 
					  
					                if (u.getPassword().contains(str1)) { 
					                    count = 1; 
					                } 
					            } 
					            if (count == 0) { 
					            	System.out.println("Password should contain at"
                               + " least one uppercase letter(A-Z)");   
					            }
						 }
					    else if (!(u.getPassword().contains("@") || u.getPassword().contains("#") 
					      || u.getPassword().contains("!") || u.getPassword().contains("~") 
					      ||u.getPassword().contains("$") || u.getPassword().contains("%") 
					      || u.getPassword().contains("^") || u.getPassword().contains("&") 
					     || u.getPassword().contains("*") || u.getPassword().contains("(") 
					      || u.getPassword().contains(")") || u.getPassword().contains("-") 
					      || u.getPassword().contains("+") || u.getPassword().contains("/") 
					       || u.getPassword().contains(":") || u.getPassword().contains(".") 
					       || u.getPassword().contains(", ") || u.getPassword().contains("<") 
					              || u.getPassword().contains(">") || u.getPassword().contains("?") 
					              || u.getPassword().contains("|"))) 
					            {
					    	 System.out.println("Password should contain"
					                    + " at least one digit(0-9)");
			                   } 
					    else if (true) { 
					            int count = 0; 
					            
					            // checking capital letters 
					            for (int i = 65; i <= 90; i++) { 
					  
					                // type casting 
					                char c = (char)i; 
					  
					                String str1 = Character.toString(c); 
					                if ( u.getPassword().contains(str1)) { 
					                    count = 1; 
					                } 
					            } 
					            if (count == 0) { 
					            	System.out.println("Password should contain at"
					                        + " least one uppercase letter(A-Z)"); 
					            } 
					            }
					    else if(true) { 
					            int count = 0; 
					            
					            // checking small letters 
					            for (int i = 90; i <= 122; i++) { 
					  
					                // type casting 
					                char c = (char)i; 
					                String str1 = Character.toString(c); 
					  
					                if ( u.getPassword().contains(str1)) { 
					                    count = 1; 
					                } 
					            } 
					            if (count == 0) { 
					            	 System.out.println("Password should contain at"
					                        + " least one lowercase letter(a-z)");  
					            } 
					        }
					    else
					    {System.out.println("The password is valid!");}
					    	
					    if (u.getId().contains("OR")) {
					    	
					    OrderManagerForm ord= new OrderManagerForm() ;	
					    }
					    else if(u.getId().contains("SE")) {
					    	SellerForm sel= new SellerForm();
					    }
					    else if(u.getId().contains("ST")) {
					    	StockkeeperForm st= new StockkeeperForm();
					    }
					         
					    }
			        break;
					}
				
				
				
				
					
				
				
               
               
               }
               }
		
    }
    
				
		
		
    
              
   
    
		
               
					
					
					
						
		
			
	
						
					
						
				
				
				
			
			
			
			
			
			
		
    
		
		


	


