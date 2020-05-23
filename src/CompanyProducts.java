
import java.sql.*;
import java.util.ArrayList;

public class CompanyProducts extends ListFromDB {
	private ArrayList<CompanyProduct> companyp = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			Connection c = connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product_for_sale INNER JOIN Seller_Watches_Product on Product_for_sale.Id = Seller_Watches_Product.PFS_Id");
			while (rs.next()) {
				
				CompanyProduct cp = new CompanyProduct("","",0.0,0.0,0.0,0.0);
				cp.setName(rs.getString("Name"));
				cp.setId(rs.getString("Id"));
				cp.setStockAmount(rs.getDouble("StockAmount"));
				cp.setMaxStockAmount(rs.getDouble("MaxStockAmount"));
				cp.setSafetyStock(rs.getDouble("SafetyStock"));
				cp.setPrice(rs.getDouble("Price"));
				companyp.add(cp);
				
			}
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public ArrayList<CompanyProduct> getCompanyProducts()
	{
		return companyp;
	}

}
