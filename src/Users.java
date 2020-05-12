import java.sql.*;
import java.util.ArrayList;

public class Users extends ListFromDB {
	ArrayList<User> users = new ArrayList<User>();
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User");
		    

			while (rs.next()) {
			
				User us = new User();
				us.setFirstName(rs.getString("FirstName"));
				System.out.println(rs.getString("FirstName"));
				us.setSurName(rs.getString("LastName"));
				us.setPassword(rs.getString("Password"));
				us.setTelephone(rs.getString("Phonenumber"));
				us.setAFM(rs.getString("AFM"));
				us.setId(rs.getString("id"));
				us.setCompany(rs.getString("Company"));
				users.add(us);
				
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
