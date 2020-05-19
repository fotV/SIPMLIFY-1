import java.sql.*;
import java.util.ArrayList;

public class Suppliers extends ListFromDB {
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	
	
	public void extractObjectDB() {

		try {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplier");
			
			while (rs.next()) {
				
				Supplier s = new Supplier("", "", "", "", "");
				s.setName(rs.getString("Name"));
				s.setLastName(rs.getString("LastName"));
				s.setId(rs.getString("id"));
				s.setPhoneNumber(rs.getString("PhoneNumber"));
				s.setAFM(rs.getString("AFM"));
				suppliers.add(s);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public ArrayList<Supplier> getSuppliers()
	{
		return suppliers;
	}
	

}
