import java.awt.EventQueue;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		Users u = new Users();
		u.extractObjectDB();
		//for(User k: u.getUsers()) System.out.println(k.getFirstName());
		//new SearchForm(1,u.getUsers().get(2));
		
		Suppliers s = new Suppliers();
		new SupplierForm(s);
		s.extractObjectDB();
		
		new LogginForm(u);
		
		
		
		
		
		
		
		
		
		 
	}
}
