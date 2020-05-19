package src;
import java.sql.*;
import java.util.ArrayList;

public class Buyers extends ListFromDB {
	private ArrayList<Buyer> buyers = new ArrayList<>();
	
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Client");
			
			
			while (rs.next()) {
				
				Buyer b = new Buyer("","", "", "", "");
				b.setName(rs.getString("Name"));
				b.setLastName(rs.getString("LastName"));
				b.setId(rs.getString("Id"));
				//s.setPhoneNumber(rs.getString());
				b.setAFM(rs.getString("AFM"));
				buyers.add(b);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public ArrayList<Buyer> getBuyers()
	{
		return buyers;
	}


}
