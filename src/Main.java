import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		Users u = new Users();
		u.extractObjectDB();
		for(User k: u.getUsers()) System.out.println(k.getFirstName());
	}
}
