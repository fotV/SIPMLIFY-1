 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;




    public class LogginForm extends JFrame{
    	/*LogginForm.java
    	 * Purpose : Displays the GUI of a loggin form for users.
    	 * @author Vlasakoudi Christina
    	 */
    	private JPanel panel ;
    	private JTextField textField;
    	private JPasswordField passwordField;
    	private JButton btnNewButton; 
    	private boolean errorFlag;//false if there is no error else true
		private User user;

    	
    	public LogginForm(ArrayList<User> userList) {
    		
    		this.user=user;
    		
    	}	
    	
    	
    	public void Loggin() {
    		
    		/* Creates GUI for login,if there is no error in filled form*/
    		
    		//creation of gui
    		
           panel = new JPanel();
    	
    		//Username label
           
    		JLabel lblNewLabel = new JLabel(" Username :");
    		lblNewLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
    		lblNewLabel.setBounds(166, 387, 145, 40);
    		panel.add(lblNewLabel);
    		//password label
    		JLabel lblNewLabel_1 = new JLabel("Password :");
    		lblNewLabel_1.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
    		lblNewLabel_1.setBounds(175, 453, 150, 46);
    		panel.add(lblNewLabel_1);
    		//name textfield
    		textField = new JTextField();
    		textField.setBounds(367, 401, 219, 19);
    		panel.add(textField);
    		textField.setColumns(10);
    		//button loggin
    		JButton btnNewButton = new JButton("Log In");
    		btnNewButton.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
    		btnNewButton.setBounds(420, 547, 109, 40);
    		panel.add(btnNewButton);
    		
    		//photo 
    		
    		JLabel lblNewLabel_2 = new JLabel("");
    		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\\u03A7\u03C1\u03B9\u03C3\u03C4\u03B9\u03BD\u03B1\\Desktop\\22.png"));
    		lblNewLabel_2.setBounds(182, 36, 535, 316);
    		panel.add(lblNewLabel_2);
    		
    		//password textfield
    		
    		passwordField = new JPasswordField();
    		passwordField.setBounds(367, 470, 219, 19);
    		panel.add(passwordField);
    		
    		
    		panel.setBackground(new Color(136,177,179));
    		this.getContentPane().add(panel, BorderLayout.CENTER);
    		panel.setLayout(null);
    		
    		btnNewButton.addActionListener(new ActionListener() 
    	{
    			public void actionPerformed(ActionEvent e) {
    				
                  String Userid = textField.getText();
    				
    				String Userspassword=passwordField.getText();	
    				errorFlag = checkError(Userid,Userspassword);
    				
    				//if errorFlag = false there is no error
    				if(!errorFlag)
    				{
    					if (Userid.contains("OR")) {
     				    	
    					    OrderManagerForm ord= new OrderManagerForm(user) ;	
    					    }
    					    else if(Userid.contains("SE")) {
    					    	SellerForm sel= new SellerForm();
    					    }
    					    else if(Userid.contains("ST")) {
    					    	StockkeeperForm st= new StockkeeperForm();
    					   }
    					
    				}
    				
    	}

    				
    			
    			});
    		this.setTitle("Login");
    		this.setVisible(true);
    		this.setBounds(100, 100, 811, 677);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				
    	}
    			
    	private boolean checkError(String Userid,String UsersPassword ) {
    		
    		errorFlag = false;
    		
    		User selectedUser = null;
			
			
			for(User u : userList)
			{
				if (u.getId().equals(Userid))
				{
					 selectedUser = u;
					 if (((u.getPassword().length() >= 4) && (u.getPassword().length() <= 8))) {
						 System.out.println("Password length should be"
				                    + " between 4 to 8 characters"); 
						 return errorFlag=true;
					 }
					 else if(u.getPassword().contains(" ")) {
						 System.out.println("Password should not"
				                    + " contain any space"); 
						 return errorFlag=true;
				      }
					 else if (true) { 
				            int count = 0; 
				            
				            // check digits from 0 to 9 
				            for (int i = 0; i <= 9; i++) { 
				  
				                // to convert int to string 
				                String str1 = Integer.toString(i); 
				  
				                if (u.getPassword().contains(str1)) { 
				                    count = 1; 
				                    return errorFlag=true;
				                } 
				            } 
				            if (count == 0) { 
				            	System.out.println("Password should contain at"
                           + " least one uppercase letter(A-Z)");   
				            	 return errorFlag=true;
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
				    	 return errorFlag=true;
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
				            	 return errorFlag=true;
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
				            	 return errorFlag=true;
				            } 
				        }
				    else
				    {System.out.println("The password is valid!");
				    return errorFlag=false;}
				    	
				   
				         
				    }
		        break;
				}
				
			
    		
    		
    		
    	
    	
    	
    			
    	}
    		
    		
    	
    	
    	
    	
    	
    }
    	
    
    		
    	
    
    		
    	
    
    				
    				
    				
    				
    					
    				
    				
                   
                   
                   
                   
        
    		

		
    
              
   
    
		
               
					
					
					
						
		
			

						
					
						
				
				
				
			
			
			
			
			
			
		
    
		
		



