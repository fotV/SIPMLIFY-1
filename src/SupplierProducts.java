package src;
import java.sql.*;
import java.util.ArrayList;

public class SupplierProducts extends ListFromDB {
	/*
	 * Class 
	 */
	private ArrayList<SupplierProduct> supplierp = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			
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
			
			String sql1 = "INSERT OR IGNORE INTO Product_for_purchase (Id, Name, StockAmount, MaxStockAmount, SafetyStock, AverageMonthlyConsumption, Leadtime, ExpectedAmount)  "
				+ "VALUES (?,?,?,?,?,?,?,?);";
			int numbOfRows = 0; // number of affected rows after UPDATE Statement was executed
			PreparedStatement pstmt2 = c.prepareStatement(sql1);
			for (SupplierProduct sp:  supplierp) {
				
				
				String sql2 = "UPDATE Product_for_purchase SET  StockAmount = " + sp.getStockAmount() + " WHERE StockAmount = "+ sp.getStockAmount() ;
				
				
				PreparedStatement pstmt1 = c.prepareStatement(sql2);
				
				
				
				pstmt2.setString(1 ,sp.getId());
				pstmt2.setString(2, sp.getName());
				pstmt2.setDouble(3, sp.getStockAmount());
				pstmt2.setDouble(4, sp.getMaxStockAmount());
				pstmt2.setDouble(5, sp.getSafetyStock());
				pstmt2.setDouble(6, sp.getAverageMonthlyConsumption());
				pstmt2.setInt(7, sp.getLeadtime());
				pstmt2.setDouble(8, sp.getExpectedAmount());
				
				numbOfRows += pstmt1.executeUpdate();
				pstmt2.executeUpdate();
				
				sql1 = "";
				sql2 = "";
				
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
