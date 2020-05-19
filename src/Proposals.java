package src;
import java.sql.*;
import java.util.ArrayList;

public class Proposals extends ListFromDB {
	private ArrayList<Order> proposals = new ArrayList<>();
	
	public void extractObjectDB() {
	
		try {
			
			ResultSet rs = stmt.executeQuery(" SELECT * FROM View1 ");
			
			Order o = new Order("", "", 0.0, "", "", "", "", 0, 0.0, 0.0, "", "");
			while (rs.next()) {
				
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
				proposals.add(o);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public ArrayList<Order> getProposals() {
		return proposals;
	}

}
