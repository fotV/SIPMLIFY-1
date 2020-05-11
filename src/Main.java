import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		Users user = new Users();
		user.extractObjectDB();
		ArrayList<User> users = user.getUsers();
		for (User u:users)
		{
			System.out.print(u.getName()+'\n');
		}
		System.out.println(users.size());
		
	
	}
}
