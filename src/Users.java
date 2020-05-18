import java.sql.*;
import java.util.ArrayList;

public class Users extends ListFromDB {
	private ArrayList<User> users = new ArrayList<User>();
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;      //statement for Users
		Statement statement = null;		//statement for users that have type OrderManager
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			stmt = c.createStatement();
			statement = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User  WHERE id NOT IN (SELECT id FROM OrderManager)");
			ResultSet results = statement.executeQuery("select FirstName , LastName, Password,Phonenumber,AFM,User.id, Company,Regular,Season from User INNER JOIN OrderManager on User.id=OrderManager.Id"); 
		    

			while (rs.next()) {
			
				User us = new User();
				us.setFirstName(rs.getString("FirstName"));
				us.setSurName(rs.getString("LastName"));
				us.setPassword(rs.getString("Password"));
				us.setTelephone(rs.getString("Phonenumber"));
				us.setAFM(rs.getString("AFM"));
				us.setId(rs.getString("id"));
				us.setCompany(rs.getString("Company"));
				users.add(us);
				
			}
			for(User u: users)
			{
				int index = users.indexOf(u);
				if (u instanceof Stockkeeper) {
					Stockkeeper st = (Stockkeeper) u;
					users.set(index,st);
				}
				else if(u instanceof Seller){
					Seller se = (Seller) u;
					users.set(index, se);
			}
			}
			while (results.next()) {
				
				OrderManager om = new OrderManager("","","","","","",true,"");
				om.setFirstName(results.getString("FirstName"));
				om.setSurName(results.getString("LastName"));
				om.setPassword(results.getString("Password"));
				om.setTelephone(results.getString("Phonenumber"));
				om.setAFM(results.getString("AFM"));
				om.setId(results.getString("id"));
				om.setCompany(results.getString("Company"));
				if (results.getInt("Regular")== 0) 
					om.setRegular(true);
				else 
					om.setRegular(false);
				om.setSeason(results.getString("Season"));
				users.add(om);
				
			}
			
			c.close();
		}catch(SQLException | ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		
	}
	public ArrayList<User> getUsers()
	{
		return users;
	}
}
