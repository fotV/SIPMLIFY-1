
import java.sql.*;
import java.util.ArrayList;

public class Proposals extends ListFromDB {
	private ArrayList<Order> proposals = new ArrayList<>();
	
	public void extractObjectDB() {
	
		try {
			connect();
			Statement stmt = c.createStatement();
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
				o.setDate(rs.getString("Date"));
				o.setStatus(rs.getInt("Status"));
				o.setPrice(rs.getDouble("Price"));
				o.setTotalPrice(rs.getDouble("TotalPrice"));
				o.setProductName(rs.getString("Name"));
				o.setProductId(rs.getString("PFP_Id"));
				o.setStockkeeperId(rs.getString("StockkeeperId"));
				proposals.add(o);
				
			}
			
			closeConnection();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}
	
	public void updateObjectDB(){
		try {
			connect();
			String stringForInsert = "INSERT OR IGNORE INTO Forecast_Proposal (PFP_Id, datee, Quantity, Supplier_Id, PFPId, TotalPrice)  "
					+ "VALUES (?,?,?,?,?,?);";
			PreparedStatement pstmtForInsert = c.prepareStatement(stringForInsert);
			for (Order or : proposals) {
				
				pstmtForInsert.setString(1 ,or.getProductId());
				pstmtForInsert.setString(2, or.getDate());
				pstmtForInsert.setDouble(3, or.getQuantity());
				pstmtForInsert.setString(4, or.getSupplierId());
				pstmtForInsert.setString(5, or.getProductId());
				pstmtForInsert.setDouble(6, or.getTotalPrice());
				
				pstmtForInsert.executeUpdate();
				
			}
			closeConnection();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Order> getProposals() {
		return proposals;
	}

}
