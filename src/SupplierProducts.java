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
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void updateObject() {
		
		String  sql = "INSERT INTO Product(Id,Name,StockAmount,MaxStockAmount,SafetyStock,AverageMonthlyConsumption,Leadtime,ExpectedAmount)\r\n" + 
				"				  VALUES(?,?,?,?,?,?,?,?)\r\n" + 
				"				  ON CONFLICT(Id) DO UPDATE SET\r\n" + 
				"				    StockAmount = sp.getStockAmount()"+
				"         WHERE StockAmount<> sp.getStockAmount();";
		try {
			for (SupplierProduct sp : supplierp) {
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public ArrayList<SupplierProduct> getSupplierProducts() {
		// TODO Auto-generated method stub
		return supplierp;
	}
}
