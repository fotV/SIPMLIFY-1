import java.sql.*;
public class Users extends ListFromDB {
	
	public Users(){
		Connection c = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("SQLite DB connected");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
