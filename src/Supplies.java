
import java.sql.*;
import java.util.ArrayList;

/**
 * Supplies.java
 * Inherits from ListFromDB.java
 * Purpose: Manages the data from table Supplies (in simplify.db).
 * @author Eleni Polyzoidou, Evangelia Papagiannaki.
 */
public class Supplies extends ListFromDB {
	ArrayList<Suppl> supplies = new ArrayList<>();
	
	/**
	 * Loads data in supplies.
	 */
	@Override
	public void extractObjectDB() {
		Connection c = connect();
		try {
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplies");
			
			while (rs.next()) {

				Suppl s = new Suppl("", "", 0.0);
				s.setProductId(rs.getString("PFP_Id"));
				s.setSupplierId(rs.getString("Supplier_Id"));
				s.setPrice(rs.getDouble("Price"));
				supplies.add(s);
			}
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Uploads data from supplies.
	 */
	@Override
	public void updateObjectDB() {
		Connection c = connect();
		try {
			
			String insertIntoSupplies = "INSERT OR IGNORE INTO Supplies (Supplier_Id, PFP_Id, Price) VALUES (?,?,?);";
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
					stmt.close();
				}
				statementSupplies.executeUpdate();
			}
			statementSupplies.close();
			
			}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Gets the list with objects of type suppl.
	 * @return supplies of type ArrayList<Suppl>
	 */
	public ArrayList<Suppl> getSupplies()
	{
		return supplies;
	}
 
}
