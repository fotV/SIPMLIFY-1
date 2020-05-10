import java.sql.*;
import java.util.ArrayList;

public class Users extends ListFromDB {
	ArrayList<User> users = new ArrayList<>();
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User");
			
			User us = new User("", "", "", "", "", "", "", null);
			while (rs.next()) {
				
				us.setFirstName(rs.getString(FirstName));
				us.setSurName(rs.getString(LastName));
				us.setPassword(rs.getString(Password));
				us.setTelephone(rs.getString(Phonenumber));
				us.setAFM(rs.getString(AFM));
				us.setId(rs.getString(id));
				us.setCompany(rs.getString(Company));
				users.add(us);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
