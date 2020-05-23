
import java.sql.*;
import java.util.ArrayList;

public class SupplierProducts extends ListFromDB {
	/*
	 * Class 
	 */
	private ArrayList<SupplierProduct> supplierp = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			Connection c = connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM View3");
			
	
			while (rs.next()) {
				
				SupplierProduct sp = new SupplierProduct("", "","", 0.0, 0.0, 0.0, 0.0, 0, 0.0);
				sp.setName(rs.getString("Name"));
				sp.setId(rs.getString("Id"));
				sp.setOrderManagerId(rs.getString("OrderManagerId"));
				sp.setStockAmount(rs.getDouble("StockAmount"));
				sp.setMaxStockAmount(rs.getDouble("MaxStockAmount"));
				sp.setSafetyStock(rs.getDouble("SafetyStock"));
				sp.setAverageMonthlyConsumption(rs.getDouble("AverageMonthlyConsumption"));
				sp.setLeadtime(rs.getInt("Leadtime"));
				sp.setExpectedAmount(rs.getDouble("ExpectedAmount"));
				supplierp.add(sp);
				
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void updateObjectDB() {
		
		
		try {
			Connection c = connect ();
			String insertIntoPFP = "INSERT OR IGNORE INTO Product_for_purchase (Id, Name, StockAmount, MaxStockAmount, SafetyStock, AverageMonthlyConsumption, Leadtime, ExpectedAmount)  "
				+ "VALUES (?,?,?,?,?,?,?,?);";
			int numbOfRows = 0; // number of affected rows after UPDATE Statement was executed
			PreparedStatement statementPFP = c.prepareStatement(insertIntoPFP);
			for (SupplierProduct sp:  supplierp) {
				
				
				String updatePFP = "UPDATE Product_for_purchase SET  StockAmount = " + sp.getStockAmount() + " WHERE StockAmount = "+ sp.getStockAmount() ;
				
				
				PreparedStatement statementUpdate= c.prepareStatement(updatePFP);
				
				statementPFP.setString(1 ,sp.getId());
				statementPFP.setString(2, sp.getName());
				statementPFP.setDouble(3, sp.getStockAmount());
				statementPFP.setDouble(4, sp.getMaxStockAmount());
				statementPFP.setDouble(5, sp.getSafetyStock());
				statementPFP.setDouble(6, sp.getAverageMonthlyConsumption());
				statementPFP.setInt(7, sp.getLeadtime());
				statementPFP.setDouble(8, sp.getExpectedAmount());
			
				statementPFP.executeUpdate();
				statementUpdate.executeUpdate();

				updatePFP = "";
			}
			System.out.println(numbOfRows);
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
