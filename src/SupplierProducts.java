import java.sql.*;
import java.util.ArrayList;

public class SupplierProducts extends ListFromDB {
	/*
	 * Class 
	 */
	private ArrayList<SupplierProduct> supplierp = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product_for_purchase INNER JOIN OrderManager_Watches_Product "
					+ "ON Product_for_purchase.Id = OrderManager_Watches_Product.PFP_Id");

			while (rs.next()) {
				SupplierProduct sp = new SupplierProduct("", "","", 0.0, 0.0, 0.0, 0.0, 0, 0.0);
				sp.setName(rs.getString("Name"));
				sp.setId(rs.getString("Id"));
				sp.setOrderManagerId(rs.getString("OrderManagerId"));
				sp.setStockAmount(rs.getDouble("StockAmount"));
				sp.setMaxStockAmount(rs.getDouble("MaxStockAmount"));
				sp.setSafetyStock(rs.getDouble("SafetyStock"));
				sp.setAverageMonthlyConsumption(rs.getDouble("AverageMonthlyConsumption"));
				sp.setLeadTime(rs.getInt("Leadtime"));
				sp.setExpectedAmount(rs.getDouble("ExpectedAmount"));
				supplierp.add(sp);
				
			}
			
			closeConnection();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}
	public void updateObjectDB(OrderManager ordermanager) {
		OrderManager om = ordermanager;
		
		try {
			
			connect ();
			String insertIntoPFP = "INSERT OR IGNORE INTO Product_for_purchase (Id, Name, StockAmount, MaxStockAmount,"
					+ " SafetyStock, AverageMonthlyConsumption, Leadtime, ExpectedAmount)  "
				+ "VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement statementPFP = c.prepareStatement(insertIntoPFP);
			String insertIntoWatches = "INSERT OR IGNORE INTO OrderManager_Watches_Product (PFP_Id, OrderManagerId) "
				+ "VALUES (?,?);";
			PreparedStatement statementWatches = c.prepareStatement(insertIntoWatches);
			
			for (SupplierProduct sp:  supplierp) {
				
				
				String updatePFP = "UPDATE Product_for_purchase SET  StockAmount = " + sp.getStockAmount() + 
								", Leadtime = " + sp.getLeadtime() + ", ExpectedAmount = " + sp.getExpectedAmount() +
								" WHERE StockAmount <> "+ sp.getStockAmount() + "or Leadtime <> " + sp.getLeadtime() + 
								"or ExpectedAmount <> " + sp.getExpectedAmount();
				
				
				PreparedStatement statementUpdate= c.prepareStatement(updatePFP);
				
				statementPFP.setString(1 ,sp.getId());
				statementPFP.setString(2, sp.getName());
				statementPFP.setDouble(3, sp.getStockAmount());
				statementPFP.setDouble(4, sp.getMaxStockAmount());
				statementPFP.setDouble(5, sp.getSafetyStock());
				statementPFP.setDouble(6, sp.getAverageMonthlyConsumption());
				statementPFP.setInt(7, sp.getLeadtime());
				statementPFP.setDouble(8, sp.getExpectedAmount());
				
				statementWatches.setString(1, sp.getId());
				statementWatches.setString(2, om.getId());
			
				statementPFP.executeUpdate();
				statementWatches.executeUpdate();
				statementUpdate.executeUpdate();

				updatePFP = "";

			}
			closeConnection();
		}catch(Exception e){
			e.printStackTrace();;
		}
	}
	
	/*
	 * Gets the list of SupplierProduct
	 * @return An ArrayList with SupplierProducts
	 *     name.
	 */
	public ArrayList<SupplierProduct> getSupplierProducts() {
		
		return supplierp;
	}
}
