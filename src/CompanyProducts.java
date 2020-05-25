import java.sql.*;
import java.util.ArrayList;

public class CompanyProducts extends ListFromDB {
	/*
	 * Class
	 */
	private ArrayList<CompanyProduct> companyp = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product_for_sale INNER JOIN Seller_Watches_Product "
					+ "ON Product_for_sale.Id = Seller_Watches_Product.PFS_ID");
			
			while (rs.next()) {
				CompanyProduct cp = new CompanyProduct("", "", "", 0.0, 0.0, 0.0, 0.0);
				cp.setName(rs.getString("Name"));
				cp.setId(rs.getString("Id"));
				cp.setSellerId(rs.getString("SellerId"));
				cp.setStockAmount(rs.getDouble("StockAmount"));
				cp.setMaxStockAmount(rs.getDouble("MaxStockAmount"));
				cp.setSafetyStock(rs.getDouble("SafetyStock"));
				cp.setPrice(rs.getDouble("Price"));
				companyp.add(cp);
			
				
			}
			
			closeConnection();
		}catch(Exception e) {
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}

	
public void updateObjectDB() {
		try {
			connect();
			String insertIntoPFS = "INSERT OR IGNORE INTO Product_for_sale (Id, Name, StockAmount, MaxStockAmount, SafetyStock, Price)  "
				+ "VALUES (?,?,?,?,?,?);";
			PreparedStatement statementPFS = c.prepareStatement(insertIntoPFS);
			String insertIntoWatches = "INSERT OR IGNORE INTO Seller_Watches_Product (SellerId, PFS_Id) "
					+ "VALUES (?,?);";
			PreparedStatement statementWatches = c.prepareStatement(insertIntoWatches);
				
			for (CompanyProduct cp:  companyp) {
				
				String updatePFS = "UPDATE Product_for_sale SET  StockAmount = " + cp.getStockAmount() + ", Price = " + cp.getPrice() + 
						" WHERE StockAmount <> "+ cp.getStockAmount() + " or Price <> " + cp.getPrice() ;
				PreparedStatement statementUpdate = c.prepareStatement(updatePFS);
				
				statementPFS.setString(1, cp.getId());
				statementPFS.setString(2, cp.getName());
				statementPFS.setDouble(3, cp.getStockAmount());
				statementPFS.setDouble(4, cp.getMaxStockAmount());
				statementPFS.setDouble(5, cp.getSafetyStock());
				statementPFS.setDouble(6, cp.getPrice());
				
				statementWatches.setString(1, cp.geSellertId());
				statementWatches.setString(2, cp.getId());
				
				statementPFS.executeUpdate();
				statementUpdate.executeUpdate();
				updatePFS = "";
				
			}
			closeConnection();
		}catch(Exception e){
			e.printStackTrace();;
		}
	}
	public ArrayList<CompanyProduct> getCompanyProducts() {
		return companyp;
	}
	
	

}