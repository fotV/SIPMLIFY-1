
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

			c = connect();
			statement = c.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM User  WHERE id NOT IN (SELECT id FROM OrderManager)");
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
			for(User user: users)
			{
				int index = users.indexOf(user);
				if (user.getId().startsWith("ST")) {
					Stockkeeper st = new Stockkeeper("","","","","","","");
					st.setFirstName(user.getFirstName()); 
					st.setSurName(user.getSurName());
					st.setPassword(user.getPassword());
					st.setTelephone(user.getPhonenumber()); 
					st.setAFM(user.getAFM());
					st.setId(user.getId());
					st.setCompany(user.getCompany());
					users.set(index,st);
				
				}
				else {
					Seller se = new Seller ("","","","","","","");
					se.setFirstName(user.getFirstName());
					se.setSurName(user.getSurName());
					se.setPassword(user.getPassword());
					se.setCompany(user.getCompany());
					se.setId(user.getId());
					se.setAFM(user.getAFM());
					se.setTelephone(user.getTelephone());
					users.set(index, se);
				
				}
			}
			statement.close();
		}catch(SQLException e){
		e.getStackTrace();
		}
		
		
		try {
			ResultSet results = statement.executeQuery("SELECT FirstName , LastName, Password,Phonenumber,AFM,User.id, Company,Regular,Season FROM User INNER JOIN OrderManager on User.id=OrderManager.Id");
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
				System.out.println(om);
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
