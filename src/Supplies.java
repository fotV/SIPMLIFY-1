
import java.sql.*;
import java.util.ArrayList;

public class Supplies extends ListFromDB {
	ArrayList<Suppl> supplies = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			Connection c = connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplies");
			
			while (rs.next()) {
				Suppl s = new Suppl("", "", 0.0);
				s.setProductId(rs.getString("PFP_Id"));
				s.setSupplierId(rs.getString("Supplier_Id"));
				s.setPrice(rs.getDouble("Price"));
				supplies.add(s);
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void updateObjectDB()
	{
		/*
		 * MAY HAVE ERRORS!!!! I HAVE NOT TEST IT YET!!!!!!!!!!!
		 */
		try {
			Connection c = connect();
			String insertIntoSupplies = "INSERT OR IGNORE INTO Suppies (Supplier_Id, PFP_Id, Price) VALUES (?,?,?);";
			PreparedStatement statementSupplies = c.prepareStatement(insertIntoSupplies);
			for(Suppl s: supplies) {
				statementSupplies.setString(1, s.getSupplierId());
				statementSupplies.setString(2, s.getProductId());
				if (s.getPrice() != 0.0) {
					statementSupplies.setDouble(3, s.getPrice());}
				else {
					String sql = "select price from Seller INNER JOIN Seller_Watches_Product on Seller.Id = Seller_Watches_Product.SellerId WHERE Seller.Id ="+ s.getSupplierId()+");";
					Statement stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					statementSupplies.setDouble(3, rs.getDouble("Price") );
				}
				statementSupplies.execute();
			}
		c.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Suppl> getSupplies()
	{
		return supplies;
	}
 
}
