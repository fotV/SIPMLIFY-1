import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ListFromDB {
	/*
	 * ListFromDB.java
	 * Purpose: Class parent that creates the connection to the database.
	 * @author Eleni Polyzoidou, Evangelia Papagiannaki.
	 * @version 1.0
	 */
	protected Connection c = null;
	protected Statement stmt = null;
	public ListFromDB(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			stmt = (Statement) c.createStatement();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void extractObjectDB() {
		
	}
	
	public void updateObjectDB() {
		
	}
}
