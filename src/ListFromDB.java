import java.sql.Connection;
import java.sql.DriverManager;

public class ListFromDB {
	Connection c = null;
	ListFromDB(){
		Connection c = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void extractObjectDB() {
		
	}
	
	public void updateObjectDB() {
		
	}
}
