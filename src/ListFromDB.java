
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ListFromDB.java
 * Purpose: Class parent that creates the connection to the simplify.db.
 * @author Eleni Polyzoidou, Evangelia Papagiannaki.
 */
public class ListFromDB {
	
	/**
	 * Constractor.
	 */
	public ListFromDB(){
		
	}
	
	/**
	 * The method that creates the connection to the database.
	 * @return c of type Connection, when connection to the database is successful.
	 */
	public Connection connect() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
		    c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			
		}catch(Exception e){
			System.out.println(this.getClass());
			System.out.println(e);
		}
		
		return c;		
	}
	
	/**
	 * Loads data in list.
	 */
	public void extractObjectDB() {
		
	}
	
	/**
	 * Uploads data from list.
	 */
	public void updateObjectDB() {
		
	}
}
