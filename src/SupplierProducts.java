package src;
import java.sql.*;
import java.util.ArrayList;

public class SupplierProducts extends ListFromDB {
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
			
			//c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void updateObjectDB() {
		
		System.out.print(2);
		String  sql =  "INSERT INTO Product(Id,Name,StockAmount,MaxStockAmount,SafetyStock,AverageMonthlyConsumption,Leadtime,ExpectedAmount)\r\n" + 
				"				  VALUES(?,?,?,?,?,?,?,?)\r\n" + 
				"				  ON CONFLICT(Id) DO UPDATE SET\r\n" + 
				"				    StockAmount = excluded.getStockAmount()"+
				"         WHERE StockAmount<> excluded.getStockAmount()";
		System.out.println(9);
		try {
			System.out.println(0);
			PreparedStatement pstmt = c.prepareStatement(sql);
			for (SupplierProduct sp : supplierp) {
				pstmt.setString(1,sp.getId());
				pstmt.setString(2,sp.getName());
				System.out.println(sp.getStockAmount());
				pstmt.setDouble(3,sp.getStockAmount());
				pstmt.setDouble(4,sp.getMaxStockAmount());
				pstmt.setDouble(5,sp.getSafetyStock());
				pstmt.setDouble(6,sp.getAverageMonthlyConsumption());
				pstmt.setInt(7,sp.getLeadtime());
				pstmt.setDouble(8,sp.getExpectedAmount());
				pstmt.executeUpdate();
				
			}
			
			c.close();
		}catch(Exception e){
			e.printStackTrace();;
		}
	}


	public ArrayList<SupplierProduct> getSupplierProducts() {
		// TODO Auto-generated method stub
		return supplierp;
	}
}
