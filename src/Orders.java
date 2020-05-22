package src;
import java.sql.*;
import java.util.ArrayList;

public class Orders extends ListFromDB {
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	
	public void extractObjectDB() {
		
		try {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM view2");
			
			while (rs.next()) {
				Order o = new Order("", "", 0.0, "", "", "", "", 0, 0.0, 0.0, "", "","");
				o.setOrderManagerId(rs.getString("OrderManagerId"));
				o.setOrderId(rs.getString("OrderId"));
				o.setQuantity(rs.getDouble("Quantity"));
				o.setSupplierId(rs.getString("Supplier_Id"));
				o.setSupplierName(rs.getString("SupplierName"));
				o.setSupplierAFM(rs.getString("SupplierAFM"));
				o.setDate(rs.getString("Date"));
				o.setStatus(rs.getInt("Status"));
				o.setPrice(rs.getDouble("Price"));
				o.setTotalPrice(rs.getDouble("TotalPrice"));
				o.setProductName(rs.getString("Name"));
				o.setProductId(rs.getString("PFP_Id"));
				o.setStockkeeperId(rs.getString("StockkeeperId"));
				orders.add(o);
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void updateObjectDB(){
		try {
			String sql1 = "INSERT OR IGNORE INTO Order_for_purchase (OrderId, OrderManagerId, Price, StockkeeperId, Status, Date, Quantity, Supplier_Id, PFP_Id, TotalPrice)  "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?);";
			for (Order or : orders) {
				PreparedStatement pstmt1 = c.prepareStatement(sql1);
				pstmt1.setString(1 ,or.getOrderId());
				pstmt1.setString(2, or.getOrderManagerId());
				pstmt1.setDouble(3, or.getPrice());
				pstmt1.setString(4, or.getStockkeeperId());
				pstmt1.setInt(5, or.getStatus());
				pstmt1.setString(6, or.getDate());
				pstmt1.setDouble(7, or.getQuantity());
				pstmt1.setString(8, or.getSupplierId());
				pstmt1.setString(9, or.getProductId());
				pstmt1.setDouble(10, or.getTotalPrice());
				pstmt1.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Order> getOrders() {
		return orders;
	}
}
