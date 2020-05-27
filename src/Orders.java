import java.sql.*;
import java.util.ArrayList;

public class Orders extends ListFromDB {
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	
	public void extractObjectDB() {
		Connection c = connect();
		try {
			Statement stmt = c.createStatement ();
			ResultSet rs = stmt.executeQuery("SELECT Order_for_purchase.OrderId as OrderId ,Order_for_purchase.OrderManagerId as OrderManagerId, "
					+ "Order_for_purchase.Price as Price, Order_for_purchase.StockkeeperId as StockkeeperId, Order_for_purchase.Status as Status, "
					+ "Order_for_purchase.Date as Date , Order_for_purchase.Quantity as Quantity, Supplier.id as Supplier_Id, "
					+ "Order_for_purchase.PFP_Id as PFP_Id, Order_for_purchase.TotalPrice as TotalPrice, Supplier.Name as SupplierName, "
					+ "Supplier.AFM as SupplierAFM, Product_for_purchase.Name as Name FROM Order_for_purchase "
					+ "inner join Supplier on Order_for_purchase.Supplier_Id=Supplier.id inner join Product_for_purchase on Product_for_purchase.Id=Order_for_purchase.PFP_Id");
			
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
			rs.close();
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				c.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void updateObjectDB(){
		Connection c = connect();
		try {
			String stringForInsert = "INSERT OR IGNORE INTO Order_for_purchase (OrderId, OrderManagerId, Price, StockkeeperId, Status, Date, Quantity, Supplier_Id, PFP_Id, TotalPrice)  "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pstmtForInsert = c.prepareStatement(stringForInsert);
			String stringForUpdate = "UPDATE Order_for_purchase SET  Status = ? , Price = ?, TotalPrice = ? WHERE OrderId = ?";
			PreparedStatement pstmtForUpdate   = c.prepareStatement(stringForUpdate);
			for (Order or : orders) {
				
				pstmtForUpdate.setInt(1, or.getStatus());
				pstmtForUpdate.setDouble(2, or.getPrice());
				pstmtForUpdate.setDouble(3, or.getTotalPrice());
				pstmtForUpdate.setString(4, or.getOrderId());
				pstmtForUpdate.executeUpdate();
				
				pstmtForInsert.setString(1 ,or.getOrderId());
				pstmtForInsert.setString(2, or.getOrderManagerId());
				pstmtForInsert.setDouble(3, or.getPrice());
				pstmtForInsert.setString(4, or.getStockkeeperId());
				pstmtForInsert.setInt(5, or.getStatus());
				pstmtForInsert.setString(6, or.getDate());
				pstmtForInsert.setDouble(7, or.getQuantity());
				pstmtForInsert.setString(8, or.getSupplierId());
				pstmtForInsert.setString(9, or.getProductId());
				pstmtForInsert.setDouble(10, or.getTotalPrice());
				pstmtForInsert.executeUpdate();
			}

			pstmtForInsert.close();
			pstmtForUpdate.close();
			c.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
}