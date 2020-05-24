
import java.sql.*;
import java.util.ArrayList;

public class Users extends ListFromDB {
	private ArrayList<User> users = new ArrayList<User>();

	private Statement statement = null;		//statement for users that have type OrderManager
	/**
	 *
	 */

	public void extractObjectDB() {

		try {

			connect();

			statement = c.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM User  WHERE id NOT IN (SELECT id FROM OrderManager)");
			ResultSet results = statement.executeQuery("SELECT FirstName , LastName, Password,Phonenumber,AFM,User.id, Company,Regular,Season FROM User INNER JOIN OrderManager on User.id=OrderManager.Id"); 
		    

			while (rs.next()) {
				
				User us = new User();
				us.setFirstName(rs.getString("FirstName"));
				us.setSurName(rs.getString("LastName"));
				us.setPassword(rs.getString("Password"));
				us.setTelephone(rs.getString("Phonenumber"));
				us.setAFM(rs.getString("AFM"));
				us.setId(rs.getString("id"));
				us.setCompany(rs.getString("Company"));
				users.add(us);
			}
			for(User u: users)
			{
				System.out.println(u.getCompany().getClass());
				int index = users.indexOf(u);
				if (u.getId().startsWith("ST")) {
					Stockkeeper st = new Stockkeeper(u.getFirstName(), u.getSurName(), u.getPassword(), u.getPhonenumber(), u.getAFM(), u.getId(), u.getCompany());
					users.set(index,st);
				}
				else {
					Seller se = new Seller (u.getFirstName(),u.getSurName(),u.getPassword(),u.getPhonenumber(),u.getAFM(),u.getId(),u.getCompany());
					users.set(index, se);
					System.out.println(users.get(index).getClass());
				}
			}
			while (results.next()) {
				
				OrderManager om = new OrderManager("","","","","","",true,"","");
				om.setFirstName(results.getString("FirstName"));
				om.setSurName(results.getString("LastName"));
				om.setPassword(results.getString("Password"));
				om.setTelephone(results.getString("Phonenumber"));
				om.setAFM(results.getString("AFM"));
				om.setId(results.getString("id"));
				om.setCompany(results.getString("Company"));
				if (results.getInt("Regular")== 0) 
					om.setRegular(true);
				else 
					om.setRegular(false);
				om.setSeason(results.getString("Season"));
				users.add(om);
				
			}
		}catch(SQLException e){
			e.getStackTrace();
		}
		
		
	}
	
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
}
