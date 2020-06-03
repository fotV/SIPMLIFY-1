
public class Main {

	public static void main(String[] args) {

		
		Users u = new Users();
		u.extractObjectDB();
	
		OrderManager k = (OrderManager) u.getUsers().get(8);
		new OrderManagerForm(k);

	}

}

