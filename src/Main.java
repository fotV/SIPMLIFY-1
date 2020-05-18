import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		Users u = new Users();
		u.extractObjectDB();
		
		new SearchForm(1,u.getUsers().get(2));
	}
}
