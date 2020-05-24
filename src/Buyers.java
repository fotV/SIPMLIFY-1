
import java.sql.*;
import java.util.ArrayList;

public class Buyers extends ListFromDB {
	private ArrayList<Buyer> buyers = new ArrayList<Buyer>();
	
	
	public void extractObjectDB() {
		
		try {
			
			connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Client INNER JOIN Sells_to on Client.Id = Sells_to.ClientId");
			while (rs.next()) {
				
				Buyer b = new Buyer("","", "", "", "","");
				b.setName(rs.getString("Name"));
				b.setLastName(rs.getString("LastName"));
				b.setId(rs.getString("Id"));
				//b.setPhoneNumber(rs.getString("PhoneNumber"));
				b.setAFM(rs.getString("AFM"));
				b.setSellerId(rs.getString("SellerId"));
				buyers.add(b);			

			}
			closeConnection();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}

	public void updateObjectFromDB(){
		try {
			connect();
			String insertIntoClient = "INSERT OR IGNORE INTO Client (Id, Name, LastName, AFM, PhoneNumber) VALUES (?,?,?,?,?);";
			String insertIntoSells_to = "INSERT OR IGNORE INTO Sells_to (SellerId, ClientId) VALUES (?,?);";
			PreparedStatement statementClient = c.prepareStatement(insertIntoClient);
			PreparedStatement statementSells_to = c.prepareStatement(insertIntoSells_to);
			for (Buyer b:  buyers) {
				statementClient.setString(1 ,b.getId());
				statementClient.setString(2, b.getName());
				statementClient.setString(3, b.getLastName());
				statementClient.setString(4, b.getPhoneNumber());
				statementClient.setString(5, b.getAFM());
				
				statementSells_to.setString(1, b.getId());
				statementSells_to.setString(2, b.getSellerId());
				
				statementClient.executeUpdate();	
				statementSells_to.executeUpdate();
			}
			closeConnection();
		}catch(Exception e){
				e.printStackTrace();;
		}
	}

	public ArrayList<Buyer> getBuyers()
	{
		return buyers;
	}


}
