import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ListFromDB {
	/*
	 * ListFromDB.java
	 * Purpose: Class parent that creates the connection to the database.
	 * @author Eleni Polyzoidou, Evangelia Papagiannaki.
	 * @version 1.0
	 */
	protected Connection c = null;
	
	public ListFromDB(){
		
	}
	
	public Connection connect() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");

		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
		return c;
	}
	public void extractObjectDB() {
		
	}
	
	public void updateObjectDB() {
		
	}
}
