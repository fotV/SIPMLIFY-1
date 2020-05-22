import java.sql.*;
import java.util.ArrayList;

public class Supplies extends ListFromDB {
	ArrayList<Suppl> supplies = new ArrayList<>();
	
	public void extractObjectDB() {
		
		try {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplies");
			
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
		
	}
	public ArrayList<Suppl> getSupplies()
	{
		return supplies;
	}
 
}
