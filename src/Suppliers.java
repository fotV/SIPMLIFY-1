package src;
import java.sql.*;
import java.util.ArrayList;

public class Suppliers extends ListFromDB {
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	
	
	public void extractObjectDB() {

		try {
			

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplier INNER JOIN Buys_from on Supplier.id=Buys_from.Supplier_Id");

			

			
			while (rs.next()) {
				
				Supplier s = new Supplier("", "", "", "", "","");
				s.setName(rs.getString("Name"));
				s.setLastName(rs.getString("LastName"));
				s.setId(rs.getString("id"));
				s.setPhoneNumber(rs.getString("PhoneNumber"));
				s.setAFM(rs.getString("AFM"));
				s.setOrderManagerId(rs.getString("OrderManagerId"));
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
