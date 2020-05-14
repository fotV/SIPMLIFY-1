import java.sql.*;
import java.util.ArrayList;

public class Orders extends ListFromDB {
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM view2");
			
			
			while (rs.next()) {
				
				Order o = new Order("", "", 0.0, "", "", "", "", 0, 0.0, 0.0, "", "");
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
				//o.???(rs.getString(StockkeeperId));
				orders.add(o);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}



	public ArrayList<Order> getOrders() {
		return orders;
	}

}
