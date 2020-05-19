
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ListFromDB {
	//connection with DataBase
	protected Connection c = null;
	protected Statement stmt = null;
	ListFromDB(){
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			stmt = (Statement) c.createStatement();
			//System.out.println("SQLite DB connected");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void extractObjectDB() {
		
	}
	
	public void updateObjectDB() {
		
	}
}
