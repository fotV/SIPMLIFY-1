import java.sql.*;
import java.util.ArrayList;

public class CompanyProducts extends ListFromDB {
	ArrayList<CompanyProduct> companyp = new ArrayList<>();
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product_for_sale");
			
			CompanyProduct cp = new CompanyProduct("", "", 0.0, 0.0, 0.0, 0.0);
			while (rs.next()) {
				
				cp.setName(rs.getString(Name));
				cp.setId(rs.getString(Id));
				cp.setStockAmount(rs.getDouble(StockAmount));
				cp.setMaxStockAmount(rs.getDouble(MaxStockAmount));
				cp.setSafetyStock(rs.getDouble(SafetyStock)));
				//cp.setPrice(rs.getDouble());
				companyp.add(cp);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
