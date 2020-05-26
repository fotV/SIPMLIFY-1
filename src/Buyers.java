
import java.sql.*;
import java.util.ArrayList;

public class Buyers extends ListFromDB {
	private ArrayList<Buyer> buyers = new ArrayList<Buyer>();
	
	
	public void extractObjectDB() {
		
		try {
			
			Connection c = connect();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Client INNER JOIN Sells_to on Client.Id = Sells_to.ClientId");
			while (rs.next()) {
				
				Buyer b = new Buyer("","", "", "","");
				b.setName(rs.getString("Name"));
				b.setLastName(rs.getString("LastName"));
				b.setId(rs.getString("Id"));
				b.setAFM(rs.getString("AFM"));
				b.setSellerId(rs.getString("SellerId"));
				buyers.add(b);			

			}
			stmt.close();
			c.close();
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
	}

	public void updateObjectDB(){
		try {
			
			Connection c = connect();
			
			String insertIntoClient = "INSERT OR IGNORE INTO Client (Id, Name, LastName, AFM) VALUES (?,?,?,?);";
			String insertIntoSells_to = "INSERT OR IGNORE INTO Sells_to (SellerId, ClientId) VALUES (?,?);";
			PreparedStatement statementClient = c.prepareStatement(insertIntoClient);
			PreparedStatement statementSells_to = c.prepareStatement(insertIntoSells_to);
			for (Buyer b:  buyers) {
				statementClient.setString(1 ,b.getId());
				statementClient.setString(2, b.getName());
				statementClient.setString(3, b.getLastName());
				statementClient.setString(4, b.getAFM());
				
				statementSells_to.setString(1, b.getSellerId());
				statementSells_to.setString(2, b.getId());
				
				statementClient.executeUpdate();	
				statementSells_to.executeUpdate();
				
			}
			statementClient.close();
			statementSells_to.close();
			c.close();
		}catch(Exception e){
				e.printStackTrace();;
		}
	}

	public ArrayList<Buyer> getBuyers()
	{
		return buyers;
	}


}
