import java.sql.*;
import java.util.ArrayList;

public class Proposals extends ListFromDB {
	private ArrayList<Order> proposals = new ArrayList<>();
	
	public void extractObjectDB() {
	
		try {
			
			ResultSet rs = stmt.executeQuery(" SELECT * FROM Supplies inner join Buys_from on Supplies.Supplier_Id=Buys_from.Supplier_Id "
					+ "inner join Forecast_proposal on Supplies.PFP_Id=Forecast_proposal.PFP_Id "
					+ "inner join Supplier on Supplier.id=Supplies.Supplier_Id");

			
			Order o = new Order("", "", 0.0, "", "", "", "", 0, 0.0, 0.0, "", "","");
			while (rs.next()) {
				
				o.setOrderManagerId(rs.getString("OrderManagerId"));
				o.setOrderId(rs.getString("OrderId"));
				o.setQuantity(rs.getDouble("Quantity"));
				o.setSupplierId(rs.getString("Supplier_Id"));
				o.setSupplierName(rs.getString("SupplierName"));
				o.setSupplierAFM(rs.getString("SupplierAFM"));
				o.setDate(rs.getString("Datee"));
				o.setStatus(rs.getInt("Status"));
				o.setPrice(rs.getDouble("Price"));
				o.setTotalPrice(rs.getDouble("TotalPrice"));
				o.setProductName(rs.getString("Name"));
				o.setProductId(rs.getString("PFP_Id"));
				o.setStockkeeperId(rs.getString("StockkeeperId"));
				proposals.add(o);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}
	
	public ArrayList<Order> getProposals() {
		return proposals;
	}

}
