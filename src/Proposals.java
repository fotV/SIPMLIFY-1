
import java.sql.*;
import java.util.Random;
import java.util.ArrayList;

public class Proposals extends ListFromDB {
	private ArrayList<Order> proposals = new ArrayList<>();
	
	public void extractObjectDB() {
	
		try {
			Connection c = connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(" SELECT  Buys_from.OrderManagerId as OrderManagerId, Forecast_Proposal.Quantity as Quantity, "
					+ "Forecast_Proposal.Supplier_Id as sId, Supplier.Name as sName, Supplier.AFM as sAFM, Forecast_Proposal.datee as Date, "
					+ "Supplies.Price as Price, Forecast_Proposal.TotalPrice as TotalPrice, Forecast_Proposal.PFP_Id as PFP_Id"
					+ "  FROM Supplies inner join Buys_from on Supplies.Supplier_Id=Buys_from.Supplier_Id "
					+ "inner join Forecast_proposal on Supplies.PFP_Id=Forecast_proposal.PFP_Id "
					+ "inner join Supplier on Supplier.id=Supplies.Supplier_Id");
			Statement stmt2 = c.createStatement();
			Statement stmt3 = c.createStatement();
			Statement stmt4 = c.createStatement();
		
			while (rs.next()) {
				
				Order o = new Order("", "", 0.0, "", "", "", "", 0, 0.0, 0.0, "", "","");
				
				Random rand = new Random();
				int n = rand.nextInt(99)*100;
				
				String OMId = "";
				OMId = rs.getString("OrderManagerId");
				o.setOrderManagerId(OMId);
				o.setOrderId(n+"");
				o.setQuantity(rs.getDouble("Quantity"));
				o.setSupplierId(rs.getString("sId"));
				o.setSupplierName(rs.getString("sName"));
				o.setSupplierAFM(rs.getString("sAFM"));
				o.setDate(rs.getString("Date"));
				//o.setStatus(rs.getInt("Status"));
				o.setPrice(rs.getDouble("Price"));
				o.setTotalPrice(rs.getDouble("TotalPrice"));
				String productId = "";
				productId = rs.getString("PFP_Id");
				o.setProductId(productId);
				ResultSet rs2 = stmt2.executeQuery("SELECT Name FROM Product_for_purchase WHERE Id = " + productId);
				o.setProductName(rs2.getString("Name"));
				ResultSet rs3 = stmt3.executeQuery("SELECT Company FROM  User WHERE id = \"" + OMId + "\";");
				String company = "";
				company = rs3.getString("Company");
				ResultSet rs4 = stmt4.executeQuery("SELECT id FROM  User WHERE Company = \"" + company + "\" and id LIKE \"ST%\"");
				o.setStockkeeperId(rs4.getString("Id"));

				proposals.add(o);
				
			}
			stmt.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
			c.close();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}
	
	public void updateObjectDB(){
		try {
			Connection c = connect();
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
			pstmtForInsert.close();
			c.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Order> getProposals() {
		return proposals;
	}

}
