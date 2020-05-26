
import java.sql.*;
import java.util.ArrayList;

public class Suppliers extends ListFromDB {
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	
	
	public void extractObjectDB() {

		try {

			Connection c = connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplier INNER JOIN Buys_from on Supplier.id = Buys_from.Supplier_Id");


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
			
			stmt.close();
			c.close();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}

	public void updateObjectDB() {
		try {
			Connection c = connect();
			String insertIntoSupplier = "INSERT OR IGNORE INTO Supplier (Id, Name, LastName, PhoneNumber, AFM) VALUES (?,?,?,?,?);";
			String insertIntoBuys_from = "INSERT OR IGNORE INTO Buys_from (Supplier_Id, OrderManagerId) VALUES (?,?) ;";
			PreparedStatement supplierStatement = c.prepareStatement(insertIntoSupplier);
			PreparedStatement buys_fromStatement = c.prepareStatement(insertIntoBuys_from);
			for (Supplier sup:  suppliers) {
				supplierStatement.setString(1 ,sup.getId());
				supplierStatement.setString(2, sup.getName());
				supplierStatement.setString(3, sup.getLastName());
				supplierStatement.setString(4, sup.getPhoneNumber());
				supplierStatement.setString(5, sup.getAFM());
				
				buys_fromStatement.setString(1,sup.getId());
				buys_fromStatement.setString(2, sup.getOrderManagerId());
				
				buys_fromStatement.executeUpdate();
				supplierStatement.executeUpdate();	
			}
			
			supplierStatement.close();
			buys_fromStatement.close();
			c.close();
		}catch(Exception e){
				e.printStackTrace();;
		}
	}
	
	public ArrayList<Supplier> getSuppliers(){
		return suppliers;
	}
	

}
