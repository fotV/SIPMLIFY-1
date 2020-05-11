import java.sql.*;
import java.util.ArrayList;

public class Supplies extends ListFromDB {
	ArrayList<Suppl> supplies = new ArrayList<>();
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplies");
			
			Suppl s = new Suppl("", "", 0.0);
			while (rs.next()) {
				
				b.setProductId(rs.getString("PFP_Id"));
				b.setSellerId(rs.getString("Supplier_Id"));
				b.setPrice(rs.getDouble("Price"));
				supplies.add(s);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
 
}
