
import java.sql.*;
import java.util.ArrayList;

public class Supplies extends ListFromDB {
	ArrayList<Suppl> supplies = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplies ");
			
			while (rs.next()) {

				Suppl s = new Suppl("", "", 0.0);
				s.setProductId(rs.getString("PFP_Id"));
				s.setSupplierId(rs.getString("Supplier_Id"));
				s.setPrice(rs.getDouble("Price"));
				supplies.add(s);
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}
	
	public void updateObjectDB()
	{

		/*
		 * MAY HAVE ERRORS!!!! I HAVE NOT TEST IT YET!!!!!!!!!!!
		 */
		try {
			connect();
			String insertIntoSupplies = "INSERT OR IGNORE INTO Supplies (Supplier_Id, PFP_Id, Price) VALUES (?,?,?);";
			PreparedStatement statementSupplies = c.prepareStatement(insertIntoSupplies);
			for(Suppl s: supplies) {
				statementSupplies.setString(1, s.getSupplierId());
				statementSupplies.setString(2, s.getProductId());
				statementSupplies.setDouble(3, s.getPrice());
				statementSupplies.execute();
			}
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public ArrayList<Suppl> getSupplies()
	{
		return supplies;
	}
 
}
