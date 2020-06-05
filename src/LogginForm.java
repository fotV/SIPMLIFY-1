 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**LogginForm.java
 * Purpose : Displays the GUI of a loggin form for users.
 * @author Vlasakoudi Christina
 */
public class LogginForm extends JFrame{
    private JPanel panel ;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JPasswordField passwordField;
    private JButton btnNewButton; 
    private boolean errorFlag;//false if there is no error else true
	private User user;
    public LogginForm() {
    	this.user = new User();
        panel = new JPanel();
    	lblNewLabel = new JLabel(" Username :");           //Username label
    	lblNewLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
    	lblNewLabel.setBounds(166, 387, 145, 40);
    	panel.add(lblNewLabel);
    	
    	lblNewLabel_1 = new JLabel("Password :");          //password label
    	lblNewLabel_1.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
    	lblNewLabel_1.setBounds(175, 453, 150, 46);
    	panel.add(lblNewLabel_1);
    	
    	textField = new JTextField();          //name textfield
    	textField.setBounds(367, 401, 219, 19);
    	panel.add(textField);
    	textField.setColumns(10);
    		
    	btnNewButton = new JButton("Log In");          //button loggin
    	btnNewButton.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
    	btnNewButton.setBounds(420, 547, 109, 40);
    	panel.add(btnNewButton);
    		
    	JLabel lblNewLabel_2 = new JLabel("");                 //photo
    	//lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\\u03A7\u03C1\u03B9\u03C3\u03C4\u03B9\u03BD\u03B1\\Desktop\\22.png"));
    	lblNewLabel_2.setBounds(182, 36, 535, 316);
    	panel.add(lblNewLabel_2);
    		
    	passwordField = new JPasswordField();           //password textfield
    	passwordField.setBounds(367, 470, 219, 19);
    	panel.add(passwordField);
    		
    		
    	panel.setBackground(new Color(136,177,179));
    	this.getContentPane().add(panel, BorderLayout.CENTER);
    	panel.setLayout(null);
    		
    	btnNewButton.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e) {
    				
                String Userid = textField.getText();
    			System.out.print(Userid);
    			char[] password = passwordField.getPassword()	;
    			String Userspassword = new String(password);
    			System.out.print(Userspassword);
    			errorFlag = checkError(Userid,Userspassword);
    				
    			
    			if( errorFlag ){
    				System.out.println(user.getFirstName());
    				if (Userid.startsWith("OR")) {
     				    OrderManager or = (OrderManager) user;
     				    or.initializeLists();
    					new OrderManagerForm(or) ;	  
    				}else if(Userid.startsWith("SE")) {
    					Seller se = (Seller) user; 
    					new SellerForm(se);
    				}else if(Userid.contains("ST")) {
    					Stockkeeper st = (Stockkeeper) user;
    					new StockkeeperForm(st);
    				}
    			}
    	}});
    	this.setTitle("Login");
    	this.setVisible(true);
    	this.setBounds(100, 100, 811, 677);
    	//this.dispose();
    				
    	}
    			
    	private boolean checkError(String Userid,String userspassword ) {
    		
    		errorFlag = false;
			Users users = new Users();
			users.extractObjectDB();
			for(User u : users.getUsers()){
				
				if (u.getId().equals(Userid)){
					 	
					 if (userspassword.length() < 8) 
						 JOptionPane.showMessageDialog(panel, "Password length should be between 8 characters"); 
					else{
						if (userspassword.equals(u.getPassword())) {
							user = u;
							return errorFlag = true ;
						}else if( !(userspassword.contains("!") || userspassword.contains(".") || userspassword.contains(",") || userspassword.contains("*"))){
						  JOptionPane.showMessageDialog(panel, "Password should contain at least one special character ");
					     
					    }else if (! userspassword.matches(".*[0-9].*")){
						   JOptionPane.showMessageDialog(panel, "Password should at least contain one digit");
						   
			            }else{ 
					            int count1 = 0; 
					            for (int i = 65; i <= 90; i++) {               // checking capital letters 
					  
					                char c = (char)i;                         // type casting 
					                String str1 = Character.toString(c); 
					                if ( u.getPassword().contains(str1))
					                    count1 = 1;
					            } 
					            
					            int count2 = 0; 
					            for (int i = 90; i <= 122; i++) {              // checking small letters 
					  
					                char c = (char)i;                          // type casting 
					                String str1 = Character.toString(c); 
					                if ( u.getPassword().contains(str1)) { 
					                    count2 = 1; 
					                } 
					            } 
					            if (count2 == 0 || count1 ==0) { 
					            	 System.out.println("Password should contain at least one lowercase letter(a-z) and uppercase letter(A-Z)");  
					            	
					            } 
			           	}
					}
				}
			}
			if (errorFlag == false) {
				JOptionPane.showMessageDialog(this, "Invalid username", "Loggin", JOptionPane.DEFAULT_OPTION);
			}
    		return errorFlag;
    }
    	
   	
}    
    		
    	
    
    				
    				
    				
    				
    					
    				
    				
                   
                   
                   
                   
        
    		

		
    
              
   
    
		
               
					
					
					
						
		
			

						
					
						
				
				
				
			
			
			
			
			
			
		
    
		
		



