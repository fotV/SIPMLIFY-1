import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		Users u = new Users();
		u.extractObjectDB();
		StockkeeperForm l = new StockkeeperForm((Stockkeeper) u.getUsers().get(0));
	}
}
